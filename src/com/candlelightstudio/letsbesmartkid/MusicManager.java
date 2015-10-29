package com.candlelightstudio.letsbesmartkid;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicManager {

	public static final int SUARA_BENAR = R.raw.benar;
	public static final int SUARA_SALAH = R.raw.salah;
	
	public static void start(Context context, int musik){
		MediaPlayer player = MediaPlayer.create(context, musik);
		player.setLooping(false);
		player.setVolume(1, 1);
		player.start();
	}
	
}
