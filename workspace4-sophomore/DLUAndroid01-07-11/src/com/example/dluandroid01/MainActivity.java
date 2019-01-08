package com.example.dluandroid01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private TextView tvResult;
	private Button bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
	private Button[] buttons = { bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8,
			bt9 };
	private int[] ids = { R.id.bt0, R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4,
			R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8, R.id.bt9 };
	private Button btadd, btmin, btmul, btdiv, btcle, btequ;
	private Button[] bttags = { btadd, btmin, btmul, btdiv, btcle, btequ };
	private int[] tagids = { R.id.btadd, R.id.btmin, R.id.btmul, R.id.btdiv,
			R.id.btcle, R.id.btequ };
	private String string1 = "";
	private String string2 = "";
	private int tagflag = 0;// 没有点击过“=”按钮时为0，否则为1
	private int a;
	private int b;
	private int num;
	private int state;
	private static final int ADD = 0;
	private static final int MIN = 1;
	private static final int MUL = 2;
	private static final int DIV = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		for (int i = 0; i < 10; i++) {
			buttons[i] = (Button) findViewById(ids[i]);
			buttons[i].setOnClickListener(this);
		}
		tvResult = (TextView) findViewById(R.id.tvresult);
		for (int i = 0; i < 6; i++) {
			bttags[i] = (Button) findViewById(tagids[i]);
			bttags[i].setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt0:
			string1 += "0";
			string2 += "0";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt1:
			string1 += "1";
			string2 += "1";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt2:
			string1 += "2";
			string2 += "2";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt3:
			string1 += "3";
			string2 += "3";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt4:
			string1 += "4";
			string2 += "4";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt5:
			string1 += "5";
			string2 += "5";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt6:
			string1 += "6";
			string2 += "6";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt7:
			string1 += "7";
			string2 += "7";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt8:
			string1 += "8";
			string2 += "8";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.bt9:
			string1 += "9";
			string2 += "9";
			tvResult.setText(string1);
			Toast.makeText(MainActivity.this, string2, Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.btadd:
			if (tagflag == 0) {
				a = Integer.parseInt(string2);
				string2 = "";
				string1 += "+";
				tvResult.setText(string1);
				tagflag = 1;
				state = ADD;
			}
			break;
		case R.id.btmin:
			if (tagflag == 0) {
				a = Integer.parseInt(string2);
				string2 = "";
				string1 += "-";
				tvResult.setText(string1);
				tagflag = 1;
				state = MIN;
			}
			break;
		case R.id.btmul:
			if (tagflag == 0) {
				a = Integer.parseInt(string2);
				string2 = "";
				string1 += "*";
				tvResult.setText(string1);
				tagflag = 1;
				state = MUL;
			}
			break;
		case R.id.btdiv:
			if (tagflag == 0) {
				a = Integer.parseInt(string2);
				string2 = "";
				string1 += "/";
				tvResult.setText(string1);
				tagflag = 1;
				state = DIV;
			}
			break;
		case R.id.btcle:
			string1 = string1.substring(0, string1.length() - 2);
			tvResult.setText(string1);
			break;
		case R.id.btequ:
			b = Integer.parseInt(string2);
			switch (state) {
			case ADD:
				num = a + b;
				tvResult.setText(string1+"=" + num);
				string1="";
				string2="";
				tagflag = 0;
				break;
			case MIN:
				num = a - b;
				tvResult.setText(string1+"=" + num);
				string1="";
				string2="";
				tagflag = 0;
				break;
			case MUL:
				num = a * b;
				tvResult.setText(string1+"=" + num);
				string1="";
				string2="";
				tagflag = 0;
				break;
			case DIV:
				if (b != 0) {
					float b = Float.parseFloat(string2);
					float num = a / b;
					tvResult.setText(string1+"=" + num);
					string1="";
					string2="";
					tagflag = 0;
				} else {
					Toast.makeText(MainActivity.this, "除数不能为0",
							Toast.LENGTH_SHORT).show();
					string1="";
					string2="";
				}
				break;

			default:
				break;
			}
			break;

		default:
			break;
		}
	}
}
