package com.candlelightstudio.letsbesmartkid;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentBacaPerpustakaan extends Fragment{

	private static final String TAG_PAGE = "Page";
	private static final String TAG_TITLE = "Title";
	
	private String title;
    private int page;
	
	private long soalId;
	private DatabaseAdapter DBAdapter;
	
	public static FragmentBacaPerpustakaan newInstance(int page, String title){
		FragmentBacaPerpustakaan fr = new FragmentBacaPerpustakaan();
		Bundle b = new Bundle();
		b.putInt(TAG_PAGE, page);
		b.putString(TAG_TITLE, title);
		fr.setArguments(b);
		return fr;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		page = getArguments().getInt(TAG_PAGE, 0);
		title = getArguments().getString(TAG_TITLE);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment_dialog_jawab_benar_baca_perpustakaan, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		
		DBAdapter = new DatabaseAdapter(getView().getContext());
		soalId = ((JawabPertanyaanActivity)getActivity()).soalId;
		String[] perpus = DBAdapter.fetchPenjelasan(soalId);
		
		ImageView img = (ImageView) getView().findViewById(R.id.imgBacaPerpustakaan3);
		String imgPath = perpus[0];
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
	
		TextView lbl = (TextView) getView().findViewById(R.id.lblPenjelasan1);
		lbl.setText(perpus[2]);
	}
	
}
