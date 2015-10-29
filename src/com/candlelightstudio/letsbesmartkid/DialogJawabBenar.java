package com.candlelightstudio.letsbesmartkid;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

public class DialogJawabBenar extends DialogFragment{

	public static ViewPager vPager;
	private FragmentPagerAdapter vpAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		getDialog().setCancelable(false);
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
		return inflater.inflate(R.layout.dialog_jawab_benar, container, false);		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);		
		vPager = (ViewPager) getView().findViewById(R.id.vPagerDialogJawabBenar);
		vpAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
		vPager.setAdapter(vpAdapter);
		Button tutup = (Button) getView().findViewById(R.id.btnDialogJawabBenarTutup);
		MusicManager.start(getView().getContext(), MusicManager.SUARA_BENAR);
		tutup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getDialog().dismiss();
				((JawabPertanyaanActivity)getActivity()).onBackPressed();
			}
		});
	}

	private static class MyFragmentPagerAdapter extends FragmentPagerAdapter{

		private static int NUM_ITEMS = 2;
		
		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			if(position == 0)
				return FragmentDialogJawabBenarKartun.newInstance(0, "Benar");
			else
				return FragmentBacaPerpustakaan.newInstance(1, "Baca perpustakaan");
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_ITEMS;
		}
		
	}
	
}
