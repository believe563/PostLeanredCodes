package com.example.registerpageframe;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Registe_PhoneNum extends Activity {

	private ImageButton mReturnButton;
	private Button mNextButton;
	private EditText phoneNum;

	@Override
	/**
	 * 设置注册页面的输入手机号页面
	 * */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.input_phonenum);

		mReturnButton = (ImageButton) findViewById(R.id.ib_return0);
		mNextButton = (Button) findViewById(R.id.ib_next0);
		phoneNum = ((EditText) findViewById(R.id.phoneNumber));

		// 点击下一步时跳到输入验证码页面
		mNextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (phoneNum.getText().toString().length() == 0) {
					Toast.makeText(Registe_PhoneNum.this, "手机号不能为空",
							Toast.LENGTH_SHORT).show();
					phoneNum.setText("");
				} else if (phoneNum.getText().toString().length() < 11) {
					Toast.makeText(Registe_PhoneNum.this, "手机号输入不足11位",
							Toast.LENGTH_SHORT).show();
					phoneNum.setText("");
				} else if (!phoneNum.getText().toString()
						.matches("^(13|15|18)\\d{9}$")) {
					Toast.makeText(getApplicationContext(), "手机号格式不正确",
							Toast.LENGTH_SHORT).show();
					phoneNum.setText("");
				} else {
					Intent intent = new Intent(Registe_PhoneNum.this,
							Registe_Checkcode.class);
					Bundle bundle = new Bundle();
					bundle.putString("phoneNum", phoneNum.getText().toString());
					intent.putExtras(bundle);
					startActivity(intent);
				}

			}
		});
	}

	public EditText getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(EditText phoneNum) {
		this.phoneNum = phoneNum;
	}

}
