package entity;

import android.graphics.Bitmap;

public class Picture1 {
 private String digest;
 private String lmodify;
 private String title;
 private byte[] image;
 private Bitmap bitmap;


public String getLmodify() {
	return lmodify;
}
public void setLmodify(String lmodify) {
	this.lmodify = lmodify;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
public String getDigest() {
	return digest;
}
public void setDigest(String digest) {
	this.digest = digest;
}
public Bitmap getBitmap() {
	return bitmap;
}
public void setBitmap(Bitmap bitmap) {
	this.bitmap = bitmap;
}
}
