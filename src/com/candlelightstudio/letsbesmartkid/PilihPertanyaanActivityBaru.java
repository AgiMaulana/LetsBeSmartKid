package com.candlelightstudio.letsbesmartkid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class PilihPertanyaanActivityBaru extends FragmentActivity {
	
	private ViewPager vPager;
	private FragmentPagerAdapter adapterViewPager;
	public String kategori;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pilih_pertanyaan_baru);
		Intent i = getIntent();
		this.kategori = i.getStringExtra(DatabaseAdapter.KEY_SOAL_KATEGORI);
		
	    getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		vPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
		vPager.setAdapter(adapterViewPager);
		vPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				if(position==0){
					setTitle("Pertanyaan");
				}else{
					setTitle("Perpustakaan");
				}
			}

		});
	}
	
	private static class MyPagerAdapter extends FragmentPagerAdapter{
		
		private static int NUM_ITEMS = 2;
		
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			switch(position){
			case 0:
				return FragmentPertanyaan.newInstance(0, "Pertanyaan");
			case 1:
				return FragmentPerpustakaan.newInstance(0, "Pertanyaan");
			default:
				break;
			}
			return null;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_ITEMS;
		}
		
	}

}
