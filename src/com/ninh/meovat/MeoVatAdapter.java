package com.ninh.meovat;

import com.zenapp.meovat.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MeoVatAdapter extends ArrayAdapter<MeoVat> {

	public MeoVatAdapter(Context context) {
		super(context, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null)
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, null);
		((TextView)(convertView.findViewById(R.id.subject))).setText(getItem(position).getTenMeoVat());
		((TextView)(convertView.findViewById(R.id.to))).setText(getItem(position).getNoiDungMeoVat());
//		((TextView)(convertView.findViewById(R.id.date))).setText(getItem(position).getLoai());
		return convertView;
	}

}
