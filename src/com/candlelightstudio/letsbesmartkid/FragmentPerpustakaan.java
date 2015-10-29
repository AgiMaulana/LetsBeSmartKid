package com.candlelightstudio.letsbesmartkid;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentPerpustakaan extends Fragment{

	private static final String TAG_PAGE = "page";
	private static final String TAG_TITLE = "title";
	
	private int page;
	private String title, kategori;
	
	public static FragmentPerpustakaan newInstance(int page, String title){
		FragmentPerpustakaan fp = new FragmentPerpustakaan();
		Bundle b = new Bundle();
		b.putInt(TAG_PAGE, page);
		b.putString(TAG_TITLE, title);
		fp.setArguments(b);
		return fp;
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		page = getArguments().getInt(TAG_PAGE,0);
		title = getArguments().getString(TAG_TITLE);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		return inflater.inflate(R.layout.fragment_perpustakaan, container, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		this.kategori = ((PilihPertanyaanActivityBaru)getActivity()).kategori;
		DatabaseAdapter DBAdapter = new DatabaseAdapter(getView().getContext());
		ListView list = (ListView) getView().findViewById(R.id.list);
		CustomCursorAdapter adapter = new CustomCursorAdapter(getView().getContext(), DBAdapter.fetchDictionary(kategori));
		
		list.setAdapter(adapter);
		TextView lbl = (TextView) getView().findViewById(R.id.lblCautionDictionary);
		Cursor cursor = DBAdapter.fetchDictionary(kategori);
		lbl.setText("Jawab dengan benar soal - soal yang ada untuk membuka koleksi perpustakaan kamu");

		if(cursor.getCount() == 1)
			lbl.setText("Jawab soal lainnya untuk membuka lebih banyak koleksi perpustakaan");
		else if(cursor.getCount() > 1)
			lbl.setVisibility(View.GONE);
		
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Bundle setter = new Bundle();
				setter.putLong(DatabaseAdapter.KEY_SOAL_ID, id);
				DialogBacaPerpustakaan baca = new DialogBacaPerpustakaan();
				baca.setArguments(setter);
				baca.setCancelable(false);
				baca.show(getChildFragmentManager(), "Dialog baca");
			}
			
		});
	}
	
	private class CustomCursorAdapter extends CursorAdapter{

		public CustomCursorAdapter(Context context, Cursor c) {
			super(context, c, 0);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			// TODO Auto-generated method stub
			
			String judul = cursor.getString(cursor.getColumnIndex(DatabaseAdapter.KEY_PUSTAKA_JUDUL));
			TextView lblJudul = (TextView) view.findViewById(R.id.lblPerpustakaan);
			lblJudul.setText(judul);
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup container) {
			// TODO Auto-generated method stub
			return LayoutInflater.from(context).inflate(R.layout.list_perpustakaan, container, false);
		}
		
	}
	
}
