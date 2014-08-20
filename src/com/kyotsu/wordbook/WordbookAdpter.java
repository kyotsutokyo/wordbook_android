package com.kyotsu.wordbook;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.kyotsu.wordbook.CustomAdapter.ViewHolder;
import com.kyotsu.wordbook.entity.WordbookEntity;
import com.kyotsu.wordbook.service.AppContext;
import com.kyotsu.wordbook.thrift.Word;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class WordbookAdpter extends BaseAdapter {

	public boolean isOrderByTime = true;
	public boolean isDeleteWord = false;
	public boolean hideTranslation = false;
	OnRowCheckChangedListener mListener;
	
	private List<WordbookEntity> checkedList = new ArrayList<WordbookEntity>();

	public void restCheckList()
	{
		checkedList = new ArrayList<WordbookEntity>();
	}
	
	public List<WordbookEntity> getCheckedList()
	{
		return checkedList;
	}
	private List<WordbookEntity> list = new ArrayList<WordbookEntity>();

	private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

	public TreeSet<Integer> getSectionHeader() {
		return sectionHeader;
	}

	public void setSectionHeader(TreeSet<Integer> sectionHeader) {
		this.sectionHeader = sectionHeader;
	}

	public List<WordbookEntity> getList() {
		return list;
	}

	public void setList(List<WordbookEntity> dataList) {
		if (isOrderByTime) {
			this.list.clear();
			sectionHeader.clear();
			String dateStr = "";
			int index = 0;
			for (int i = 0; i < dataList.size(); i++) {
				WordbookEntity word = dataList.get(i);
				String nextDateStr = AppContext.getDateString(word
						.getCreateDate());
				if (!StringUtil.isEqual(nextDateStr, dateStr)) {
					sectionHeader.add(index);
					list.add(word);
					index++;
				}
				this.list.add(word);
				index++;
				dateStr = nextDateStr;
			}
		} else {
			//this.list = dataList;
			this.list.clear();
			sectionHeader.clear();
			String WordStr = "";
			int index = 0;
			for (int i = 0; i < dataList.size(); i++) {
				WordbookEntity word = dataList.get(i);
				String nextWordStr = word.getWord().substring(0, 1);
				if (!StringUtil.isEqual(nextWordStr, WordStr)) {
					sectionHeader.add(index);
					list.add(word);
					index++;
				}
				this.list.add(word);
				index++;
				WordStr = nextWordStr;
			}
		}
		//this.list = list;
	}

	LayoutInflater inflater;

	public WordbookAdpter(List<WordbookEntity> dataList,
			LayoutInflater _inflater) {

		if (dataList == null) {
			this.list = new ArrayList<WordbookEntity>();
		} else {
			setList(dataList);
		}
		inflater = _inflater;
	}

	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		if (!isOrderByTime) {
			/*View v = null;			
			v = inflater.inflate(R.layout.listview_item_layout, null);				
			WordbookEntity word = (WordbookEntity) list.get(position);
			((TextView) v.findViewById(R.id.word_name)).setText(word.getWord());
			String dateStr = AppContext.getDateString(word.getCreateDate());
			((TextView) v.findViewById(R.id.word_translation)).setText(word.getTranslation());		
			((TextView) v.findViewById(R.id.date_edit)).setText(dateStr);
			if (!isDeleteWord)	{
				((TextView) v.findViewById(R.id.CheckBox01)).setVisibility(View.GONE);
			}
				
			if (hideTranslation) {
				((TextView) v.findViewById(R.id.word_translation)).setVisibility(View.GONE);
			}
			return v;*/
			TextView textView = null;
			int rowType = getItemViewType(position);
			switch (rowType) {
			case TYPE_ITEM:				
				convertView = inflater.inflate(R.layout.listview_item_layout, null);				
				textView = (TextView) convertView.findViewById(R.id.word_name);
				String word = list.get(position).getWord();
				textView.setText(word);
				textView = (TextView) convertView.findViewById(R.id.word_translation);
				textView.setText(list.get(position).getTranslation());			
//				ViewTreeObserver observer = textViewT.getViewTreeObserver();
//				observer.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
//				    @Override
//				    public void onGlobalLayout() {
//				        int maxLines = (int) textViewT.getHeight()/textViewT.getLineHeight();
//				        textViewT.setMaxLines(maxLines);
//				        textViewT.getViewTreeObserver().removeGlobalOnLayoutListener(
//				                this);
//				    }
//				});
//				
				if (hideTranslation) {
					textView.findViewById(R.id.word_translation).setVisibility(View.GONE);
				}
				textView = (TextView) convertView.findViewById(R.id.date_edit);
				String dateStr2 = AppContext.getDateString(list.get(position).getCreateDate());
				textView.setText(dateStr2);	
				CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox01);
				if(checkedList.contains(list.get(position))){
					checkBox.setChecked(true);
				}else{
					checkBox.setChecked(false);
				}
				checkBox.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						processCheckBox(v);
					}
				});
				checkBox.setTag(list.get(position));
				if (!isDeleteWord){
					checkBox.findViewById(R.id.CheckBox01).setVisibility(View.GONE);
				}
				
				break;
			case TYPE_SEPARATOR:
				convertView = inflater.inflate(R.layout.snippet_item2, null);
				textView = (TextView) convertView
						.findViewById(R.id.textSeparator);
				String word2 = list.get(position).getWord().substring(0,1);
				textView.setText(word2);
				break;
			}
			return convertView;
		}   else {
			TextView textView = null;
			int rowType = getItemViewType(position);
			switch (rowType) {
			case TYPE_ITEM:				
				convertView = inflater.inflate(R.layout.listview_item_layout, null);				
				textView = (TextView) convertView.findViewById(R.id.word_name);
				String word = list.get(position).getWord();
				textView.setText(word);
				textView = (TextView) convertView.findViewById(R.id.word_translation);
				textView.setText(list.get(position).getTranslation());			
				if (hideTranslation) {
					textView.findViewById(R.id.word_translation).setVisibility(View.GONE);
				}
				textView = (TextView) convertView.findViewById(R.id.date_edit);
				String dateStr2 = AppContext.getDateString(list.get(position).getCreateDate());
				textView.setText(dateStr2);	
				textView.findViewById(R.id.date_edit).setVisibility(View.GONE);
				CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox01);
				if(checkedList.contains(list.get(position))){
					checkBox.setChecked(true);
				}else{
					checkBox.setChecked(false);
				}
				checkBox.setTag(list.get(position));
				checkBox.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						processCheckBox(v);
					}
				});
				
				if (!isDeleteWord){
					checkBox.findViewById(R.id.CheckBox01).setVisibility(View.GONE);
				}
				break;
			case TYPE_SEPARATOR:
				convertView = inflater.inflate(R.layout.snippet_item2, null);
				textView = (TextView) convertView
						.findViewById(R.id.textSeparator);
				String dateStr = AppContext.getDateString(list.get(position).getCreateDate());
				textView.setText(dateStr);
				break;
			}
			return convertView;
		}
	}
	
	public void processCheckBox(View v)
	{
		CheckBox checkBox = (CheckBox) v;
		if(checkBox!=null)
		{			
			boolean checked = checkBox.isChecked();
			WordbookEntity word = (WordbookEntity) checkBox.getTag();
			if(checked){
				checkedList.add(word);
			}else{
				checkedList.remove(word);
			}
			if(mListener!=null) mListener.onCheckChanged();
		}
	}
	
	public int getCount() {
		return list.size();
	}

	public WordbookEntity getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
	}

	private static final int TYPE_ITEM = 0;
	private static final int TYPE_SEPARATOR = 1;
	
	public interface OnRowCheckChangedListener{
		public void onCheckChanged();
	}
	
	public void setCheckChangedEventListener(OnRowCheckChangedListener eventListener) {
		mListener=eventListener;
	}
}
