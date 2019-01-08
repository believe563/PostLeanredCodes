package com.example.dluadroid05_07_15;
import java.util.Random;

import com.example.dluadroid05_07_15.R;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 创建一个fragment
 *
 */
public class Fragment02 extends Fragment{

	private View view;
	private int size = 50;
	private int margin = 60;
	int col = 11;
	int row = 16;
	private int index = 1;
	private RelativeLayout rl;
	private TextView first;// 第一个字块
	private MyListener myListener;
	//覆写父类的oncreateview方法
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment02, container,false);
		rl = (RelativeLayout) view.findViewById(R.id.rl);
		initUI();
		setRandomBackground();
		return view;
	}
	private void setRandomBackground() {
		int array[] = new int[row * col];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		// 将数组元素打乱
		for (int i = 0; i < array.length - 1; i++) {
			// 在第i个之后的所有TextView中随机选出来一个
			int r = new Random().nextInt(array.length - i - 1);
			// 从最后一个array开始与随机得的数进行交换，array【length-1】的值就是随机的值
			int temp = array[array.length - i - 1];
			array[array.length - i - 1] = array[r];
			array[r] = temp;
		}

		for (int i = 0; i < array.length; i += 2) {
			TextView tv1 = (TextView) rl.findViewWithTag(array[i] + "");
			TextView tv2 = (TextView) rl.findViewWithTag(array[i + 1] + "");
			int color = getRandomColor();
			tv1.setBackgroundColor(color);
			tv2.setBackgroundColor(color);
		}
	}
	// 获取随机颜色的方法
		private int getRandomColor() {
			int colors[] = { Color.argb(255, 238, 169, 169),
					Color.rgb(81, 168, 221), Color.rgb(152, 169, 178),
					Color.rgb(219, 77, 109), Color.GRAY, Color.rgb(247, 145, 110),
					Color.rgb(123, 163, 63), Color.rgb(251, 226, 81) };
			int r = new Random().nextInt(colors.length);
			return colors[r];
		}

		class MyListener implements OnClickListener {

			@Override
			public void onClick(View v) {
				TextView tv = (TextView) v;
				if (first == null) {
					first = tv;
					return;
				}
				// 点的第二块等于第一块
				if (first == tv) {
					first = null;
					return;
				}
				// 判断颜色是否相同
				ColorDrawable draw1 = (ColorDrawable) first.getBackground();
				ColorDrawable draw2 = (ColorDrawable) tv.getBackground();
				if (draw1.getColor() != draw2.getColor()) {// 颜色不同
					first = null;
					return;
				}
				// 判断两个色块是否符合消除规则
				if (judge(first, tv)) {
					first.setBackgroundColor(Color.WHITE);
					tv.setBackgroundColor(Color.WHITE);
				}
				first = null;
			}

		}

		private void initUI() {
			myListener = new MyListener();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					TextView tv = new TextView(getActivity());
					tv.setWidth(size);
					tv.setHeight(size);
					tv.setX(0 + j * margin);
					tv.setY(0 + i * margin);
					tv.setBackgroundColor(Color.rgb(239, 199, 189));
					tv.setTag(index + "");
					tv.setOnClickListener(myListener);
					index++;
					rl.addView(tv);
				}
			}
		}

		boolean judge(TextView tv1, TextView tv2) {
			String tag1 = (String) tv1.getTag();
			String tag2 = (String) tv2.getTag();
			int arg1 = Integer.parseInt(tag1);
			int arg2 = Integer.parseInt(tag2);
			int max = arg1 > arg2 ? arg1 : arg2;
			int min = arg1 < arg2 ? arg1 : arg2;

			boolean flag1 = judgeZero(max, min);
			boolean flag2 = judgeOne(max, min);
			boolean flag3 = judgeTwo(max, min);
			return flag1 || flag2 || flag3;
		}

		private boolean judgeTwo(int max, int min) {
			if (!judgeOne(max, min)) {
				for (int i=(min-1)/col+1;i<=(min-1)/col+col;i++) {//左右边
					TextView tv1=(TextView) rl.findViewWithTag(i+"");
					ColorDrawable cd1=(ColorDrawable) tv1.getBackground();
					boolean judge1=false;
					int max1=min>i?min:i;
					int min1=min<i?min:i;
					if (cd1.getColor()==Color.WHITE) {
						if (judgeZero(max1,min1)){
							judge1=judgeOne(max, i);
						}if (judge1) {
								return true;
							}
					}
				}
				for (int i =(min-1)%col+1; i <(row-1)*col+(col-1)%col+1; i+=col) {//下边
					boolean judge2=false;
					TextView tv2=(TextView) rl.findViewWithTag(i+"");
					ColorDrawable cd2=(ColorDrawable) tv2.getBackground();
					if (cd2.getColor()==Color.WHITE) {
						if (i<min) {
							if (judgeZero(min,i)) {
								judge2=judgeOne(max, i);
								if (judge2) {
									return true;
								}
							}
						}else {
							int max1=max>i?max:i;
							int min1=max<i?max:i;
							if (judgeZero(i, min)) {
								judge2=judgeOne(max1, min1);
								if (judge2) {
									return true;
								}
							}
						}
					}
					
				}
				return false;
			}
			return true;
		}

		private boolean judgeOne(int max, int min) {
			if (!judgeZero(max, min)) {
				if ((min - 1) % col < (max - 1) % col) {// 上面的点在下面点的左边
					int index1 = max - (max / col - min / col) * col;// 右上角
					int index2 = max - (max % col - min % col);// 左下角
					TextView tv1 = (TextView) rl.findViewWithTag(index1 + "");
					TextView tv2 = (TextView) rl.findViewWithTag(index2 + "");
					ColorDrawable cd1 = (ColorDrawable) tv1.getBackground();
					ColorDrawable cd2 = (ColorDrawable) tv2.getBackground();
					return ((cd1.getColor() == Color.WHITE) ? (judgeZero(index1,
							min) && judgeZero(max, index1)) : false)
							|| ((cd2.getColor() == Color.WHITE) ? (judgeZero(
									index2, min) && judgeZero(max, index2)) : false);
				} else {// 上面的点在下面点的右边
					// 获得两个进行0拐点判断的点
					int index1 = max - (max / col - min / col) * col;// 左上角
					TextView tv1 = (TextView) rl.findViewWithTag(index1 + "");
					ColorDrawable cd1 = (ColorDrawable) tv1.getBackground();
					int index2 = max + (min % col - max % col);// 右下角
					TextView tv2 = (TextView) rl.findViewWithTag(index2 + "");
					ColorDrawable cd2 = (ColorDrawable) tv2.getBackground();
					return ((cd1.getColor() == Color.WHITE) ? judgeZero(min, index1)
							&& judgeZero(max, index1)
							: false)
							|| ((cd2.getColor() == Color.WHITE) ? judgeZero(index2,
									min) && judgeZero(index2, max) : false);
				}
			}
			return true;
		}

		private boolean judgeZero(int max, int min) {
			boolean flag1 = judgeRow(max, min);
			boolean flag2 = judgeCol(max, min);
			return flag1 || flag2;
		}

		private boolean judgeCol(int max, int min) {
			if (max % col == min % col) {
				for (int i = min + col; i < max; i += col) {
					TextView tv = (TextView) rl.findViewWithTag(i + "");
					ColorDrawable draw = (ColorDrawable) tv.getBackground();
					if (draw.getColor() != Color.WHITE) {
						return false;
					}
				}
			} else {
				return false;
			}
			return true;
		}

		private boolean judgeRow(int max, int min) {
			int minRow = min / col;
			int maxRow = max / col;
			if (max % col == 0) {
				maxRow--;
			}
			if (minRow == maxRow) {
				for (int i = min + 1; i < max; i++) {
					TextView tv = (TextView) rl.findViewWithTag(i + "");
					ColorDrawable draw = (ColorDrawable) tv.getBackground();
					if (draw.getColor() != Color.WHITE) {
						return false;
					}
				}
			} else {
				return false;
			}
			return true;
		}
}
