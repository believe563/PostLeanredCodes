package com.example.dluadroid05_07_15;

import java.util.ArrayList;




import qiubai.MyAdapter;
import qiubai.MyListener;
import db.SQLiteReadHelper01;
import entity.QiuShiBaiKe;
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
public class Fragment01 extends Fragment{

	private ListView lv;
	private ArrayList<QiuShiBaiKe> dataList;
	//覆写父类的oncreateview方法
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment01, container,false);
        lv=(ListView) view.findViewById(R.id.lv);
        SQLiteReadHelper01 helper = new SQLiteReadHelper01(getActivity(), "qiushibaike.db",R.raw.qiushibaike);
		dataList = (ArrayList<QiuShiBaiKe>) helper.getDatabaseData();
		lv.setAdapter(new MyAdapter(getActivity(),dataList));
		lv.setOnItemClickListener(new MyListener(getActivity(),dataList));
		return view;
	}
	
}
