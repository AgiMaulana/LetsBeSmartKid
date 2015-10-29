package com.candlelightstudio.letsbesmartkid;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class FragmentPengetahuan extends Fragment implements OnClickListener{
	
	private static final String TAG_PAGE = "Page";
	private static final String TAG_TITLE = "Title";
	
	private String title;
    private int page;

    private ImageButton flora, fauna, budaya, mata_uang;
	
	public static FragmentPengetahuan newInstance(int page, String title){
		FragmentPengetahuan pu = new FragmentPengetahuan();
		Bundle b = new Bundle();
		b.putInt(TAG_PAGE, page);
		b.putString(TAG_TITLE, title);
		pu.setArguments(b);
		return pu;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		page = getArguments().getInt(TAG_PAGE, 0);
		title = getArguments().getString(TAG_TITLE);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_pengetahuan, container, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		fauna = (ImageButton) getView().findViewById(R.id.btnKategoriFauna);
		flora = (ImageButton) getView().findViewById(R.id.btnKategoriFlora);
		mata_uang = (ImageButton) getView().findViewById(R.id.btnKategoriMataUang);
		budaya = (ImageButton) getView().findViewById(R.id.btnKategoriBudaya);
		
		fauna.setOnClickListener(this);
		flora.setOnClickListener(this);
		mata_uang.setOnClickListener(this);
		budaya.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnKategoriFauna:
			pilihPertanyaanActivity(DatabaseAdapter.SOAL_KATEGORI_FAUNA);
		break;
		case R.id.btnKategoriFlora:
			pilihPertanyaanActivity(DatabaseAdapter.SOAL_KATEGORI_FLORA);
			break;
		case R.id.btnKategoriMataUang:
			pilihPertanyaanActivity(DatabaseAdapter.SOAL_KATEGORI_MATA_UANG);
		break;
		case R.id.btnKategoriBudaya:
			pilihPertanyaanActivity(DatabaseAdapter.SOAL_KATEGORI_BUDAYA);
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
