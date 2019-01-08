package qiubai;

import java.util.ArrayList;

import entity.QiuShiBaiKe;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MyListener implements OnItemClickListener {

	private Context context;
	private ArrayList<QiuShiBaiKe> list;
	
	public MyListener(Context context, ArrayList<QiuShiBaiKe> dataList) {
		super();
		this.context = context;
		this.list = dataList;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent=new Intent(context, SecondActivity.class);
		String login=list.get(position).getLogin();
		String content=list.get(position).getContent();
		intent.putExtra("login",login);
		intent.putExtra("content",content);
//		Log.i("mytag", login + "sadvfdvdsvfdvdvvfdwvfdwMyLister");
//		Log.i("mytag",content);
//		Toast.makeText(context, "mylistener"+"login+"+login+"content"+"+"+content,Toast.LENGTH_SHORT).show();
		context.startActivity(intent);
	}

}
