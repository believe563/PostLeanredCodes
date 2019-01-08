package com.example.registerpageframe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Registe_Checkcode extends Activity {

	private ImageButton mReturnButton;
	private Button mNextButton;
	private Button mSend;
	private EditText mCheckCode;
	int i = 60;
	private String phoneNums;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.input_checkcode);

		mReturnButton = (ImageButton) findViewById(R.id.ib_return1);
		mNextButton = (Button) findViewById(R.id.ib_next1);
		mSend = (Button) findViewById(R.id.btSend);
		mCheckCode = (EditText) findViewById(R.id.input_checkCode);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		phoneNums = bundle.getString("phoneNum");

		mReturnButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Registe_Checkcode.this,
						Registe_PhoneNum.class);
				startActivity(intent);
			}
		});
		mNextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(Registe_Checkcode.this,
						Registe_Passw.class);
				startActivity(intent);
			}
		});
		mSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(getApplicationContext(), phoneNums, 0).show();
				// case R.id.back_iv:
				// this.finish();
				// KeyBoardUtils.closeKeybord(phoneNumEt,
				// RegisterActivity.this);
				// break;

				// // 1. 通过规则判断手机号
				// if (!judgePhoneNums(phoneNums)) {
				// return;
				// }
				// 2. 通过sdk发送短信验证
				// SMSSDK.getVerificationCode("86", phoneNums);
				// 3. 把按钮变成不可点击，并且显示倒计时（正在获取）
				// mSend.setClickable(false);
				// mSend.setText("重新发送(" + i-- + ")");
				// new Thread(new Runnable() {
				// @Override
				// public void run() {
				// for (int i = 60; i > 0; i--) {
				// handler.sendEmptyMessage(-9);
				// // if (i <= 0) {
				// // break;
				// // }
				// try {
				// Thread.sleep(1000);
				// } catch (InterruptedException e) {
				// e.printStackTrace();
				// }
				// }
				// handler.sendEmptyMessage(-8);
				// }
				// }).start();
				//
				// // 4. 打开广播来接受读取短信
				// //
				// // break;
				// // case R.id.ib_next1:
				// // // judgePhoneNums(phoneNums);
				// // SMSSDK.submitVerificationCode("86", phoneNums, mCheckCode
				// // .getText().toString());
				// // createProgressBar();
				// // 验证通过之后，将smssdk注册代码注销
				// // SMSSDK.unregisterEventHandler(eventHandler);
				//
			}

		});

	}

	

//	public void initSDK() {
//		/**
//		 * 初始化短信SDK
//		 */
//		SMSSDK.initSDK(this, "6869cc47159b", "c620984db1b71e97ab51f5e2ab00865a");
//		EventHandler eventHandler = new EventHandler() {
//			/**
//			 * 在操作之后被触发
//			 * 
//			 * @param event
//			 *            参数1
//			 * @param result
//			 *            参数2 SMSSDK.RESULT_COMPLETE表示操作成功，为SMSSDK.
//			 *            RESULT_ERROR表示操作失败
//			 * @param data
//			 *            事件操作的结果
//			 */
//			@Override
//			public void afterEvent(int event, int result, Object data) {
//				Message msg = new Message();
//				msg.arg1 = event;
//				msg.arg2 = result;
//				msg.obj = data;
//				handler.sendMessage(msg);
//			}
//		};
//		// 注册回调监听接口
//		SMSSDK.registerEventHandler(eventHandler);
//	}
//	Handler handler = new Handler() {
//		public void handleMessage(Message msg) {
//			if (msg.what == -9) {
//				mSend.setText("重新发送(" + i-- + ")");
//			} else if (msg.what == -8) {
//				mSend.setText("获取验证码");
//				mSend.setClickable(true);
//			} else {
//				int event = msg.arg1;
//				int result = msg.arg2;
//				Object data = msg.obj;
//				Log.e("event", "event=" + event);
//				if (result == SMSSDK.RESULT_COMPLETE) {
//					// 短信注册成功后，返回MainActivity,然后提示新好友
//					if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {// 提交验证码成功
//						Toast.makeText(getApplicationContext(), "提交验证码成功",
//								Toast.LENGTH_SHORT).show();
//						Intent intent = new Intent(Registe_Checkcode.this,
//								Registe_Passw.class);
//						startActivity(intent);
//					} else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
//						Toast.makeText(getApplicationContext(), "验证码已经发送",
//								Toast.LENGTH_SHORT).show();
//					} else {
//						((Throwable) data).printStackTrace();
//					}
//				}
//			}
//		}
//	};
//
//	 @Override
//	 protected void onDestroy() {
//	 super.onDestroy();
//	 // this.unregisterReceiver(smsBroadcastReceiver);
//	 SMSSDK.unregisterAllEventHandler();
//	 }

}
