package com.candlelightstudio.letsbesmartkid;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentDialogJawabBenarKartun extends Fragment{

	private static final String TAG_PAGE = "Page";
	private static final String TAG_TITLE = "Title";
	
	private String title;
    private int page;
	
	public static FragmentDialogJawabBenarKartun newInstance(int page, String title){
		FragmentDialogJawabBenarKartun fr = new FragmentDialogJawabBenarKartun();
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
		return inflater.inflate(R.layout.fragment_dialog_jawab_benar_kartun, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		ImageView img = (ImageView) getView().findViewById(R.id.imgKartunBenar);
		Button baca = (Button) getView().findViewById(R.id.btnDialogJawabBenarBacaKoleksi);
		DatabaseAdapter DBAdapter = new DatabaseAdapter(getView().getContext());
		
		Cursor user = DBAdapter.getUserInfo();
		String gender = user.getString(user.getColumnIndex(DatabaseAdapter.KEY_USER_GENDER));
		if(gender.equals(getView().getContext().getResources().getStringArray(R.array.pilih_jekel)[1]))
			img.setImageResource(R.drawable.jawaban_benar_boy);
		else
			img.setImageResource(R.drawable.jawaban_benar_girl);
		
		baca.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogJawabBenar.vPager.setCurrentItem(1);
			}
		});
	}
	
}
