package com.candlelightstudio.letsbesmartkid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IsiNama_Activity extends FragmentActivity{
	
	private ViewPager wizard;
	private FragmentPagerAdapter pagerAdapter;
	
	private Button prev, next;
	public String nama_dpn, nama_blkg, jk, sekolah;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_isinama);
		wizard = (ViewPager) findViewById(R.id.wizardFirstScreen);
		pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
		wizard.setAdapter(pagerAdapter);
		prev = (Button) findViewById(R.id.btnPrev);
		next = (Button) findViewById(R.id.btnNext);
		prev.setEnabled(false);
		
		wizard.setOnPageChangeListener(new OnPageChangeListener(){

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if(wizard.getCurrentItem() == 0)
					prev.setEnabled(false);
				else
					prev.setEnabled(true);
				
				if(wizard.getCurrentItem() == 2)
					next.setText("Selesai");
				else
					next.setText(getResources().getString(R.string.selanjutnya));
			}
			
		});
		
		prev.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				wizard.setCurrentItem(wizard.getCurrentItem()-1, true);
			}
		});
		
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int page = wizard.getCurrentItem();
				if(page == 0 && (nama_dpn == null || nama_blkg == null)){
					Toast.makeText(getApplicationContext(), "Lengkapi nama depan dan belakang", Toast.LENGTH_LONG).show();
				}else if(page == 0 && (nama_dpn != null || nama_blkg != null)){
					wizard.setCurrentItem(1, true);
				}
				
				if(page == 1 && (jk == null || jk.equalsIgnoreCase("Pilih"))){
					Toast.makeText(getApplicationContext(), "Pilih", Toast.LENGTH_LONG).show();
				}else if(page == 1 && (jk != null || !jk.equalsIgnoreCase("Pilih jenis kelamin"))){
					wizard.setCurrentItem(wizard.getCurrentItem()+1, true);
				}
				
				if(page == 2 && sekolah == null){
					Toast.makeText(getApplicationContext(), "Masukkan nama sekolah kamu", Toast.LENGTH_LONG).show();
				}else if(page == 2 && sekolah != null){
					insertUser();
				}
			}
		});
		
	}
	
	//private int getItem(int i){
		//return wizard.getCurrentItem() + i;
	//}
	
	private void insertUser(){
		DatabaseAdapter DBAdapter = new DatabaseAdapter(this);
		DBAdapter.insertUser(nama_dpn, nama_blkg, jk, sekolah);
		boolean soalKosong = DBAdapter.soalIsEmpty();
		if(soalKosong)
			startActivity(new Intent(getApplicationContext(), ActivityInitDatabase.class));
		finish();
	}
	
	private static class MyPagerAdapter extends FragmentPagerAdapter{

		private int NUM_ITEMS = 3;
		
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			switch(position){
			case 0:
				return FragmentIsiNama_Nama.newInstance(0);
			case 1:
				return FragmentIsiNama_JenisKelamin.newInstance(1);
			case 2:
				return FragmentIsiNama_Sekolah.newInstance(2);
			default:
				return null;
			}
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_ITEMS;
		}
		
	}
}
