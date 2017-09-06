package service;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;











import model.Channel;
import model.ContentDeploy;
import model.Mapping;
import model.PhysicalChannel;
import model.Picture;
import model.ScheduleRecord;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import utils.BaseDao;
import dao.IDao;
import dao.impl.DaoImpl;
/*
 * 消息处理对象
 */
public class MessageHandler {
	static IDao dao = new DaoImpl();
	//消息处理对象的主方法，只需调用只一个就行
	public void resultHandler(ContentDeploy cd){
		//将传进来的数据先入库
		String sql = "insert into soap (cmsid,sopid,correlateid,cmdfileurl,now)values(?,?,?,?,now())";
		BaseDao.baseUpdate(sql, cd.getCMSID(),cd.getSOPID(),cd.getCorrelateID(),cd.getCmdFileURL());
		//如果文件url为xml，则调用自身方法解析
		if(cd.getCmdFileURL().endsWith("xml"))
			this.handle(cd.getCMSID(), cd.getSOPID(), cd.getCorrelateID(), 0, "", cd.getCmdFileURL());
	}
	//解析xml方法
	//参数将传递给dao
	public void handle(String CMSID, String SOPID, String correlateID, 
    		int resultCode, String errorDescription, String cmdFileURL){
		//构造工厂
        DocumentBuilderFactory fctry = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder budr = fctry.newDocumentBuilder();
			Document doc = budr.parse(cmdFileURL);
			Element root = doc.getDocumentElement();
			//获取Object标签下的子标签
			NodeList e = root.getElementsByTagName("Objects").item(0).getChildNodes();
			for (int i = 0; i < e.getLength(); i++) {
				Node nd = e.item(i);
				String action = "";
				//获取Object标签
				if(nd.getNodeName().equals("Object")){
					//获取Object标签的属性列表
					NamedNodeMap nl = nd.getAttributes();
					//获取对象类型
					String elementtype = nl.getNamedItem("ElementType").getNodeValue().toLowerCase();
					//对象的属性需要一个头，以避免关键字冲突
					String head = elementtype.substring(0, 1)+"_";
					//获取对象的class
					Class cls = getCls(elementtype);
					//通过class反射生成对象
					Object obj = cls.newInstance();
					for (int j = 0; j < nl.getLength(); j++) {
						Node n = nl.item(j);
						String nodename = n.getNodeName().toLowerCase();
						//拼凑属性名
						String fname = head+nodename;
						//判断是否存在该属性名
						if(hasField(cls, fname)){
							//获取该属性
							Field field = cls.getDeclaredField(fname);
							//解除private限制
							field.setAccessible(true);
							//对对象的该属性赋值
							field.set(obj, n.getNodeValue());
						}
						//获取action操作
						if(nodename.equals("action")){
							action = n.getNodeValue().toLowerCase();
						}
					}
					//再获取该对象的子标签
					NodeList nls = nd.getChildNodes();
					for (int j = 0; j < nls.getLength(); j++) {
						Node n = nls.item(j);
						if(n.getNodeName().equals("Property")){
							//拼凑属性名
							String fname = head+n.getAttributes().item(0).getNodeValue().toLowerCase();
							if(hasField(cls, fname)){
								Field field = cls.getDeclaredField(fname);
								field.setAccessible(true);
								field.set(obj, n.getTextContent());
							}
						}
					}
					//保存对象
					saveObj(obj, action);
				}
			}
			//获取映射关系
			if(root.getElementsByTagName("Mappings").getLength()!=0){
				e = root.getElementsByTagName("Mappings").item(0).getChildNodes();
				for (int i = 0; i < e.getLength(); i++) {
					if( e.item(i).getNodeName().equals("Mapping")){
						Mapping map = new Mapping();
						String action = "";
						NamedNodeMap nls = e.item(i).getAttributes();
						for (int j = 0; j < nls.getLength(); j++) {
							Node nd = nls.item(j);
							String fname = nd.getNodeName().toLowerCase();
							if(hasField(Mapping.class, fname)){
								Field field = Mapping.class.getDeclaredField(fname);
								field.setAccessible(true);
								field.set(map, nd.getNodeValue());
							}
							if(fname.equals("action")){
								action = nd.getNodeValue().toLowerCase();
							}
						}
						saveObj(map, action);
					}
				}
			}
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
			dao.response(CMSID, SOPID, correlateID, -1001, cmdFileURL, null);
		} catch (IOException e) {
			dao.response(CMSID, SOPID, correlateID, -1002, cmdFileURL, null);
		} catch (NoSuchFieldException e1) {
		} catch (SecurityException e1) {
		} catch (IllegalArgumentException e1) {
		} catch (IllegalAccessException e1) {
		} catch (DOMException e1) {
			dao.response(CMSID, SOPID, correlateID, -1002,  cmdFileURL, null);
		}catch (InstantiationException e1) {
		}
//		System.out.println("success");
		dao.response(CMSID, SOPID, correlateID, 0, "success", null);
	}
	/*
	 * 判断是否存在该属性
	 */
	public static boolean hasField(Class cls,String name){	
		//获取类的属性列表
		Field[] fls = cls.getDeclaredFields();
		//遍历属性
		for (Field field : fls) {
			//一旦存在该属性直接返回真
			if(field.getName().equals(name.trim())){
				return true;
			}
		}
		return false;
	}
	//通过字符串间接获取到类
	public static Class getCls(String cls){
		if(cls.equals("channel")){
			return Channel.class;
		}else if(cls.equals("physicalchannel")){
			return PhysicalChannel.class;
		}else if(cls.equals("picture")){
			return Picture.class;
		}else if(cls.equals("schedulerecord")){
			return ScheduleRecord.class;
		}
		return null;
	}
	//根据obj的类型，加以action操作
	//由于数据还没有完全完善，故regist也放到update中去了
	public static void saveObj(Object obj,String action){
		if(obj instanceof Channel){
			if(action.equals("regist")){
				dao.updateChannel((Channel)obj);
			}else if(action.equals("update")){
				dao.updateChannel((Channel)obj);
			}else if(action.equals("delete")){
				dao.deleteChannel((Channel)obj);
			}
		}else if(obj instanceof PhysicalChannel){
			if(action.equals("regist")){
				dao.updatePhysicalChannel((PhysicalChannel)obj);
			}else if(action.equals("update")){
				dao.updatePhysicalChannel((PhysicalChannel)obj);
			}else if(action.equals("delete")){
				dao.deletePhysicalChannel((PhysicalChannel)obj);
			}
		}else if(obj instanceof Picture){
			if(action.equals("regist")){
				dao.updatePicture((Picture)obj);
			}else if(action.equals("update")){
				dao.updatePicture((Picture)obj);
			}else if(action.equals("delete")){
				dao.deletePicture((Picture)obj);
			}
		}else if(obj instanceof ScheduleRecord){
			if(action.equals("regist")){
				dao.updateScheduleRecord((ScheduleRecord)obj);
			}else if(action.equals("update")){
				dao.updateScheduleRecord((ScheduleRecord)obj);
			}else if(action.equals("delete")){
				dao.deleteScheduleRecord((ScheduleRecord)obj);
			}
		}else if(obj instanceof Mapping){
			if(action.equals("regist")){
				dao.registMapping((Mapping)obj);
			}else if(action.equals("delete")){
				dao.deleteMapping((Mapping)obj);
			}
		}
	}
}
