package com.candlelightstudio.letsbesmartkid;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DialogBacaPerpustakaan extends DialogFragment{

	private long soalId;
	private DatabaseAdapter DBAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.dialog_baca_perpustakaan, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		DBAdapter = new DatabaseAdapter(getView().getContext());
		soalId = this.getArguments().getLong(DatabaseAdapter.KEY_SOAL_ID);
		String[] perpus = DBAdapter.fetchPenjelasan(soalId);
		
		String imgPath = perpus[0];
		ImageView img = (ImageView) getView().findViewById(R.id.imgBacaPerpustakaan2);
		try{
			InputStream iStream = getView().getContext().getAssets().open(imgPath);
			img.setImageDrawable(Drawable.createFromStream(iStream, null));
		}catch(IOException e){
			InputStream iStream;
			try {
				iStream = getView().getContext().getAssets().open("soal/no_image.png");
				img.setImageDrawable(Drawable.createFromStream(iStream, null));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				Toast.makeText(getView().getContext(), "Terjadi masalah pada aplikasi saat memuat soal", Toast.LENGTH_LONG).show();
			}
		}
		
		TextView lbl = (TextView) getView().findViewById(R.id.lblPenjelasan);
		getDialog().setTitle(perpus[1]);
		lbl.setText(perpus[2]);
		Button tutup = (Button) getView().findViewById(R.id.btnTutupDialogBaca);
		
		tutup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getDialog().dismiss();
			}
		});
	}
	
}
