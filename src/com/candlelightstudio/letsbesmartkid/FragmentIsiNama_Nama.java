package com.candlelightstudio.letsbesmartkid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentIsiNama_Nama extends Fragment{

	private static final String TAG_PAGE = "page";
	private int page;
	private EditText nama_depan, nama_belakang;
	
	public static FragmentIsiNama_Nama newInstance(int page){
		FragmentIsiNama_Nama fragment = new FragmentIsiNama_Nama();
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
		super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.fragment_isinama_nama, container, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		View v = getView();
		nama_depan = (EditText) v.findViewById(R.id.txtIsiNamaDepan);
		nama_belakang = (EditText) v.findViewById(R.id.txtIsiNamaBlkg);
		
		nama_depan.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				//((IsiNama_Activity)getActivity()).onNamaDepanChange(s.toString());
				((IsiNama_Activity)getActivity()).nama_dpn = s.toString();
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		nama_belakang.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				//((IsiNama_Activity)getActivity()).onNamaDepanChange(s.toString());
				((IsiNama_Activity)getActivity()).nama_blkg = s.toString();
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	
}
