package com.innova.reward.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.innova.reward.R;
import com.innova.reward.data.Constant;
import com.innova.reward.util.CommonUtil;

public class MsgFrag extends BaseFrag {
	private Switch mSqueryRewardRemind;
	private Switch mSreceiveSystemMsg;

	@Override
	public View onCreateView(LayoutInflater infl, ViewGroup container, Bundle bundle) {
		View v = infl.inflate(R.layout.lyt_msg, null);

		initViews(v);
		initEvents();

		return v;
	}

	@Override
	protected void initEvents() {
		mSqueryRewardRemind.setOnClickListener(this);
		mSreceiveSystemMsg.setOnClickListener(this);

		if (CommonUtil.sp.getBoolean(Constant.iS_OPEN_QUERY_REWARD_REMIND, false)) {
			mSqueryRewardRemind.setChecked(true);
		} else {
			mSqueryRewardRemind.setChecked(false);
		}
		if (CommonUtil.sp.getBoolean(Constant.IS_OPEN_RECEIVE_SYSTEM_MSG, false)) {
			mSreceiveSystemMsg.setChecked(true);
		} else {
			mSreceiveSystemMsg.setChecked(false);
		}
	}

	@Override
	protected void initViews(View v) {
		mSqueryRewardRemind = (Switch) v.findViewById(R.id.s_query_reward_remind);
		mSreceiveSystemMsg = (Switch) v.findViewById(R.id.s_receive_system_msg);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.s_query_reward_remind:
			// 检测在点击之前的状态
			if (mSqueryRewardRemind.isChecked()) {
				CommonUtil.sp.edit().putBoolean(Constant.iS_OPEN_QUERY_REWARD_REMIND, true).commit();
			} else {
				CommonUtil.sp.edit().putBoolean(Constant.iS_OPEN_QUERY_REWARD_REMIND, false).commit();
			}
			break;

		case R.id.s_receive_system_msg:
			// 检测在点击之前的状态
			if (mSreceiveSystemMsg.isChecked()) {
				CommonUtil.sp.edit().putBoolean(Constant.IS_OPEN_RECEIVE_SYSTEM_MSG, true).commit();
			} else {
				CommonUtil.sp.edit().putBoolean(Constant.IS_OPEN_RECEIVE_SYSTEM_MSG, false).commit();
			}
		}
	}
}
