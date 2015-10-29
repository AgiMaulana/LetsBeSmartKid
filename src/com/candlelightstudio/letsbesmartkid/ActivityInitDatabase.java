package com.candlelightstudio.letsbesmartkid;

import com.candlelightstudio.letsbesmartkid.CircularProgressBar.ProgressAnimationListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ActivityInitDatabase extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_init_database);
	}

	@Override
	protected void onStart(){
		super.onStart();
		DatabaseAdapter DBAdapter = new DatabaseAdapter(this);
		boolean soalKosong = DBAdapter.soalIsEmpty();
		if(soalKosong)
			new InitDatabase(this);
		final CircularProgressBar progress = (CircularProgressBar) findViewById(R.id.progressInitDB);
		progress.animateProgressTo(0, 100, new ProgressAnimationListener(){

			@Override
			public void onAnimationStart() {
				// TODO Auto-generated method stub
				progress.setSubTitle("Tunggu...");
			}

			@Override
			public void onAnimationFinish() {
				// TODO Auto-generated method stub
				progress.setSubTitle("Selesai");
			}

			@Override
			public void onAnimationProgress(int percent) {
				//TODO Auto-generated method stub
				progress.setTitle(percent + "%");
				if(percent == 100){
					TextView lblTouch = (TextView) findViewById(R.id.lblTouchAnywhere);
					lblTouch.setText("Ketuk dimana saja untuk memulai");
					touchAnywhere();
				}
			}
			
		});
	}
	
	protected void touchAnywhere() {
		// TODO Auto-generated method stub
		RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.layoutInitDatabase);
		mainLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), MainActivityBaru.class));
				finish();
			}
		});
	}
}
