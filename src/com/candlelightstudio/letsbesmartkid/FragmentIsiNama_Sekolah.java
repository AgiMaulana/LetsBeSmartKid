package com.candlelightstudio.letsbesmartkid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentIsiNama_Sekolah extends Fragment{

	private static final String TAG_PAGE = "page";
	private int page;
	private EditText sekolah;
	
	public static FragmentIsiNama_Sekolah newInstance(int page){
		FragmentIsiNama_Sekolah fragment = new FragmentIsiNama_Sekolah();
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
		return inflater.inflate(R.layout.fragment_isinama_sekolah, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		sekolah = (EditText) getView().findViewById(R.id.txtIsiNama_sekolah);
		sekolah.addTextChangedListener(new TextWatcher(){

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
				((IsiNama_Activity)getActivity()).sekolah = s.toString();
				
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
}
