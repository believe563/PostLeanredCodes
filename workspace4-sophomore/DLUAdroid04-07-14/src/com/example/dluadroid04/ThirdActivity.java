package com.example.dluadroid04;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ListView;

public class ThirdActivity extends Activity {
	private ListView lv;
	private ArrayList<?extends Parcelable> arealist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv=(ListView) findViewById(R.id.lv);
		arealist=getIntent().getParcelableArrayListExtra("data");
		lv.setAdapter(new MYAdapter2(this, (ArrayList<Object>)arealist));
	}
}
