package com.candlelightstudio.letsbesmartkid;

import android.support.v4.app.DialogFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

public class DialogJawabSalah extends DialogFragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		getDialog().setCancelable(false);
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		return inflater.inflate(R.layout.dialog_jawab_salah, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		ImageView img = (ImageView) getView().findViewById(R.id.imgKartunSalah);
		DatabaseAdapter DBAdapter = new DatabaseAdapter(getView().getContext());
		Cursor user = DBAdapter.getUserInfo();
		String gender = user.getString(user.getColumnIndex(DatabaseAdapter.KEY_USER_GENDER));
		if(gender.equals(getView().getContext().getResources().getStringArray(R.array.pilih_jekel)[1]))
			img.setImageResource(R.drawable.jawaban_salah_boy);
		else
			img.setImageResource(R.drawable.jawaban_salah_girl);
		MusicManager.start(getView().getContext(), MusicManager.SUARA_SALAH);
	}
}
