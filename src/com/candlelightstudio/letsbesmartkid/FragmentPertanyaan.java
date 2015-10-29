package com.candlelightstudio.letsbesmartkid;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class FragmentPertanyaan extends Fragment {

	private static final String TAG_PAGE = "page";
	private static final String TAG_TITLE = "title";
	
	private int page;
	private String title, kategori;
	
	private DatabaseAdapter DBAdapter;
	private ListView list;
	private Context ctx;
	
	public static FragmentPertanyaan newInstance(int page, String title){
		FragmentPertanyaan fp = new FragmentPertanyaan();
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
	public void onStart(){
		super.onStart();
		loadList();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceTsate){
		View v = inflater.inflate(R.layout.fragment_pertanyaan, container, false);
		return v;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		super.onActivityCreated(savedInstanceState);
		this.ctx = getView().getContext();
		list = (ListView) getView().findViewById(R.id.list);
		DBAdapter = new DatabaseAdapter(ctx);
		this.kategori = ((PilihPertanyaanActivityBaru)getActivity()).kategori;
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getView().getContext(), JawabPertanyaanActivity.class);
				i.putExtra(DatabaseAdapter.KEY_SOAL_KATEGORI, kategori);
				i.putExtra(DatabaseAdapter.KEY_SOAL_ID, id);
				startActivityForResult(i, position);
			}
		
		});
	}
	
	private void loadList(){
		Cursor soal = DBAdapter.fetchSoal(kategori);
		CustomCursorAdapter soalAdapter = new CustomCursorAdapter(ctx, soal);
		list.setAdapter(soalAdapter);
	}
	
	private class CustomCursorAdapter extends CursorAdapter{

		public CustomCursorAdapter(Context context, Cursor c) {
			super(context, c, 0);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			// TODO Auto-generated method stub
			//if(kategori.equals(DatabaseAdapter.SOAL_KATEGORI_MATA_UANG)){
				ImageView imgSoal = (ImageView) view.findViewById(R.id.imgListPertanyaan);
				String imgPath = cursor.getString(cursor.getColumnIndex(DatabaseAdapter.KEY_SOAL_GAMBAR));
				final Context ctx = view.getContext();
				
				try{
					InputStream iStream = view.getContext().getAssets().open(imgPath);
					imgSoal.setImageDrawable(Drawable.createFromStream(iStream, null));
				}catch(IOException e){
					InputStream iStream;
					try {
						iStream = view.getContext().getAssets().open("soal/no_image.png");
						imgSoal.setImageDrawable(Drawable.createFromStream(iStream, null));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						Toast.makeText(ctx, "Terjadi masalah pada aplikasi saat memuat soal", Toast.LENGTH_LONG).show();
					}
				}
				
			//}
			
			TextView txt = (TextView) view.findViewById(R.id.lblPertanyaan);
			ImageView img = (ImageView) view.findViewById(R.id.imgJawabStatus);
			
			String soal = cursor.getString(cursor.getColumnIndex(DatabaseAdapter.KEY_SOAL_PERTANYAAN));
			int status = cursor.getInt(cursor.getColumnIndex(DatabaseAdapter.KEY_SOAL_STATUS));
			
			txt.setText(soal);
			if(status==0)
				img.setVisibility(View.GONE);
			else
				img.setVisibility(View.VISIBLE);
			
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup container) {
			// TODO Auto-generated method stub
			return LayoutInflater.from(context).inflate(R.layout.list_pilih_pertanyaan, container, false);
		}
		
	}
	
}
