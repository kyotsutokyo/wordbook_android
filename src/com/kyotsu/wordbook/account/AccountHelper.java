package com.kyotsu.wordbook.account;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import com.kyotsu.wordbook.MainActivity;
import com.kyotsu.wordbook.R;
import com.kyotsu.wordbook.entity.WordbookEntity;
import com.kyotsu.wordbook.service.AppContext;
import com.kyotsu.wordbook.service.Constants;
import com.kyotsu.wordbook.task.WordbookAsync;
import com.kyotsu.wordbook.thrift.LoginResult;
import com.kyotsu.wordbook.thrift.WordbookThriftService;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;

public class AccountHelper  {

	public Context _context = null;
	
	public AccountHelper(Context context)
	{
		_context = context;
	}
	
	public LoginResult Login(String user_name,String user_password){
	
		LoginResult lr = new LoginResult();
		return lr;
	}
	
	public void SynchronizeWords()
	{
		
	}

}


