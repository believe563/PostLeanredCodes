package com.example.dluadroid05_07_15;

import java.util.ArrayList;
import java.util.List;

import com.example.dluadroid05_07_15.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		OnPageChangeListener, OnClickListener {

	private ViewPager viewPager;
	// 创建链表，存储fragment
	private List<Fragment> fragmentList;
	// 下划线控件
	private TextView line;
	private int lineWidth;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setOnPageChangeListener(this);
		line = (TextView) findViewById(R.id.line);

		// 获取屏幕宽度
		Display display = getWindow().getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);// metrics测度 度量 尺度

		int screenWidth = outMetrics.widthPixels;
		// 得到屏幕宽度的1/3
		lineWidth = screenWidth / 3;
		// 设置line的宽度
		// line.setWidth(lineWidth);
		LayoutParams lp = (LayoutParams) line.getLayoutParams();// 获取到控件的尺寸，lp里包含控件的宽高距离
		lp.width = lineWidth;
		line.setLayoutParams(lp);// 把控件的参数设置回去
		// 将fragment放入数组中
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new Fragment01());
		fragmentList.add(new Fragment02());
		fragmentList.add(new Fragment03());
		// 初始化适配器,如果不继承fragmentactivity的话fragmentmanager参数用不了
		MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
				getSupportFragmentManager());
		// viewPager绑定适配器
		viewPager.setAdapter(myFragmentPagerAdapter);
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv1.setOnClickListener(this);
		tv2.setOnClickListener(this);
		tv3.setOnClickListener(this);

	}

	// 通过适配器把数据绑定到viewpager上
	// 新建一个fragmentpageradapter
	private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		// 根据下标。返回对应的fragment
		@Override
		public Fragment getItem(int arg0) {// 某一页的时候显示一个特定的fragment
			// TODO Auto-generated method stub
			return fragmentList.get(arg0);
		}

		// 显示的总页数
		@Override
		public int getCount() {// 滑动的页数，一共有多少页
			// TODO Auto-generated method stub
			return fragmentList.size();
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	// arg0：页面变化，取值0,1
	// arg1：页面梯度值变化，范围[0,1)
	// arg2：变化范围为[0，arg2*屏幕宽度)
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// 页面滑动时 参数 当前位置的下标0页到1页从0变为1；设置浮点梯度值，从0变到1，无限接近1
		// ，滑动多少变化多少；根据屏幕的宽变化，屏幕为480，就是0到480
		// 动态调整line的位置
		LayoutParams lp = (LayoutParams) line.getLayoutParams();
		lp.leftMargin = (int) ((arg0 + arg1) * lineWidth);
		line.setLayoutParams(lp);

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

		tv1.setTextColor(Color.BLACK);
		tv2.setTextColor(Color.BLACK);
		tv3.setTextColor(Color.BLACK);
		switch (arg0) {
		case 0:
			tv1.setTextColor(Color.rgb(0, 128, 255));
			break;
		case 1:
			tv2.setTextColor(0x8800ff00);
			break;
		case 2:
			tv3.setTextColor(0xff0000ff);
		default:
			break;
		}

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.tv1:
			viewPager.setCurrentItem(0);
			break;
		case R.id.tv2:
			viewPager.setCurrentItem(1);
			break;
		case R.id.tv3:
			viewPager.setCurrentItem(2);
			break;
		default:
			break;
		}
	}

}
