package com.candlelightstudio.letsbesmartkid;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class FragmentTatakrama extends Fragment implements OnClickListener {
	
	private static final String TAG_PAGE = "Page";
	private static final String TAG_TITLE = "Title";
	
	private String title;
    private int page;
    
    private ImageButton rumah, sekolah, sosial;
	
	public static FragmentTatakrama newInstance(int page, String title){
		FragmentTatakrama tatakrama = new FragmentTatakrama();
		Bundle b = new Bundle();
		b.putInt(TAG_PAGE, page);
		b.putString(TAG_TITLE, title);
		tatakrama.setArguments(b);
		return tatakrama;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		page = getArguments().getInt(TAG_PAGE, 0);
		title = getArguments().getString(TAG_TITLE);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_tatakrama, container, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		rumah = (ImageButton) getView().findViewById(R.id.btnKategoriRumah);
		sekolah = (ImageButton) getView().findViewById(R.id.btnKategoriSekolah);
		sosial = (ImageButton) getView().findViewById(R.id.btnKategoriSosial);
		
		rumah.setOnClickListener(this);
		sekolah.setOnClickListener(this);
		sosial.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnKategoriRumah:
			pilihPertanyaanActivity(DatabaseAdapter.SOAL_KATEGORI_RUMAH);
			break;
		case R.id.btnKategoriSekolah:
			pilihPertanyaanActivity(DatabaseAdapter.SOAL_KATEGORI_SEKOLAH);
			break;
		case R.id.btnKategoriSosial:
			pilihPertanyaanActivity(DatabaseAdapter.SOAL_KATEGORI_SOSIAL);
			break;
		default:
			break;
		}
	}
	
	private void pilihPertanyaanActivity(String kategori){
		Intent i = new Intent(getView().getContext(), PilihPertanyaanActivityBaru.class);
		i.putExtra(DatabaseAdapter.KEY_SOAL_KATEGORI, kategori);
		startActivity(i);
	}
}
