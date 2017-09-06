package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Channel;
import model.ScheduleRecord;

public class SortUtil {
	/*
	 * 对list进行排序
	 */
	public static List<Channel> sortList(List<Channel> list){
		Channel cs[] = new Channel[list.size()];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = list.get(i);
		}
		for (int i = 0; i < cs.length; i++){
	        for (int j = i + 1; j < cs.length; j++){  
	            if (getNum(cs[i].getC_name()) > getNum(cs[j].getC_name())){   
	            	Channel temp = new Channel();
	            	temp = cs[j];
	            	cs[j] = cs[i];
	            	cs[i] = temp;
	            }  
	        }  
	    }  
		return Arrays.asList(cs);
	}
	/*
	 * 
	 */
//	public static List<ScheduleRecord> sortEvent(List<ScheduleRecord> list){
//		ScheduleRecord cs[] = new ScheduleRecord[list.size()];
//		for (int i = 0; i < cs.length; i++) {
//			cs[i] = list.get(i);
//		}
//		for (int i = 0; i < cs.length; i++){  
//	        for (int j = i + 1; j < cs.length; j++){  
//	            if (Integer.parseInt(cs[i].getS_starttime()) > Integer.parseInt(cs[j].getS_starttime())){   
//	            	ScheduleRecord temp;
//	            	temp = cs[j];
//	            	cs[j] = cs[i];
//	            	cs[i] = temp;
//	            }  
//	        }  
//	    }  
//		for (ScheduleRecord s : cs) {
//			String start_time = s.getS_starttime();
//			s.setS_starttime(start_time.substring(0, 2)+":"+start_time.substring(2, 4));
//		}
//		return Arrays.asList(cs);
//	}
	/*
	 * 提取字符串中的数字
	 */
	public static int getNum(String str) {
		str=str.trim();
		String str2="";
		if(str != null && !"".equals(str)){
			for(int i=0;i<str.length();i++){
			if(str.charAt(i)>=48 && str.charAt(i)<=57){
				str2+=str.charAt(i);
				}
			}
		 
		}
		return Integer.parseInt(str2);
	}
	
}
