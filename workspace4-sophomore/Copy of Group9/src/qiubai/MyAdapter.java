package qiubai;

import java.util.ArrayList;
import java.util.List;

import com.example.dluadroid05_07_15.R;
import com.example.dluadroid05_07_15.R.id;
import com.example.dluadroid05_07_15.R.layout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import entity.QiuShiBaiKe;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<QiuShiBaiKe> list;

	

	public MyAdapter(Context context, ArrayList<QiuShiBaiKe> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
//		return list.get(position);
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view=LayoutInflater.from(context).inflate(R.layout.item, null);
		TextView textView=(TextView) view .findViewById(R.id.tv);
		TextView textView2=(TextView) view.findViewById(R.id.tv1);
		textView.setText(list.get(position).getLogin());
		textView2.setText(list.get(position).getContent());
		return view;
	}

}
