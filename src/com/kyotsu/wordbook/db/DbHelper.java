package com.kyotsu.wordbook.db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.kyotsu.wordbook.StringUtil;
import com.kyotsu.wordbook.entity.WordbookEntity;
import com.kyotsu.wordbook.service.AppContext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

//import jp.co.enexco.erss.db.TestDbHelper;

public class DbHelper extends SQLiteOpenHelper {

	private SQLiteDatabase mDB;

	private Context _context;
	// private Date baseDate = new Date("2000/10/10:")

	private static final int DATABASE_VERSION = 2;

	private static String DBNAME = "wordbook";

	private static final String DATABASE_CREATE_WORDBOOK = "CREATE TABLE WORDBOOK( ID INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "USER_ID INTEGER, WORD VARCHAR2(300), TRANSLATION VARCHAR2(500),"
			+ "CREATE_DATE VARCHAR2(100))";

	// private static final String DATABASE_CREATE_USER =
	// "CREATE TABLE USER ( ID INTEGER PRIMARY KEY AUTOINCREMENT,USER_ID INTEGER,"
	// +
	// "USER_NAME VARCHAR(20), PASSWORD VARCHAR2(50)" +")";

	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DBNAME, factory, DATABASE_VERSION);
		_context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// this.mDB = getWritableDatabase();
		db.execSQL(DATABASE_CREATE_WORDBOOK);
		// db.execSQL(DATABASE_CREATE_USER);

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		String dateStr = AppContext.getDateString(cal.getTime());

		// String sql = "insert into USER " + " (USER_NAME,PASSWORD) "
		// + " values ('kyotsu','12345678' )";
		// db.execSQL(sql);

		String sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default','default translation','" + dateStr
				+ "')";
		db.execSQL(sql);

		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default1','default1 translation','" + dateStr
				+ "' )";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default2','default2 translation','" + dateStr
				+ "' )";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default3','default3 translation','" + dateStr
				+ "' )";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default4','default4 translation' ,'"
				+ dateStr + "')";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default5','default5 translation' ,'"
				+ dateStr + "')";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default6','default6 translation' ,'"
				+ dateStr + "')";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default7','default7 translation' ,'"
				+ dateStr + "')";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default8','default8 translation' ,'"
				+ dateStr + "')";
		db.execSQL(sql);
		cal.add(Calendar.DATE, 1);
		dateStr = AppContext.getDateString(cal.getTime());
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) "
				+ " values ('-1','default9','default9 translation' ,'"
				+ dateStr + "')";
		db.execSQL(sql);
		// this.mDB.close();
	}

	public boolean ValidUser(String user_name, String user_password) {
		boolean ret = false;

		return ret;
	}

	public List<WordbookEntity> GetWords() {
		mDB = getWritableDatabase();
		List<WordbookEntity> resList = new ArrayList<WordbookEntity>();
		String user_id = AppContext.GetSavedLoginUserId(_context);
		String QUERY = "SELECT USER_ID, WORD, TRANSLATION,CREATE_DATE FROM WORDBOOK where user_id= "
				+ user_id; // +" ORDER BY CREATE_DATE LIMIT 10 ";

		Cursor cur = mDB.rawQuery(QUERY, null);
		cur.moveToFirst();
		while (!cur.isAfterLast()) {
			WordbookEntity we = new WordbookEntity();
			we.setUser_id(cur.getInt(0));
			we.setWord(cur.getString(1));
			we.setTranslation(cur.getString(2));
			String dateStr = cur.getString(3);
			Date date = new Date();
			int year = Integer.parseInt(dateStr.substring(0, 4)) - 1900;
			int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
			int day = Integer.parseInt(dateStr.substring(8, 10));
			date.setYear(year);
			date.setMonth(month);
			date.setDate(day);
			we.setCreateDate(date);

			resList.add(we);
			cur.moveToNext();
		}
		cur.close();
		mDB.close();
		return resList;
	}

	public List<WordbookEntity> GetWordsByTime() {
		mDB = getWritableDatabase();
		List<WordbookEntity> resList = new ArrayList<WordbookEntity>();
		String user_id = AppContext.GetSavedLoginUserId(_context);
		String QUERY = "SELECT USER_ID, WORD, TRANSLATION,CREATE_DATE FROM WORDBOOK where user_id ="
				+ user_id + " ORDER BY CREATE_DATE DESC ";
		Cursor cur = mDB.rawQuery(QUERY, null);
		cur.moveToFirst();
		while (!cur.isAfterLast()) {
			WordbookEntity we = new WordbookEntity();
			we.setUser_id(cur.getInt(0));
			we.setWord(cur.getString(1));
			we.setTranslation(cur.getString(2));
			String dateStr = cur.getString(3);
			Date date = new Date();
			int year = Integer.parseInt(dateStr.substring(0, 4)) - 1900;
			int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
			int day = Integer.parseInt(dateStr.substring(8, 10));
			date.setYear(year);
			date.setMonth(month);
			date.setDate(day);
			we.setCreateDate(date);

			resList.add(we);
			cur.moveToNext();
		}
		cur.close();
		mDB.close();
		return resList;
	}

	public void UpdateWordUserId() {
		mDB = getWritableDatabase();
		String user_id = AppContext.GetSavedLoginUserId(_context);
		String sql = "update wordbook set user_id=" + user_id
				+ " where user_id = -1";
		mDB.execSQL(sql);
		mDB.close();
	}

	public List<WordbookEntity> GetWordsAlphabetizer() {
		mDB = getWritableDatabase();
		List<WordbookEntity> resList = new ArrayList<WordbookEntity>();
		String user_id = AppContext.GetSavedLoginUserId(_context);
		String QUERY = "SELECT USER_ID, WORD, TRANSLATION,CREATE_DATE FROM WORDBOOK where user_id = "
				+ user_id + " ORDER BY WORD COLLATE NOCASE ASC "; // +" ORDER BY CREATE_DATE LIMIT 10 ";
		Cursor cur = mDB.rawQuery(QUERY, null);
		cur.moveToFirst();
		while (!cur.isAfterLast()) {
			WordbookEntity we = new WordbookEntity();
			we.setUser_id(cur.getInt(0));
			we.setWord(cur.getString(1));
			we.setTranslation(cur.getString(2));
			resList.add(we);
			String dateStr = cur.getString(3);
			Date date = new Date();
			int year = Integer.parseInt(dateStr.substring(0, 4)) - 1900;
			int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
			int day = Integer.parseInt(dateStr.substring(8, 10));
			date.setYear(year);
			date.setMonth(month);
			date.setDate(day);
			we.setCreateDate(date);
			cur.moveToNext();
		}
		cur.close();
		mDB.close();
		return resList;
	}

	public int DeleteWord(String word) {
		int ret = -1;
		mDB = getWritableDatabase();
		String user_id = AppContext.GetSavedLoginUserId(_context);
		ret = mDB.delete("WORDBOOK ", "word='" + word + "' and user_id= "
				+ user_id, null);
		mDB.close();
		return ret;
	}

	public int DeleteWords(List<WordbookEntity> words) {
		int ret = 0;
		if (words == null || words.size() == 0) {
			return ret;
		}

		mDB = getWritableDatabase();
		for (int i = 0; i < words.size(); i++) {
			ret = mDB.delete("WORDBOOK ", "word='" + words.get(i).getWord()
					+ "' and USER_ID=" + words.get(i).user_id, null);
		}
		mDB.close();
		return ret;
	}

	public void InsertWord(String word, String translation) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String dateStr = AppContext.getDateString(cal.getTime());
		String sql;
		String userid = AppContext.GetSavedLoginUserId(_context);
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) " + " values ("
				+ userid + ",'" + word + "','" + translation + "','" + dateStr
				+ "')";
		mDB = getWritableDatabase();
		mDB.execSQL(sql);
		mDB.close();
	}

	public void ChangeWord(String word, String translation, Date date) {
		// Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String dateStr = AppContext.getDateString(cal.getTime());
		String sql;
		String userid = AppContext.GetSavedLoginUserId(_context);
		sql = "insert into WORDBOOK "
				+ " (USER_ID,WORD,TRANSLATION,CREATE_DATE) " + " values ("
				+ userid + ",'" + word + "','" + translation + "','" + dateStr
				+ "')";
		mDB = getWritableDatabase();
		mDB.execSQL(sql);
		mDB.close();
	}

	public WordbookEntity GetWord(String word) {
		mDB = getWritableDatabase();
		String userid = AppContext.GetSavedLoginUserId(_context);
		String a = "SELECT USER_ID,WORD,TRANSLATION,CREATE_DATE FROM WORDBOOK WHERE WORD='"
				+ word + "' and user_id=" + userid + " ORDER BY CREATE_DATE ";
		Cursor cur = mDB.rawQuery(a, null);
		cur.moveToFirst();
		WordbookEntity we = new WordbookEntity();
		while (!cur.isAfterLast()) {
			we.setUser_id(cur.getInt(0));
			we.setWord(cur.getString(1));
			we.setTranslation(cur.getString(2));
			String dateStr = cur.getString(3);
			Date date = new Date();
			int year = Integer.parseInt(dateStr.substring(0, 4)) - 1900;
			int month = Integer.parseInt(dateStr.substring(5, 7)) - 1;
			int day = Integer.parseInt(dateStr.substring(8, 10));
			date.setYear(year);
			date.setMonth(month);
			date.setDate(day);
			we.setCreateDate(date);
			cur.moveToNext();
		}
		cur.close();
		mDB.close();
		return we;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// if (oldVersion == 1 && newVersion > 1) {
		// db.execSQL("ALTER TABLE ERSS_POSITIONS ADD locality text");
		// }
	}
}