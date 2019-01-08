package com.innova.reward.frag;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.innova.reward.R;
import com.innova.reward.aty.AtyLogin;
import com.innova.reward.data.Constant;

public class PersonalDataFrag extends BaseFrag {
	private Button mBtnExit;

	@Override
	public View onCreateView(LayoutInflater infl, ViewGroup vp, Bundle bundle) {
		View v = infl.inflate(R.layout.lyt_personal_data, null);

		initViews(v);
		initEvents();

		return v;
	}

	/**
	 * 弹出退出对话框
	 */
	public void showDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		AlertDialog dialog = builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				handleExit();
			}

			/**
			 * 退出要处理的事情
			 */
			private void handleExit() {
				removeVars(Constant.IS_LOGINED, Constant.iS_OPEN_QUERY_REWARD_REMIND,
						Constant.IS_OPEN_RECEIVE_SYSTEM_MSG, Constant.IS_HAVE_NEW_FP_RECORD, Constant.IS_TO_REWARD);
				getActivity().finish();
				myStartActivity(AtyLogin.class);
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialog.cancel();
			}
		}).setTitle("退出登录").create();
		dialog.show();// 显示对话框
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn_exit:
			showDialog();
			break;
		}
	}

	@Override
	protected void initViews(View v) {
		mBtnExit = (Button) v.findViewById(R.id.btn_exit);
	}

	@Override
	protected void initEvents() {
		mBtnExit.setOnClickListener(this);
	}
}
