package qiubai;


import com.example.dluadroid05_07_15.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter1 extends BaseAdapter {
	private Context context;
	private String login;
	private String content;

	public MyAdapter1(Context context, String login, String content) {
		super();
		this.context = context;
		this.login = login;
		this.content = content;
//		Toast.makeText(context, "login" + login, Toast.LENGTH_SHORT).show();
	}

	@Override
	public int getCount() {
		return 1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.item1,null);
		TextView tv2 = (TextView) view.findViewById(R.id.tv2);
		TextView tv3 = (TextView) view.findViewById(R.id.tv3);
		tv2.setText(login);
		tv3.setText(content);
//		Toast.makeText(context, "login" + login, Toast.LENGTH_SHORT).show();
		// Log.i("mytag", "myadapter");
		return view;
	}

}
