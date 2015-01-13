package com.ninh.dashboard;

import com.ninh.meovat.DoDien_Activity;
import com.ninh.meovat.DoGiaDung_Activity;
import com.ninh.meovat.HoaQuaDoUong_Activity;
import com.ninh.meovat.Info_Activity;
import com.ninh.meovat.NauNuong_Activity;
import com.ninh.meovat.SucKhoe_Activity;
import com.ninh.meovat.Vanphongpham_Activity;
import com.ninh.meovat.VatCanh_Activity;
import com.ninh.meovat.VeSinhGD_Activity;
import com.ninh.meovat.lamdep_Activity;
import com.ninh.meovat.thoitrang_Activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.zenapp.meovat.R;

public class AndroidDashboardDesignActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dashboard_layout);

		/**
		 * Creating all buttons instances
		 * */
		Button btn_suckhoe = (Button) findViewById(R.id.btn_suckhoe);
		Button btn_naunuong = (Button) findViewById(R.id.btn_naunuong);
		Button btn_dogiadung = (Button) findViewById(R.id.btn_dogiadung);
		Button btn_hoaqua = (Button) findViewById(R.id.btn_hoaqua);
		Button btn_tt = (Button) findViewById(R.id.btn_thongtin);
		Button btn_vanphongpham = (Button) findViewById(R.id.btn_vanphongpham);
		Button btn_lamdep = (Button) findViewById(R.id.btn_lamdep);
		Button btn_vesinhgd = (Button) findViewById(R.id.btn_vesinhgd);
		Button btn_vatcanh = (Button) findViewById(R.id.btn_vatcanh);
		Button btn_thoitrang = (Button) findViewById(R.id.btn_thoitrang);
		Button btn_dodien = (Button) findViewById(R.id.btn_dodien);


		btn_lamdep.setOnClickListener(new View.OnClickListener() {
			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						lamdep_Activity.class); 
				startActivity(i);
			}
		});
		btn_dodien.setOnClickListener(new View.OnClickListener() {
			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						DoDien_Activity.class); 
				startActivity(i);
			}
		});
		btn_thoitrang.setOnClickListener(new View.OnClickListener() {
			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						thoitrang_Activity.class); 
				startActivity(i);
			}
		});
		btn_vatcanh.setOnClickListener(new View.OnClickListener() {
			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						VatCanh_Activity.class); 
				startActivity(i);
			}
		});
		
		btn_vesinhgd.setOnClickListener(new View.OnClickListener() {
			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						VeSinhGD_Activity.class); 
				startActivity(i);
			}
		});
		
		btn_vanphongpham.setOnClickListener(new View.OnClickListener() {
			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						Vanphongpham_Activity.class); 
				startActivity(i);
			}
		});
		
		btn_hoaqua.setOnClickListener(new View.OnClickListener() {

			// @Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						HoaQuaDoUong_Activity.class); 
				startActivity(i);
			}
		});
		btn_suckhoe.setOnClickListener(new View.OnClickListener() {

			// @Override
			public void onClick(View view) {
				// Launching News Feed Screen
				Intent i = new Intent(getApplicationContext(),
						SucKhoe_Activity.class); 
				startActivity(i);
			}
		});

		// Listening to News Feed button click
		btn_naunuong.setOnClickListener(new View.OnClickListener() {

			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						NauNuong_Activity.class); 
				startActivity(i);
			}
		});
		
		btn_dogiadung.setOnClickListener(new View.OnClickListener() {

			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						DoGiaDung_Activity.class); 
				startActivity(i);
			}
		});
		
		btn_tt.setOnClickListener(new View.OnClickListener() {

			// @Override
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(),
						Info_Activity.class); 
				startActivity(i);
			}
		});

	}
	@Override
	public void onBackPressed() {
		new AlertDialog.Builder(this)
				// .setIcon(android.R.drawable.ic_dialog_alert)
				.setTitle("Mẹo Vặt")
				.setMessage("Bạn có muốn đóng ứng dụng")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								finish();
							}

						}).setNegativeButton("No", null).show();
	}
}