package com.example.skindemo;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	private TextView mTextView;
	private Button mLocalSkinBtn;
	private Button mRemoteSkinBtn;
	private ImageView mImageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTextView = (TextView) findViewById(R.id.text);
		mLocalSkinBtn = (Button) findViewById(R.id.skin1);
		mRemoteSkinBtn = (Button) findViewById(R.id.skin2);
		mImageView = (ImageView) findViewById(R.id.img);
		mLocalSkinBtn.setOnClickListener(this);
		mRemoteSkinBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.skin1:
			try {
//				Context context = ReflectionUtil.getSkinContext(MainActivity.this, getPackageName());
//				int text_color = ReflectionUtil.getIdentifier(MainActivity.this, getPackageName(), "text_color", "color");
//				mTextView.setTextColor(context.getResources().getColor(text_color));
				
//				int drawableId = ReflectionUtil.getIdentifier(MainActivity.this, getPackageName(), "img", "drawable");
//				mImageView.setImageDrawable(context.getResources().getDrawable(drawableId));
				
				mTextView.setTextColor(ReflectionUtil.color(MainActivity.this, getPackageName(), "text_color"));
				mImageView.setImageDrawable(ReflectionUtil.drawable(MainActivity.this, getPackageName(), "img"));
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case R.id.skin2:
			try {
//				Context context = ReflectionUtil.getSkinContext(MainActivity.this, "com.example.skin2");
//				int textColor = ReflectionUtil.getIdentifier(MainActivity.this, "com.example.skin2", "text_color", "color");
//				mTextView.setTextColor(context.getResources().getColor(textColor));
//				
//				int drawableId = ReflectionUtil.getIdentifier(MainActivity.this, "com.example.skin2", "img", "drawable");
//				mImageView.setImageDrawable(context.getResources().getDrawable(drawableId));
				mTextView.setTextColor(ReflectionUtil.color(MainActivity.this, "com.example.skin2", "text_color"));
				mImageView.setImageDrawable(ReflectionUtil.drawable(MainActivity.this, "com.example.skin2", "img"));
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

}
