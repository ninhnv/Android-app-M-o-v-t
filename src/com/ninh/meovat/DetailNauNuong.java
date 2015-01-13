package com.ninh.meovat;

import com.zenapp.meovat.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class DetailNauNuong extends Activity {
	String Title = null;
	String noi_dung = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_single_content);
		Intent i = getIntent();
		Title = i.getStringExtra("Title");
        noi_dung = i.getStringExtra("noi_dung");
        TextView txt_song_name = (TextView) findViewById(R.id.tx_title);
        TextView txt_song_content = (TextView) findViewById(R.id.tx_content);
        txt_song_name.setText(Title);
        txt_song_content.setText(noi_dung);
        
        findViewById(R.id.btnback).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						finish();
					}
				});
        
	}

}
