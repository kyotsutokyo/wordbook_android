package com.kyotsu.wordbook;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
  
   
	   /**
     * 
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        }
        return false;
    }
    
   
    public static boolean isNotBlank(String str) {
    	return !(isBlank(str));
    }

   
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    
    public static boolean isNotEmpty(String str) {
    	return !(isEmpty(str));
    }
    
   
    public static String getNoNullString(String str) {
        return (str == null ? "" : str.trim());
    }

    
    public static boolean isEqual(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }
    
	public static boolean isNum(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public synchronized static boolean isNullOrEmpty(Object obj){
		if(obj == null){
			return true;
		}else if(obj.toString().trim().equals("")){
			return true;
		}
		return false;
	}
	
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public synchronized static String dateToString(Date date){
		if(date == null){
			return null;
		}
		return format.format(date);
	}
	
	public synchronized static Date stringToDate(String str){
		if(isBlank(str)){
			return null;
		}
		try {
			return format.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

}