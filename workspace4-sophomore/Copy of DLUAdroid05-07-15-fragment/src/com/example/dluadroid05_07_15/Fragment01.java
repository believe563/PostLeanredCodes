package com.example.dluadroid05_07_15;
import java.util.Random;
import java.util.jar.JarFile;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 创建一个fragment
 *
 */
public class Fragment01 extends Fragment{

	private View view;
	// 创建一个相对布局的对象
		RelativeLayout rl;
		private int size = 50;
		private int row = 16;
		private int col = 11;
		private int index = 1;
		private int margin = 60;
		private int level = 5;
		private TextView tvnum;
		private int blacknum = 0;
	//覆写父类的oncreateview方法
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view=inflater.inflate(R.layout.fragment01, container,false);
		// 将成员变量与布局文件绑定
				rl = (RelativeLayout) view.findViewById(R.id.rl);
				// 创建一个监听器的对象
				MyListener l = new MyListener();
				tvnum = new TextView(getActivity());
				tvnum.setWidth(size * col);
				tvnum.setHeight(size * 2);
				tvnum.setX(0);
				tvnum.setY(row * margin);
				tvnum.setBackgroundColor(Color.argb(256, 77, 77, 77));
				rl.addView(tvnum);
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						// 使用代码创建一个textView的对象
						TextView tv = new TextView(getActivity());
						// 设置TextView的宽度和高度
						tv.setWidth(size);
						tv.setHeight(size);
						// 设置textView的位置
						tv.setX(0 + j * margin);
						tv.setY(0 + i * margin);
						// 设置textView的背景色
						tv.setBackgroundColor(Color.WHITE);
						// 设置textView的监听器
						tv.setOnClickListener(l);
						tv.setTag("" + index);
						index++;
						// 将textView添加到布局上
						rl.addView(tv);
					}
				}
				init(level);
		return view;
	}
	public void init(int level) {
		for (int i = 0; i < level; i++) {
			int location = new Random().nextInt(row * col) + 1;
			changeColor((TextView) rl.findViewWithTag(location + ""));
			changeColor2(location);
		}
		tvnum.setText("" + blacknum);
	}
	class MyListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// 将view向下转型为Textview
			TextView tv = (TextView) v;
			changeColor(tv);
			// 获取listview的标记值
			String tag = (String) tv.getTag();
			// 从字符串类型转换为int类型
			int index = Integer.parseInt(tag);
			changeColor2(index);
			tvnum.setText("" + blacknum);
		}

	}

	public void changeColor(TextView tv) {
		ColorDrawable drawable = (ColorDrawable) tv.getBackground();
		int color = drawable.getColor();
		if (color == Color.WHITE) {
			tv.setBackgroundColor(Color.BLACK);
			blacknum++;
		} else {
			tv.setBackgroundColor(Color.WHITE);
			blacknum--;
			if (blacknum == 0) {
				show();
			}
		}

	}

	public void show() {
		OkListener okListener = new OkListener();
		new AlertDialog.Builder(getActivity()).setTitle("游戏结束！").setMessage("退出游戏？")
				.setPositiveButton("是", okListener)
				.setNeutralButton("返回", okListener)
				.setNegativeButton("下一关", okListener).show();
	}

	public boolean onKeyDown(){
		return false;
		
	}
	private class OkListener implements DialogInterface.OnClickListener {

		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			switch (which) {
			case DialogInterface.BUTTON_POSITIVE:
				getActivity().finish();
				break;
			case DialogInterface.BUTTON_NEUTRAL:
				break;
			case DialogInterface.BUTTON_NEGATIVE:
				level=level+5;
				init(level);
				break;
			default:
				break;
			}
		}

	}

	public void changeColor2(int index) {
		int leftIndex = index - 1;
		int rightIndex = index + 1;
		int topIndex = index - col;
		int buttomIndex = index + col;

		// 根据标记值获取textView

		if (index % col != 1) {
			TextView left = (TextView) rl.findViewWithTag(leftIndex + "");
			changeColor(left);
		}
		if (index % col != 0) {
			TextView right = (TextView) rl.findViewWithTag(rightIndex + "");
			changeColor(right);
		}
		if (index > col) {
			TextView top = (TextView) rl.findViewWithTag(topIndex + "");
			changeColor(top);
		}
		if (index < (row - 1) * col) {
			TextView buttom = (TextView) rl.findViewWithTag(buttomIndex + "");
			changeColor(buttom);
		}
	}
}
