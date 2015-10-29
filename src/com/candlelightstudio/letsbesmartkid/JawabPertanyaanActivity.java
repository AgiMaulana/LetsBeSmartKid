package com.candlelightstudio.letsbesmartkid;

import java.io.IOException;
import java.io.InputStream;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class JawabPertanyaanActivity extends FragmentActivity implements OnClickListener{

	private RadioGroup PG;
	private RadioButton pilih, A, B, C, D;
	private Button ok;
	
	private DatabaseAdapter DBAdapter;
	public Long soalId;
	private int[] jawabanStatus = new int[4];
	private boolean[] pgSelected = new boolean[4];

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jawab_pertanyaan);
		
	    getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
		
		Bundle b = getIntent().getExtras();
		this.soalId = b.getLong(DatabaseAdapter.KEY_SOAL_ID);
		
		PG = (RadioGroup) findViewById(R.id.pilihanPG);
		this.A = (RadioButton) findViewById(R.id.radioPG_A);
		this.B = (RadioButton) findViewById(R.id.radioPG_B);
		this.C = (RadioButton) findViewById(R.id.radioPG_C);
		this.D = (RadioButton) findViewById(R.id.radioPG_D);
		
		ok = (Button) findViewById(R.id.btnJawabOk);
		ok.setEnabled(false);
		DBAdapter = new DatabaseAdapter(this);
		Cursor soal = DBAdapter.fetchSoal(soalId);
		
		String imgPath = soal.getString(soal.getColumnIndex(DatabaseAdapter.KEY_SOAL_GAMBAR));
		ImageView img = (ImageView) findViewById(R.id.imgJawabPertanyaan);
		try{
			InputStream iStream = getAssets().open(imgPath);
			img.setImageDrawable(Drawable.createFromStream(iStream, null));
		}catch(IOException e){
			InputStream iStream;
			try {
				iStream = getAssets().open("soal/no_image.png");
				img.setImageDrawable(Drawable.createFromStream(iStream, null));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				Toast.makeText(getApplicationContext(), "Terjadi masalah pada aplikasi saat memuat soal", Toast.LENGTH_LONG).show();
			}
		}
		String soalText = soal.getString(soal.getColumnIndex(DatabaseAdapter.KEY_SOAL_PERTANYAAN));
		TextView labelSoal = (TextView) findViewById(R.id.lbl_jawabPertanyaan);
		labelSoal.setText(soalText);
		
		Cursor pg = DBAdapter.fetchJawaban(soalId);
		
		String pilihan = pg.getString(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_TEXT));
		jawabanStatus[0] = pg.getInt(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_STATUS));
		A.setText(pilihan);
		pg.moveToNext();
		
		pilihan = pg.getString(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_TEXT));
		jawabanStatus[1] = pg.getInt(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_STATUS));
		B.setText(pilihan);
		pg.moveToNext();
		
		
		pilihan = pg.getString(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_TEXT));
		jawabanStatus[2] = pg.getInt(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_STATUS));
		C.setText(pilihan);
		pg.moveToNext();
		
		
		pilihan = pg.getString(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_TEXT));
		jawabanStatus[3] = pg.getInt(pg.getColumnIndex(DatabaseAdapter.KEY_JAWAB_STATUS));
		D.setText(pilihan);
		pg.moveToNext();
		
		A.setOnClickListener(this);
		B.setOnClickListener(this);
		C.setOnClickListener(this);
		D.setOnClickListener(this);
		
		ok.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ok.setEnabled(true);
		ok.setBackgroundColor(getResources().getColor(R.color.jawab_ok_enable));
		switch(v.getId()){
		case R.id.radioPG_A:
			pgSelected[0] = true;
			pgSelected[1] = false;
			pgSelected[2] = false;
			pgSelected[3] = false;
			B.setChecked(false);
			C.setChecked(false);
			D.setChecked(false);
		break;
		case R.id.radioPG_B:
			pgSelected[0] = false;
			pgSelected[1] = true;
			pgSelected[2] = false;
			pgSelected[3] = false;
			A.setChecked(false);
			C.setChecked(false);
			D.setChecked(false);
		break;
		case R.id.radioPG_C:
			pgSelected[0] = false;
			pgSelected[1] = false;
			pgSelected[2] = true;
			pgSelected[3] = false;
			A.setChecked(false);
			B.setChecked(false);
			D.setChecked(false);
		break;
		case R.id.radioPG_D:
			pgSelected[0] = false;
			pgSelected[1] = false;
			pgSelected[2] = false;
			pgSelected[3] = true;
			A.setChecked(false);
			B.setChecked(false);
			C.setChecked(false);
		break;
		case R.id.btnJawabOk:
			if(jawabIsTrue()){
				DialogJawabBenar alert = new DialogJawabBenar();
				alert.show(getSupportFragmentManager(), "Benar");
				DBAdapter.updateStatusSoal(soalId);
			}else{
				final DialogJawabSalah alert = new DialogJawabSalah();
				alert.show(getSupportFragmentManager(), "Salah");

				new CountDownTimer(2500, 1000) {
					
					@Override
					public void onTick(long millisUntilFinished) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void onFinish() {
						// TODO Auto-generated method stub
						alert.dismiss();
						onBackPressed();
					}
				}.start();
			}
		break;
		default:
		break;
		}
	}
	
	private boolean jawabIsTrue(){
		for(int i=0; i<4; i++)
			if(pgSelected[i] && jawabanStatus[i] == 1) return true;
		return false;
	}

	public void restartParent(){
		Intent myIntent = getIntent();
		String kategori = myIntent.getStringExtra(DatabaseAdapter.KEY_SOAL_KATEGORI);
		Intent i = new Intent(getApplicationContext(), PilihPertanyaanActivityBaru.class);
		i.putExtra(DatabaseAdapter.KEY_SOAL_KATEGORI, kategori);
		startActivity(i);
	}
	
	@Override
	public boolean onNavigateUp () {
	    onBackPressed();
	    return true;
	}
	
}
