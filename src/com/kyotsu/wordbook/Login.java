package com.kyotsu.wordbook;

import java.util.Date;
import java.util.Map;

import com.kyotsu.wordbook.WordbookAdpter.OnRowCheckChangedListener;
import com.kyotsu.wordbook.service.AppContext;
import com.kyotsu.wordbook.task.LoginTask;
import com.kyotsu.wordbook.task.LoginTask.OnLoginSuccessListener;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends FragmentActivity {
	private String message = null;
	private static final String LOGIN_NAME = "LOGIN_NAME_KEY";
	private static final String LOGIN_PASSWORD = "LOGIN_PASSWORD_KEY";
	private static final String APP_VERSION = "APP_VERSION_KEY";
	TextView userText = null;
	TextView pwText = null;
	Button loginButton = null;
	Button forgotButton = null;
	Button registerButton = null;
	Button cancelButton = null;
	private LoginTask loginTask;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		userText = (TextView) findViewById(R.id.user_name);
		pwText = (TextView) findViewById(R.id.user_password);
		loginButton = (Button) findViewById(R.id.login);
		forgotButton = (Button) findViewById(R.id.forgot_password);
		registerButton = (Button) findViewById(R.id.register);
		cancelButton = (Button) findViewById(R.id.cancel_login);
		forgotButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
				    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(AppContext.forgot_password_url));
				    startActivity(myIntent);
				} catch (ActivityNotFoundException e) {
				    e.printStackTrace();
				}
			}
		});
		registerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
				    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(AppContext.register_url));
				    startActivity(myIntent);
				} catch (ActivityNotFoundException e) {
				    e.printStackTrace();
				}
			}
		});
		cancelButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Login.this.finish();
			}
		});
		int inputType = InputType.TYPE_CLASS_TEXT
				| InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
		userText.setText(AppContext.GetSavedLoginUserName(this));
		userText.setInputType(inputType);

		//pwText.setText(prefs.getString(LOGIN_PASSWORD, null));
		loginTask = new LoginTask(this, "", "");
	}

	public void onOfflineModeClick(View v) {

	}
	
	public void onLoginClick(View v) {
		String userid = null;
		String password = null;
		if (userText != null)
			userid = userText.getText().toString();
		if (pwText != null)
			password = pwText.getText().toString();
		if (StringUtil.isNullOrEmpty(userid)) {
			AppContext.alert(this, getString(R.string.login_alert_1));
			return;
		}
		if (StringUtil.isNullOrEmpty(password)) {
			AppContext.alert(this, getString(R.string.login_alert_2));
			return;
		}

		loginTask.set_user_name(userid);
		loginTask.set_user_password(password);
		loginTask.setLoginSuccessEventListener(new OnLoginSuccessListener() {
			
			@Override
			public void onLoginSuccess(String user_id,String user_name,String user_password) {
				AppContext.dbHelper.UpdateWordUserId();
			}
		});
		
		loginTask.execute(new String[] { userid, password,
				AppContext.url });
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected Dialog onCreateDialog(int id) {

		switch (id) {
		case 1:
			return new AlertDialog.Builder(this)
					.setTitle(R.string.error)
					.setMessage(R.string.login_failed)
					.setNeutralButton(R.string.ok,
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							}).create();

		default:
			break;
		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		switch (id) {
		case 1:
			AlertDialog dg = (AlertDialog) dialog;
			if (dg != null) {
				dg.setMessage(message);
			}
			break;
		default:
			break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
	
	
}
