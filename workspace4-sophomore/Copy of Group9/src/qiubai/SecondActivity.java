package qiubai;

import com.example.dluadroid05_07_15.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class SecondActivity extends Activity {
	private ListView lv3;
	private String login;
	private String content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.qiubai_second);
		lv3 = (ListView) findViewById(R.id.lv3);
		login = getIntent().getStringExtra("login");
		content = getIntent().getStringExtra("content");
		// Log.i("mytag",login+"SecondActivity");
		// Log.i("mytag",content);
//		Toast.makeText(this,
//				"mylistener"+"login+"+login+"content"+"+"+content,Toast.LENGTH_SHORT).show();
		lv3.setAdapter(new MyAdapter1(this, login, content));
	}
}