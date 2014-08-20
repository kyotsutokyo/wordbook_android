package com.kyotsu.wordbook.entity;

import java.util.Date;

public class WordbookEntity {

	public int user_id;
	
	public String Word;
	
	public String Translation;
	
	public Date CreateDate;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public String getTranslation() {
		return Translation;
	}

	public void setTranslation(String translation) {
		Translation = translation;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
}
