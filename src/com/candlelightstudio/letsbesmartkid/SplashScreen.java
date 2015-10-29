package com.candlelightstudio.letsbesmartkid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
	
	private DatabaseAdapter DBAdapter;
	private static final int timeout = 5000;
	private boolean userEksis;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		DBAdapter = new DatabaseAdapter(this);
		userEksis = DBAdapter.userIsExists();
	}
	
	public void NextActivity(){
		Intent act;
		if(!userEksis){
			act = new Intent(getApplicationContext(), IsiNama_Activity.class);
		}else{
			act = new Intent(getApplicationContext(), MainActivityBaru.class);
		}
		startActivity(act);
	}

	@Override
	public void onStart(){
		super.onStart();
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {
				NextActivity();
				finish();
			}
			
		}, timeout);
	}

	@Override
	public void onDestroy(){
		super.onDestroy();
		DBAdapter.close();
	}
	
}
