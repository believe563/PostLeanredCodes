package db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.dluadroid05_07_15.R;

import entity.Picture1;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;

public class SQLiteReadHelper03 {
	private Context context;
	private int ResId;

	private final String DATABASE_PATH = android.os.Environment
			.getExternalStorageDirectory().getAbsolutePath() + "/database";
	private String DATABASE_FILENAME;

	public SQLiteReadHelper03(Context context, String databaseName, int ResId) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.DATABASE_FILENAME = databaseName;
		this.ResId = ResId;
	}

	public Object getDatabaseData() {
		SQLiteDatabase db = openDatabase(ResId);
		Cursor cursor = db.query("picture", null, null, null, null, null, null);
		List<Picture1> dataList = new ArrayList<Picture1>();
		if (cursor.moveToFirst()) {
			do {
				Picture1 picture = new Picture1();
				String digest = cursor.getString(cursor
						.getColumnIndex("digest"));
				String lmodify = cursor.getString(cursor
						.getColumnIndex("lmodify"));
				String title = cursor.getString(cursor.getColumnIndex("title"));
				byte[] image = cursor.getBlob(cursor.getColumnIndex("image"));
				Bitmap bitmap = null;
				if (image == null) {
					bitmap = BitmapFactory.decodeResource(context.getResources(),
							R.drawable.pic1);
				} else {
					bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
				}
				picture.setDigest(digest);
				picture.setLmodify(lmodify);
				picture.setTitle(title);
				picture.setImage(image);
				picture.setBitmap(bitmap);
				dataList.add(picture);
			} while (cursor.moveToNext());
		}
		return dataList;
	}

	private SQLiteDatabase openDatabase(int ResId) {
		try {
			// 获得数据库文件的绝对路径
			String databaseFilename = DATABASE_PATH + "/" + DATABASE_FILENAME;
			File dir = new File(DATABASE_PATH);
			// 如果/sdcard/database目录中存在，创建这个目录
			if (!dir.exists())
				dir.mkdir();
			// 如果在/sdcard/dictionary目录中不存在 数据库文件
			// 则从res\raw目录中复制这个文件到SD卡的目录（/sdcard/database）
			if (!(new File(databaseFilename)).exists()) {
				// 获得数据库文件的输入流InputStream对象
				InputStream is = context.getResources().openRawResource(ResId);
				FileOutputStream fos = new FileOutputStream(databaseFilename);
				byte[] buffer = new byte[8192];
				int count = 0;
				// 开始复制数据库文件
				while ((count = is.read(buffer)) > 0) {
					fos.write(buffer, 0, count);
				}

				fos.close();
				is.close();
			}
			// 打开/sdcard/database目录中的数据库文件
			SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(
					databaseFilename, null);
			return database;
		} catch (Exception e) {
		}
		return null;
	}
}
