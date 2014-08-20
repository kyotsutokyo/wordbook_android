package com.kyotsu.wordbook.task;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.Toast;

import com.kyotsu.wordbook.R;
import com.kyotsu.wordbook.service.AppContext;
import com.kyotsu.wordbook.thrift.LoginResult;
import com.kyotsu.wordbook.thrift.WordbookThriftService;

public class LoginTask extends WordbookAsync<String[], LoginResult, Exception> {
	
	private ProgressDialog m_Dialog = null;
	
	private String _user_name;
	
	public String get_user_name() {
		return _user_name;
	}

	public void set_user_name(String _user_name) {
		this._user_name = _user_name;
	}

	public String get_user_password() {
		return _user_password;
	}

	public void set_user_password(String _user_password) {
		this._user_password = _user_password;
	}

	private String _user_password;
	
	public Context _context;
	
	OnLoginSuccessListener mListener;
	
	public interface OnLoginSuccessListener{
		public void onLoginSuccess(String user_id,String user_name,String user_password);
	}
	
	public void setLoginSuccessEventListener(OnLoginSuccessListener eventListener) {
		mListener=eventListener;
	}
	
	public LoginTask(Context context,String user_name,String user_password)
	{
		_context = context;
		_user_name = user_name;
		_user_password = user_password;
	}
	
	@Override
	protected void onPreExecute() {
		m_Dialog = ProgressDialog.show(_context,
				_context.getString(R.string.action_login),
				null, 
				true, true,
				new OnCancelListener() {
					public void onCancel(DialogInterface dialog) {
						m_Dialog.dismiss();
					}
				});
	}

	@Override
	protected LoginResult run(String[]... args) throws Exception {

		HttpClientBuilder builder = HttpClientBuilder.create();
		HttpClient httpClient = builder.build();
		THttpClient.Factory factory = new THttpClient.Factory(args[0][2],
				httpClient);
		TTransport transport = factory.getTransport(null);
		try {
			TProtocol protocol = new TJSONProtocol(transport);
			// client
			WordbookThriftService.Client client = new WordbookThriftService.Client(
					protocol);
			LoginResult lr = client.login(args[0][0], args[0][1]);
			return lr;
		} catch (Exception e) {
			return null;

		} finally {
			transport.close();
		}
	}

	@Override
	protected void onSuccess(LoginResult result) {
		if (m_Dialog != null && m_Dialog.isShowing()) {
			m_Dialog.dismiss();
		}
		if(result!=null)
		{
			Toast.makeText(_context, result.msg, Toast.LENGTH_LONG).show();
			if(result.success)
			{
				AppContext.SaveLoginUserId(_context, String.valueOf(result.getUserid()));
				AppContext.SaveLoginUserName(_context, _user_name);
				AppContext.SaveLoginUserPassword(_context, _user_password);
				if(mListener!=null) mListener.onLoginSuccess(String.valueOf(result.getUserid()), _user_name, _user_password);
			}
		}else
		{
			Toast.makeText(_context, "ÉçÉOÉCÉìé∏îsÇµÇ‹ÇµÇΩÅB", Toast.LENGTH_LONG).show();
		}	
	}

	@Override
	protected void onFailure(Exception exception) {

		if (m_Dialog != null && m_Dialog.isShowing()) {
			m_Dialog.dismiss();
		}
		Toast.makeText(_context, exception.getMessage(), Toast.LENGTH_LONG).show();
	}
}
