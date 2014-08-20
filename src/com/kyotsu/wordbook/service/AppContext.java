package com.kyotsu.wordbook.service;

import java.util.Calendar;
import java.util.Date;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.kyotsu.wordbook.R;
import com.kyotsu.wordbook.thrift.LoginResult;

public class AppContext {

	public static LoginResult User ;
	
	public static String url = "http://192.168.5.193/wordbook/wordbookHandler.ashx";

	public static String forgot_password_url = "http://192.168.5.193/wordbook";
	
	public static String register_url = "http://192.168.5.193/wordbook";
	
	public static LoginResult getUser() {
		return User;
	}

	public static void setUser(LoginResult user) {
		User = user;
	}
	
	public static String getDateString(Date date)
	{
		String ret =null ;
		if (date == null) return ret;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH)+1;
	    int day = cal.get(Calendar.DAY_OF_MONTH);
		//int year = date.getYear()+1900;
		///int month = date.getMonth()+1;
		//int day = date.getDay();
		ret = String.valueOf(year);
		if(month<10){
			ret = ret + "/0"+month;
		}
		else{
			ret = ret +"/"+ month;
		}
		
		if(day <10)
		{
			ret = ret + "/0"+day;
		}else
		{
			ret = ret +"/"+day;
		}
		return ret;
	}

	public static void alert(Context context, String msg){
		new AlertDialog.Builder(context)
		.setTitle(R.string.err_alert)
		.setMessage(msg)
		.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialog, int id) {}  
		}).create().show(); 
	}
}
