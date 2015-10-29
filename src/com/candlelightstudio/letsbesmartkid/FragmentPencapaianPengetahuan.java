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

public class FragmentPencapaianPengetahuan extends Fragment{

	private DatabaseAdapter DBAdapter;
	private BarChart chart;
	private int fauna, flora, mata_uang, budaya;
	
	private static final String TAG_PAGE = "Page";
	private static final String TAG_TITLE = "Title";
	
	private String title;
    private int page;
	
	public static FragmentPencapaianPengetahuan newInstance(int page, String title){
		FragmentPencapaianPengetahuan fr = new FragmentPencapaianPengetahuan();
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
		return inflater.inflate(R.layout.fragment_pencapaian_pengetahuan, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);

		DBAdapter = new DatabaseAdapter(getView().getContext());
		chart = (BarChart) getView().findViewById(R.id.chartPengetahuan);
		chart.setDescription("");
		chart.setDoubleTapToZoomEnabled(false);
		
		getTotalTerjawab();
		setBarChart();
		
	}

	private void getTotalTerjawab() {
		// TODO Auto-generated method stub

		this.fauna 		= DBAdapter.totalTerjawab(DatabaseAdapter.SOAL_KATEGORI_FAUNA);
		this.flora 	= DBAdapter.totalTerjawab(DatabaseAdapter.SOAL_KATEGORI_FLORA);
		this.mata_uang		= DBAdapter.totalTerjawab(DatabaseAdapter.SOAL_KATEGORI_MATA_UANG);
		this.budaya			= DBAdapter.totalTerjawab(DatabaseAdapter.SOAL_KATEGORI_BUDAYA);
	}
	
	private void setBarChart(){
		ArrayList<String> labels = new ArrayList<String>();
		labels.add("Fauna"); 
		labels.add("Flora"); 
		labels.add("Mata uang"); 
		labels.add("Budaya");
		
		ArrayList<BarEntry> entries = new ArrayList<>();
		entries.add(new BarEntry(fauna, 0));
		entries.add(new BarEntry(flora, 1));
		entries.add(new BarEntry(mata_uang, 2));
		entries.add(new BarEntry(budaya, 3));
		
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
