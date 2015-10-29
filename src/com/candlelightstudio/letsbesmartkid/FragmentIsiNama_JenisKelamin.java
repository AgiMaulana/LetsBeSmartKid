package com.candlelightstudio.letsbesmartkid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

public class FragmentIsiNama_JenisKelamin extends Fragment{

	private static final String TAG_PAGE = "page";
	private int page;
	private Spinner jekel;
	
	public static FragmentIsiNama_JenisKelamin newInstance(int page){
		FragmentIsiNama_JenisKelamin fragment = new FragmentIsiNama_JenisKelamin();
		Bundle b = new Bundle();
		b.putInt(TAG_PAGE, page);
		fragment.setArguments(b);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		page = getArguments().getInt(TAG_PAGE,0);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment_isinama_jeniskelamin, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		jekel = (Spinner) getView().findViewById(R.id.spinner_PilihJekel);
		jekel.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				((IsiNama_Activity)getActivity()).jk = jekel.getSelectedItem().toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
}
