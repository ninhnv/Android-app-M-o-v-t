package com.ninh.meovat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;

import com.zenapp.meovat.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
//import android.widget.Switch;
import android.widget.Toast;
//import android.support.v4.app.NavUtils;

public class HoaQuaDoUong_Activity extends Activity {
	private ProgressDialog pDialog;
	Cursor c = null;
	ListView lv;
	ArrayList<MeoVat> meovat = new ArrayList<MeoVat>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_hoaqua);
		lv = (ListView) findViewById(R.id.list);
		
		lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
//			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				Intent i = new Intent(getApplicationContext(), DetailNauNuong.class);
				String title = ((TextView) view.findViewById(R.id.subject)).getText().toString();
				String noidung = ((TextView) view.findViewById(R.id.to)).getText().toString();
				
//				Toast.makeText(getApplicationContext(), "Title: " + title  + ", Content: " + noidung, Toast.LENGTH_SHORT).show();
				
				i.putExtra("Title", title);
				i.putExtra("noi_dung", noidung);
				startActivity(i);
			}
		});	
		
		
		findViewById(R.id.btnOption).setOnClickListener(
				new View.OnClickListener() {

					public void onClick(View v) {
						finish();
					}
				});
		new loaddb().execute();
	}

	class loaddb extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			List<NameValuePair> params1 = new ArrayList<NameValuePair>();
			DatabaseHelper myDbHelper = new DatabaseHelper(HoaQuaDoUong_Activity.this);
			myDbHelper.createDatabase();
			myDbHelper.openDataBase();
			c = myDbHelper.query("TableMeoVat", null, "Loai=?",  new String[] {"Quả và đồ uống"}, null, null,null);
			if (c.moveToFirst()) {
				do {

					String MeovatID = c.getString(0);
					String Loai = c.getString(1);
					String DanhMucCon = c.getString(2);
					String TenMeoVat = c.getString(3);
					String TenThamChieu = c.getString(4);
					String NoiDungMeoVat = c.getString(5);
					meovat.add(new MeoVat( MeovatID, Loai, DanhMucCon, TenMeoVat,
							TenThamChieu, NoiDungMeoVat));

				} while (c.moveToNext());
				// c.close();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			// super.onPostExecute(result);
			pDialog.dismiss();
			final MeoVatAdapter adapter = new MeoVatAdapter(HoaQuaDoUong_Activity.this);
			for (int i = 0; i < meovat.size(); i++) {
				adapter.add(meovat.get(i));
				
				// Log.e("data",eng.get(i).getName());
			}
			lv.setAdapter(adapter);
//			runOnUiThread(new Runnable() {

//				public void run() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pDialog = new ProgressDialog(HoaQuaDoUong_Activity.this);
			pDialog.setMessage("load...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}

	
}
