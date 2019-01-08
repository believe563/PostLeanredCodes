package com.example.dluadroid05_07_15;
import huabao.MyAdapter;

import java.util.ArrayList;



import db.SQLiteReadHelper03;
import entity.Picture1;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * 创建一个fragment
 *
 */
public class Fragment03 extends Fragment{

	private ListView lv;
	private ArrayList<Picture1> pictureList;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment03, container,false);
		lv = (ListView) view.findViewById(R.id.lv);
		SQLiteReadHelper03 helper=new SQLiteReadHelper03(getActivity(),"picture",R.raw.picture);
		pictureList=(ArrayList<Picture1>) helper.getDatabaseData();
//		Log.i("mytag", pictureList.toString());
		lv.setAdapter(new MyAdapter(getActivity(), pictureList));
		return view;
	}
}
