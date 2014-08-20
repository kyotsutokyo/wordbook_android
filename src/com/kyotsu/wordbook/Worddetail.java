package com.kyotsu.wordbook;


import com.kyotsu.wordbook.db.DbHelper;
import com.kyotsu.wordbook.entity.WordbookEntity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TextView;

public class Worddetail extends Activity {

	 LayoutInflater inflater;
	 DbHelper dbHelper ;
	 WordbookEntity word;
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_word_detail);
	        dbHelper = new DbHelper(this,null,null,2);
	        Intent intent = getIntent();
	        Bundle b = intent.getExtras();
			if (b != null){
				if (b.containsKey("WordItem")) {
					String wordItem = b.getString("WordItem");
					word = dbHelper.GetWord(wordItem, "2");
				}
			}
	        inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        TextView wordView =(TextView) findViewById(R.id.worddetail_item);
	        TextView translationView = (TextView) findViewById(R.id.worddetail_translation);
	        if(word!=null){
	        	wordView.setText(word.getWord());
	        	translationView.setText(word.getTranslation());
	        }
	    }
	  
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
}
