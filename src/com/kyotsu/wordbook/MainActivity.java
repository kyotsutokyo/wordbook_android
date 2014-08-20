package com.kyotsu.wordbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.kyotsu.wordbook.R;
import com.kyotsu.wordbook.WordbookAdpter.OnRowCheckChangedListener;
import com.kyotsu.wordbook.account.AccountHelper;
import com.kyotsu.wordbook.db.DbHelper;
import com.kyotsu.wordbook.entity.WordbookEntity;
import com.kyotsu.wordbook.service.AppContext;
import com.kyotsu.wordbook.task.LoginTask;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	SimpleCursorAdapter mAdapter;
	ListView mListView;
	Button sortButton;
	Button addButton;
	Button showButton;
	Button ButtonCancel;
	Button Buttonremove;
	LayoutInflater inflater;
	DbHelper dbHelper;
	AccountHelper accountHelper;
	SQLiteDatabase db;
	private WordbookAdpter ws;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.listview);
		inflater = (LayoutInflater) getBaseContext().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);

		accountHelper = new AccountHelper(this);
		dbHelper = new DbHelper(this, null, null, 2);
		List<WordbookEntity> wbList = dbHelper.GetWordsByTime();
		ws = new WordbookAdpter(wbList, inflater);
		mListView.setAdapter(ws);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if (!ws.isDeleteWord) {
					Intent intent = new Intent(getBaseContext(),
							Worddetail.class);
					WordbookEntity word = ws.getList().get(position);
					intent.putExtra("WordItem", word.getWord());
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					getBaseContext().startActivity(intent);
				}
			}
		});
		mListView
				.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						if (!ws.isDeleteWord) {
							if (ws.getSectionHeader().contains(position))
								return false;
							final WordbookEntity word = ws.getList().get(
									position);
							final Dialog dialog = new Dialog(MainActivity.this);
							dialog.setContentView(R.layout.trans_edit);
							dialog.setTitle("修改單字解釋");
							Button okbutton = (Button) dialog
									.findViewById(R.id.ok);
							Button cancelButton = (Button) dialog
									.findViewById(R.id.cancel);
							final String word_item = word.getWord();
							final Date date = word.getCreateDate();
							((TextView) dialog.findViewById(R.id.fix_word))
									.setText(word_item);
							((TextView) dialog
									.findViewById(R.id.Translation_edit))
									.setText(word.getTranslation());
							okbutton.setOnClickListener(new OnClickListener() {
								public void onClick(View v) {
									dbHelper.DeleteWord(word_item, "2");
									List<WordbookEntity> wbList = dbHelper
											.GetWords();
									dbHelper.DeleteWords(ws.getCheckedList());
									String translation = ((EditText) dialog
											.findViewById(R.id.Translation_edit))
											.getText().toString();
									dbHelper.ChangeWord(word_item, translation,
											"2", date);

									if (ws.isOrderByTime)
										wbList = dbHelper.GetWordsByTime();
									else
										wbList = dbHelper
												.GetWordsAlphabetizer();
									ws.setList(wbList);
									ws.notifyDataSetChanged();

									Toast.makeText(MainActivity.this,
											"修改成功しました。", Toast.LENGTH_SHORT)
											.show();
									dialog.dismiss();
								}
							});

							cancelButton
									.setOnClickListener(new OnClickListener() {
										public void onClick(View v) {
											dialog.dismiss();
										}
									});
							dialog.show();
						}
						return true;
					}
				});

		sortButton = (Button) findViewById(R.id.btnsort);
		addButton = (Button) findViewById(R.id.btnAdd);
		showButton = (Button) findViewById(R.id.btnShow);
		ButtonCancel = (Button) findViewById(R.id.btnCancel);
		Buttonremove = (Button) findViewById(R.id.btnremove);
		ButtonCancel.setVisibility(View.GONE);
		Buttonremove.setVisibility(View.GONE);

		ws.setCheckChangedEventListener(new OnRowCheckChangedListener() {
			@Override
			public void onCheckChanged() {
				int count = ws.getCheckedList().size();
				String txt = getResources().getString(R.string.button_delete3)
						+ "(" + count + ")";
				Buttonremove.setText(txt);
			}
		});

		sortButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ws.isOrderByTime = !ws.isOrderByTime;
				if (!ws.isOrderByTime) {
					sortButton.setText(R.string.button_sort2);
					List<WordbookEntity> words = dbHelper
							.GetWordsAlphabetizer();
					ws.setList(words);
					ws.notifyDataSetChanged();
					Toast.makeText(MainActivity.this, "字母排序しました。",
							Toast.LENGTH_SHORT).show();
				} else {
					sortButton.setText(R.string.button_sort1);
					List<WordbookEntity> wbList = dbHelper.GetWordsByTime();
					ws.setList(wbList);
					ws.notifyDataSetChanged();
					Toast.makeText(MainActivity.this, "時間排序しました。",
							Toast.LENGTH_SHORT).show();
				}
				ws.notifyDataSetChanged();
			}
		});

		addButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				final Dialog dialog = new Dialog(MainActivity.this);
				dialog.setContentView(R.layout.add_word);
				dialog.setTitle("追加");
				Button button = (Button) dialog.findViewById(R.id.ok);

				button.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						String word = ((EditText) dialog
								.findViewById(R.id.Word_edit)).getText()
								.toString();
						if (StringUtil.isBlank(word)) {
							AlertDialog.Builder builder = new AlertDialog.Builder(
									MainActivity.this);
							builder.setTitle("確認");
							builder.setMessage("単語は入力してください。");
							builder.setPositiveButton("OK",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int which) {
											dialog.cancel();
										}
									});
							builder.show();
						} else {
							String translation = ((EditText) dialog
									.findViewById(R.id.Translation_edit))
									.getText().toString();
							dbHelper.InsertWord(word, translation, "2");
							List<WordbookEntity> wbList;
							if (ws.isOrderByTime)
								wbList = dbHelper.GetWordsByTime();
							else
								wbList = dbHelper.GetWordsAlphabetizer();
							ws.setList(wbList);
							ws.notifyDataSetChanged();

							Toast.makeText(MainActivity.this, "追加成功しました。",
									Toast.LENGTH_SHORT).show();
							dialog.dismiss();
						}
					}
				});
				Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
				cancelButton.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
				dialog.show();
			}
		});

		showButton.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ws.hideTranslation = !ws.hideTranslation;
				if (ws.hideTranslation) {
					showButton.setText(R.string.button_show2);
					Toast.makeText(MainActivity.this, "翻譯隱藏しました。",
							Toast.LENGTH_SHORT).show();
				} else {
					showButton.setText(R.string.button_show1);
					Toast.makeText(MainActivity.this, "翻譯顯示しました。",
							Toast.LENGTH_SHORT).show();
				}
				ws.notifyDataSetChanged();
			}
		});

		ButtonCancel.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				ws.isDeleteWord = false;
				sortButton.setVisibility(View.VISIBLE);
				addButton.setVisibility(View.VISIBLE);
				showButton.setVisibility(View.VISIBLE);
				Buttonremove.setVisibility(View.GONE);
				ButtonCancel.setVisibility(View.GONE);
				ws.notifyDataSetChanged();
			}
		});

		Buttonremove.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {

				if (ws.getCheckedList() == null
						|| ws.getCheckedList().size() == 0) {
					AlertDialog.Builder builder = new AlertDialog.Builder(
							MainActivity.this);
					builder.setTitle("削除確認");
					builder.setMessage("単語を選択されません。");
					builder.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
								}
							});
					builder.show();
				} else {
					AlertDialog.Builder builder = new AlertDialog.Builder(
							MainActivity.this);
					builder.setTitle("削除確認");
					builder.setMessage("削除しましか？");
					builder.setPositiveButton("削除",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
									dbHelper.DeleteWords(ws.getCheckedList());
									List<WordbookEntity> newList = DeleteWordFromList(
											ws.getList(), ws.getCheckedList());
									ws.setList(newList);
									ws.notifyDataSetChanged();
									ws.restCheckList();
									Buttonremove
											.setText(R.string.button_delete3);
								}
							});
					builder.setNegativeButton("キャンセル",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
								}
							});
					builder.show();

				}
				Toast.makeText(MainActivity.this, "刪除成功しました。",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	// ---------------------------------分隔線---------------------------------------
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_settings:
			Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.action_Login: {
			Intent intent = new Intent(getBaseContext(), Login.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			getBaseContext().startActivity(intent);

			// final Dialog dialog = new Dialog(MainActivity.this);
			// dialog.setContentView(R.layout.login_dialog);
			// dialog.setTitle("ログイン");
			// Button button = (Button) dialog.findViewById(R.id.login);
			// button.setOnClickListener(new OnClickListener() {
			// public void onClick(View v) {
			// String ID = ((EditText) dialog.findViewById(R.id.user_id))
			// .getText().toString();
			// String password = ((EditText) dialog
			// .findViewById(R.id.user_password)).getText()
			// .toString();
			// // accountHelper.Login(ID, password);
			// new LoginTask(MainActivity.this).execute(new String[] { ID,
			// password, AppContext.url });
			// dialog.dismiss();
			// }
			// });
			//
			// Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
			// cancelButton.setOnClickListener(new OnClickListener() {
			// public void onClick(View v) {
			// dialog.dismiss();
			// }
			// });
			// dialog.show();
		}
			return true;

		case R.id.action_remove: {
			final Dialog dialog = new Dialog(MainActivity.this);
			dialog.setContentView(R.layout.remove);
			dialog.setTitle("刪一單字");
			Button button = (Button) dialog.findViewById(R.id.ok);

			button.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					String word = ((EditText) dialog
							.findViewById(R.id.Word_edit)).getText().toString();
					dbHelper.DeleteWord(word, "2");
					List<WordbookEntity> wbList = dbHelper.GetWords();
					ws.setList(wbList);
					ws.notifyDataSetChanged();

					Toast.makeText(MainActivity.this, "刪除成功しました。",
							Toast.LENGTH_SHORT).show();
					dialog.dismiss();
				}
			});
			Button cancelButton = (Button) dialog.findViewById(R.id.cancel);
			cancelButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					dialog.dismiss();
				}
			});
			dialog.show();
		}
			return true;

		case R.id.action_remove_words: {
			sortButton.setVisibility(View.GONE);
			addButton.setVisibility(View.GONE);
			showButton.setVisibility(View.GONE);
			Buttonremove.setVisibility(View.VISIBLE);
			ButtonCancel.setVisibility(View.VISIBLE);
			ws.restCheckList();
			ws.isDeleteWord = true;
			Buttonremove.setText(R.string.button_delete3);
			ws.notifyDataSetChanged();
		}
			return true;

		case R.id.show_visible:
			Toast.makeText(this, "顯示隱藏單字", Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	public List<WordbookEntity> DeleteWordFromList(List<WordbookEntity> list,
			List<WordbookEntity> deleteList) {
		List<WordbookEntity> ret = new ArrayList<WordbookEntity>();
		if (list != null && list.size() != 0) {
			if (deleteList != null && deleteList.size() != 0) {
				for (int i = 0; i < deleteList.size(); i++) {
					WordbookEntity deleteWord = deleteList.get(i);
					for (int j = list.size() - 1; j >= 0; j--) {
						WordbookEntity word = list.get(j);
						if (StringUtil.isEqual(word.getWord(),
								deleteWord.getWord())
								&& (word.getUser_id() == deleteWord
										.getUser_id())) {
							list.remove(j);
						}
					}
				}
			}
		}
		if (list != null && list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				if (!ret.contains(list.get(i)))
					ret.add(list.get(i));
			}
		}
		return ret;
	}
}
