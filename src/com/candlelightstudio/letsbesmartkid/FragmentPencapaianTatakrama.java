package com.candlelightstudio.letsbesmartkid;

import java.util.ArrayList;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentPencapaianTatakrama extends Fragment{

	private DatabaseAdapter DBAdapter;
	private BarChart chart;
	private int rumah, sekolah, sosial, fu;
	
	private static final String TAG_PAGE = "Page";
	private static final String TAG_TITLE = "Title";
	
	private String title;
    private int page;
	
	public static FragmentPencapaianTatakrama newInstance(int page, String title){
		FragmentPencapaianTatakrama fr = new FragmentPencapaianTatakrama();
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
		return inflater.inflate(R.layout.fragment_pencapaian_tatakrama, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);

		DBAdapter = new DatabaseAdapter(getView().getContext());
		chart = (BarChart) getView().findViewById(R.id.chartTatakrama);
		chart.setDescription("");
		chart.setDoubleTapToZoomEnabled(false);
		
		getTotalTerjawab();
		setBarChart();
		
	}

	private void getTotalTerjawab() {
		// TODO Auto-generated method stub

		this.rumah 		= DBAdapter.totalTerjawab(DatabaseAdapter.SOAL_KATEGORI_RUMAH);
		this.sekolah 	= DBAdapter.totalTerjawab(DatabaseAdapter.SOAL_KATEGORI_SEKOLAH);
		this.sosial		= DBAdapter.totalTerjawab(DatabaseAdapter.SOAL_KATEGORI_SOSIAL);
	}
	
	private void setBarChart(){
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("Rumah"); 
		labels.add("Sekolah"); 
		labels.add("Sosial"); 
		
		ArrayList<BarEntry> entries = new ArrayList<>();
		entries.add(new BarEntry(rumah, 0));
		entries.add(new BarEntry(sekolah, 1));
		entries.add(new BarEntry(sosial, 2));
		
		BarDataSet dataSets = new BarDataSet(entries, "");
		dataSets.setColors(ColorTemplate.COLORFUL_COLORS);
		BarData data = new BarData(labels, dataSets);
		chart.setData(data);
		chart.animateXY(3000, 3000);
		
		YAxis Y = chart.getAxisLeft();
		Y.setAxisMaxValue(15);
		Y = chart.getAxisRight();
		Y.setAxisMaxValue(0);
	}
}
