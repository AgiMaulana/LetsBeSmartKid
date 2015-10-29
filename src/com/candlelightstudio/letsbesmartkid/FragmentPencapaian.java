package com.candlelightstudio.letsbesmartkid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPencapaian extends Fragment{

	private ViewPager vPager;
	private FragmentPagerAdapter pagerAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment_pencapaian, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		vPager = (ViewPager) getView().findViewById(R.id.pagerPencapaian);
		pagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());
		vPager.setAdapter(pagerAdapter);
	}
	
	private class MyFragmentPagerAdapter extends FragmentPagerAdapter{

		public MyFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int page) {
			// TODO Auto-generated method stub
			Fragment fr = null;
			if(page == 0)
				fr = new FragmentPencapaianTatakrama().newInstance(0, "Pencapaian Tatakrama");
			else
				fr = new FragmentPencapaianPengetahuan().newInstance(0, "Pencapaian Pengetahuan");
			return fr;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}
		
		@Override
        public CharSequence getPageTitle(int page) {
            if(page==0)
            	return "Tatakrama";
            else
            	return "Pengetahuan";
        }
		
	}
	
}
