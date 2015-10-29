package com.candlelightstudio.letsbesmartkid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMain extends Fragment {
	
	private ViewPager vpPager;
	private FragmentPagerAdapter adapterViewPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		View v = inflater.inflate(R.layout.fragment_main, container, false);
		vpPager = (ViewPager) v.findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getChildFragmentManager());
        vpPager.setAdapter(adapterViewPager);
		return v;
	}
	
	public static class MyPagerAdapter extends FragmentPagerAdapter{

		private static int NUM_ITEMS = 2;
		
		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}
 
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return NUM_ITEMS;
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			switch(position){
			case 0:
					return FragmentTatakrama.newInstance(0, "Tatakrama");
			case 1:
					return FragmentPengetahuan.newInstance(1, "Pengetahuan Umum");
			default:
				return null;
			}
		}
		
		@Override
        public CharSequence getPageTitle(int position) {
            if(position==0)
            	return "Tatakrama";
            else
            	return "Pengetahuan";
        }
		
	}
}
