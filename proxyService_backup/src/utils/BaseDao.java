package utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ��ݿ�����Ĺ�����
 * @author dpb
 *
 */
public class BaseDao {

	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;

	/**
	 * ��ݿ���ӣ��޸ģ�ɾ��Ĺ�������
	 * @param sql ��Ҫִ�е�sql���
	 * @param objs �ɱ�Ĳ����б�(����) 
	 * 			        �ò���ֻ�ܷ������βε����һ��
	 * 			   sql�е�ռλ���Ӧ�Ĳ���
	 * @return
	 * 		-1 ��ʾִ�г���
	 * 		����ֵ ��ʾӰ�������
	 */
	public static int baseUpdate(String sql,Object ... objs){
		// ��ȡ��ݿ������ͨ��
		conn = DBUtils.getConnection();
		// ����sql���
		// ִ��sql ���
		try {
			// ͨ��c3p0��ȡ����ͨ��
			//conn = DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��sql����е�ռλ����и�ֵ
			if(objs != null){
				// ��������б��ռλ����и�ֵ
				for(int i = 0 ; i < objs.length ; i++){
					ps.setObject(i+1, objs[i]);
				}	
			}
			// ִ��sql��䷵��Ӱ�������
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			// �ر���Դ
			DBUtils.close(conn, ps);
		}
		return -1;
	}
	public static <K,V> Map<K,V> baseQueryMap(String sql , String key,String value,Object node){
		Map<K,V> map = new HashMap<K, V>();
		conn = DBUtils.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			if(node!=null){
				ps.setObject(1, node);
			}
			rs=ps.executeQuery();
			while(rs.next()){
				map.put((K)rs.getObject(key),(V)rs.getObject(value));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtils.close(conn, ps, rs);
		}
		return map;
	}
	/**
	 * ��ѯ��ṹ�����������ļ�¼��
	 * @param sql ��Ҫִ�е�sql���
	 * @param objs sql����ж�Ӧ��ռλ���Ӧ�Ĳ���
	 * @return
	 * 		  -1 ��ʾִ�г���
	 *        ����ֵ ��ʾ��¼������
	 */
	public static int baseQueryForCount(String sql,Object ... objs){
		conn = DBUtils.getConnection();
		try {
			// ͨ��c3p0��ȡ����ͨ��
			//conn =  DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��ռλ����и�ֵ
			if(objs != null){
				for(int i = 0 ; i < objs.length ; i++){
					ps.setObject(i+1, objs[i]);
				}
			}
			// ��ʾ��ִ��sql���
			rs = ps.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// �ر���Դ
			DBUtils.close(conn, ps, rs);
		}
		return -1;
	}
	
	/**
	 * ��ѯ������¼�������ض�Ӧ�Ķ���
	 * @param sql ��Ҫִ�е�sql���
	 * @param cls ���ض����Ӧ�������
	 * @param objs sql����ж�Ӧ��ռλ��Ĳ���
	 * @return
	 * 		���ط�װ�в�ѯ��¼�Ķ���
	 */
	public static <T> T baseQueryById(String sql,Class cls,Object ... objs){
		// ��ȡ��ݿ������ͨ��
		conn = DBUtils.getConnection();
		try {
			// ͨ��c3p0��ȡ����ͨ��
			//conn =  DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��ռλ����и�ֵ
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			// ִ��sql���
			rs = ps.executeQuery();
			// Ԫ���
			ResultSetMetaData md = rs.getMetaData();
			int rowCount = md.getColumnCount();
			//System.out.println("�ܹ��ж����У�"+rowCount);
			if(rs.next()){
				// 2. ��ȡ��װ��ݵĶ�Ӧ�Ķ���
				Object obj = cls.newInstance();
				//System.out.println(obj.getClass());
				// 1. �����м�¼�е�ÿһ���ֶμ���Ӧ��ֵȡ������
				for (int i = 0; i < rowCount; i++) {
					String name = md.getColumnLabel(i+1).toLowerCase();//id name sex
					Object value = rs.getObject(name);//1  ����  ��    id=1   name=����
					// ����ѯ���ֶε�ֵΪ�գ���ô��û�б�Ҫ���ո�ֵ������������
					if(value == null){
						continue;
					}
					//System.out.println(name+":"+value+"���ͣ�"+value.getClass());
					// System.out.println(name+":"+value);
					// 3. ����ѯ���ֶε�ֵ���浽��Ӧ�Ķ���ĳ�Ա����(����)��
					// �ж���������Ƿ���ڱ����е��ֶζ�Ӧ�ĳ�Ա����
					if(hasField(cls, name)){
						// ��ݲ�ѯ���ֶε���ƻ�ȡ������ж�Ӧ�ĳ�Ա����
						Field field = cls.getDeclaredField(name);
						//System.out.println(field.getName());
						// �����˽�г�Ա������ֵ
						field.setAccessible(true);
						if(value instanceof BigDecimal){
							// value ����������Ҳ������С��
							BigDecimal bigValue = (BigDecimal) value;
							// �жϳ�Ա������ʲô���͵�
							if(field.getType().getName().equals("int")){
								// ��ֵ�������Ķ���ĳ�Ա����   setsid()
								field.set(obj, bigValue.intValue());
							}else{
								field.set(obj, bigValue.doubleValue());
							}
						}else{
							// ��ֵ�������Ķ���ĳ�Ա����
							field.set(obj, value);
						}
					}
				}
				// 4. ���ض�Ӧ�Ķ���
				return (T) obj;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn, ps, rs);
		}
		return null;
	}
	/**
	 * ��ѯ�������
	 * @param sql ��Ҫִ�е�sql���
	 * @param cls ���ض����Ӧ�������
	 * @param objs sql����ж�Ӧ��ռλ��Ĳ���
	 * @return
	 * 		��ѯ�����
	 */
	public static <T> List<T> baseQueryMapToObj(String sql,Class cls,Object ... objs){
		List<T> list = new ArrayList<>();
		// ��ȡ��ݿ������ͨ��
		conn = DBUtils.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			rs = ps.executeQuery();
			int rowCount = 0;
			String flag = "";
			Object obj = cls.newInstance();
			while(rs.next()){
				if(!rs.getObject("obj_contentid").toString().equals(flag)){
					flag = rs.getObject("obj_contentid").toString();
					list.add((T)obj);
					if(hasField(cls, "contentid")){
						Field field = cls.getDeclaredField("contentid");
						field.setAccessible(true);
						field.set(list.get(rowCount), flag);
					}
				}
				String name = rs.getObject("property_name").toString().toLowerCase();
				String text = rs.getObject("property_text").toString();
//				System.out.println(name+":"+text);
				if(hasField(cls, name)){
					Field field = cls.getDeclaredField(name);
					field.setAccessible(true);
					field.set(list.get(rowCount), text);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(conn, ps, rs);
		}
		return list;
	}
	public static <T> List<T> baseQueryObject(String sql,Class cls,Object ... objs){
		List<T> list = new ArrayList<>();
		// ��ȡ��ݿ������ͨ��
		conn = DBUtils.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			// ִ��sql���
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			while(rs.next()){
				String name = md.getColumnLabel(1);
				T obj = (T)rs.getObject(name);
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static <T> List<T> baseQuery(String sql,Class cls,Object ... objs){
		List<T> list = new ArrayList<>();
		// ��ȡ��ݿ������ͨ��
		conn = DBUtils.getConnection();
		try {
			// ͨ��c3p0��ȡ����ͨ��
			//conn = DataSourceConfig.getDataSource().getConnection();
			ps = conn.prepareStatement(sql);
			// ��ռλ����и�ֵ
			if(objs != null){
				for (int i = 0; i < objs.length; i++) {
					ps.setObject(i+1, objs[i]);
				}
			}
			// ִ��sql���
			rs = ps.executeQuery();
			// Ԫ���
			ResultSetMetaData md = rs.getMetaData();
			int rowCount = md.getColumnCount();
			//System.out.println("�ܹ��ж����У�"+rowCount);
			while(rs.next()){
				// 2. ��ȡ��װ��ݵĶ�Ӧ�Ķ���
				Object obj = cls.newInstance();
				//System.out.println(obj.getClass());
				// 1. �����м�¼�е�ÿһ���ֶμ���Ӧ��ֵȡ������
				for (int i = 0; i < rowCount; i++) {
					String name = md.getColumnLabel(i+1).toLowerCase();
					Object value = rs.getObject(name);
					// ����ѯ���ֶε�ֵΪ�գ���ô��û�б�Ҫ���ո�ֵ������������
					if(value == null){
						continue;
					}
					// System.out.println(name+":"+value+"���ͣ�"+value.getClass());
					// System.out.println(name+":"+value);
					// 3. ����ѯ���ֶε�ֵ���浽��Ӧ�Ķ���ĳ�Ա����(����)��
					// �ж���������Ƿ���ڱ����е��ֶζ�Ӧ�ĳ�Ա����
					if(hasField(cls, name)){
						// ��ݲ�ѯ���ֶε���ƻ�ȡ������ж�Ӧ�ĳ�Ա����
						Field field = cls.getDeclaredField(name);
						//System.out.println(field.getName());
						// �����˽�г�Ա������ֵ
						field.setAccessible(true);
						if(value instanceof BigDecimal){
							// value ����������Ҳ������С��
							BigDecimal bigValue = (BigDecimal) value;
							// �жϳ�Ա������ʲô���͵�
							if(field.getType().getName().equals("int")){
								// ��ֵ�������Ķ���ĳ�Ա����
								field.set(obj, bigValue.intValue());
							}else{
								field.set(obj, bigValue.doubleValue());
							}
						}else{
							// ��ֵ�������Ķ���ĳ�Ա����
							field.set(obj, value);
						}
					}
				}
				// 4. ������ļ�¼���浽������
				list.add((T) obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(conn, ps, rs);
		}
		return list;
	}
	
	/**
	 * �ж���������Ƿ����name����
	 * @param cls
	 * @param name
	 * @return
	 * 		true ����
	 * 		false ������
	 */
	public static boolean hasField(Class cls,String name){
		// ȡ��������е����е�����
		Field[] fls = cls.getDeclaredFields();
		for (Field field : fls) {
			//System.out.println(field.getName());
			if(field.getName().equals(name.trim())){
				return true;
			}
		}
		return false;
	}
	
	/*public static void fun1(int a,Object ... objs){
		System.out.println("������...");
		// ȡ���ɱ䳤�ȵĲ����б��е����
		for (int i = 0; i < objs.length; i++) {
			System.out.println(objs[i]);
		}
	}
	*/
	
	
	
}
