package com.kyotsu.wordbook;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
    /**
     * 指定された文字列に全角文字しか含まれていないかどうかを判断します。
     * @param str 文字列
     * @return strがnullまたはstrに全角文字しか含まれていない場合は、true、その以外はfalse
     */
    public static boolean isAllZenkaku(String str) {
        boolean ret = true;
        if (str != null) {
            byte[] bytes = str.getBytes();
            ret = (bytes.length == str.length() * 2);
        }
        return ret;
    }

    /**
     * 指定された文字列に半角文字しか含まれていないかどうかを判断します。
     * @param str 文字列
     * @return strがnullまたはstrに半角文字しか含まれていない場合は、true、その以外はfalse
     */
    public static boolean isAllHankaku(String str) {
        boolean ret = true;
        if (str != null) {
            byte[] bytes = str.getBytes();
            ret = (bytes.length == str.length());
        }
        return ret;
    }
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
    
    /**
     * null または空文字列ではないかを判断します。
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
    	return !(isBlank(str));
    }

    /**
     * null または空文字列かを判断します。
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * null または空文字列ではないかを判断します。
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
    	return !(isEmpty(str));
    }
    
    /**
     * strがnullで指定された場合は、空文字列を返します。その以外は、この文字列の両端から空白を除去します。
     * @param str
     * @return
     */
    public static String getNoNullString(String str) {
        return (str == null ? "" : str.trim());
    }

    /**
     * 入力された文字列 str1 と str2 を比較します。
     * @param str1
     * @param str2
     * @return str1またはstr2いずれかnullの場合は、false。一致でない場合はfalse。その以外はtrue
     */
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
	
	
	/**
	  * 指定された文字列のバイト数を取得する。
	  *
	  * @param psData  文字列
	  * @return バイト数
	  *
	  */
	public static int getByteCount(String psData) {
		/* Modify by Y.Koba 2003.04.17 protectedに変更 */
		//  private int getByteCount(String psData) {

		int  liByteCount = 0;
		
		for (int liCnt = 0; liCnt < psData.length(); liCnt++) {
			String lsCheckStr = psData.substring(liCnt, liCnt + 1);   // 1文字を取得する
			int liOneCharByte = lsCheckStr.getBytes().length;         // 1文字のバイト数を取得する
			if (liOneCharByte == 2) {                                 // 2バイトの場合
				char[] lcData = lsCheckStr.toCharArray();               // charの配列に置換
				if (0xff61 <= lcData[0] && lcData[0] <= 0xff9f) {       // 半角カタカナの場合
					liOneCharByte = 1;                                    // 1バイトにする
				}
				// add 2.6 start
			} else {
				int liUnicode = lsCheckStr.charAt(0);                   // 1文字のUnicode(10進)を取得する
	
				if (liUnicode ==  8741 ||  // MS932における「∥」のUnicode
					liUnicode == 65293 ||  // MS932における「－」のUnicode
					liUnicode == 65504 ||  // MS932における「￠」のUnicode
					liUnicode == 65505 ||  // MS932における「￡」のUnicode
					liUnicode == 65506 ||  // MS932における「￢」のUnicode
					// add 2.10 start
					liUnicode == 65374 ) { // MS932における「～」のUnicode
					// add 2.10 end        	
				
					liOneCharByte = 2;                                    // 対象の5種の文字の場合は、全角と見なす
				}
				// add 2.6 end
			}
			liByteCount += liOneCharByte;                             // バイト数を計算する
		}

		return liByteCount;
	}
	
	
	public static double getFloatValue(double val,int len)
	{
		if(len <= 0)
		{
			return val;
		}
		int lastVal = (int)(val*(Math.pow(10, len+1))) - ((int)(val*(Math.pow(10, len))))*10;
		if(lastVal < 5)
		{
			return ((int)(val*(Math.pow(10, len))))/(Math.pow(10, len));
		}
		else
		{
			return (((int)(val*(Math.pow(10, len))))+1)/(Math.pow(10, len));
		}
	}

}