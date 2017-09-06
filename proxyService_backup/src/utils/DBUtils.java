package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��ݿ�Ĺ�����
 * @author dpb
 *
 */
public class DBUtils {
	private static String className = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/pln_live";
	private static String user = "root";
	private static String password = "sun";

	/**
	 * ��������ṩһ����ݿ�����ͨ��
	 * @returns
	 */
	public static Connection getConnection(){
		try {
			// 1.ע��ͼ�����ݿ������
			Class.forName(className);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �ر���ݿ���ص���Դ
	 * @param conn
	 * @param ps
	 */
	public static void close(Connection conn , PreparedStatement ps){
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * �ر���ݿ���ص���Դ
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void close(Connection conn , PreparedStatement ps,ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
