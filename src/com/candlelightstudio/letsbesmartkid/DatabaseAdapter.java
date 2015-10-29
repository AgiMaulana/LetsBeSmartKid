package com.candlelightstudio.letsbesmartkid;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter {

	private static final String DATABASE_NAME = "lets_be_smart_kid";
	private static final int DATABASE_VERSION = 8;
	private static final String TABLE_USER = "user";
	private static final String TABLE_SOAL = "soal";
	private static final String TABLE_JAWABAN = "jawaban";
	private static final String TABLE_PUSTAKA = "pustaka";
	
	// Field pada tabel USER
	public static final String KEY_USER_ID = "_id";
	public static final String KEY_USER_FIRST_NAME = "nama_depan";
	public static final String KEY_USER_LAST_NAME = "nama_belakang";
	public static final String KEY_USER_GENDER = "jenis_kelamin";
	public static final String KEY_USER_SCHOOL = "sekolah";
	
	// Field pada tabel SOAL
	public static final String KEY_SOAL_ID = "_id";
	public static final String KEY_SOAL_JENIS = "jenis";
	public static final String KEY_SOAL_KATEGORI = "kategori";
	public static final String KEY_SOAL_GAMBAR = "gambar";
	public static final String KEY_SOAL_PERTANYAAN = "pertanyaan";
	public static final String KEY_SOAL_STATUS = "status";
	public static final String KEY_SOAL_TANGGAL_TERJAWAB = "tanggal_terjawab";
	
	// Field Pilihan jawaban
	public static final String KEY_JAWAB_ID = "_id";
	public static final String KEY_JAWAB_SOAL_ID = "soal_id";
	public static final String KEY_JAWAB_TEXT = "pilih_jawaban";
	public static final String KEY_JAWAB_STATUS = "status";
	
	// Field PUSTAKA
	public static final String KEY_PUSTAKA_ID = "_id";
	public static final String KEY_PUSTAKA_SOAL_ID = "soal_id";
	public static final String KEY_PUSTAKA_JUDUL = "judul";
	public static final String KEY_PUSTAKA_DESKRIPSI = "deskripsi";

	public static final String SOAL_JENIS_ETIKA = "etika";
	public static final String SOAL_JENIS_UMUM = "umum";
	
	public static final String SOAL_KATEGORI_FLORA = "flora";
	public static final String SOAL_KATEGORI_FAUNA = "fauna";
	public static final String SOAL_KATEGORI_BUDAYA = "budaya";
	public static final String SOAL_KATEGORI_MATA_UANG = "mata_uang";
	
	public static final String SOAL_KATEGORI_RUMAH = "rumah";
	public static final String SOAL_KATEGORI_SEKOLAH = "sekolah";
	public static final String SOAL_KATEGORI_SOSIAL = "sosial";
	public static final String SOAL_KATEGORI_FASILITAS_UMUM = "fasilitas_umum";
	
	private static final String[] KOLOM_USER = new String[]{KEY_USER_FIRST_NAME, KEY_USER_LAST_NAME,KEY_USER_GENDER, KEY_USER_SCHOOL};
	private static final String[] KOLOM_SOAL = new String[]{KEY_SOAL_ID, KEY_SOAL_JENIS, KEY_SOAL_KATEGORI, KEY_SOAL_GAMBAR, KEY_SOAL_PERTANYAAN, KEY_SOAL_STATUS, KEY_SOAL_TANGGAL_TERJAWAB};
	private static final String[] KOLOM_JAWABAN = new String[]{KEY_JAWAB_ID, KEY_JAWAB_SOAL_ID, KEY_JAWAB_TEXT, KEY_JAWAB_STATUS};
	private static final String[] KOLOM_PUSTAKA = new String[]{KEY_PUSTAKA_ID, KEY_PUSTAKA_SOAL_ID, KEY_PUSTAKA_JUDUL, KEY_PUSTAKA_DESKRIPSI};
	
	
	private DBHelper dbHelper;
	private SQLiteDatabase mDb;
	private Context mCtx;
	
	// Membuat tabel USER
	private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" + KEY_USER_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_USER_FIRST_NAME + " TEXT NOT NULL, " + KEY_USER_LAST_NAME + " TEXT NOT NULL, " + KEY_USER_GENDER + " TEXT NOT NULL, " + KEY_USER_SCHOOL + " TEXT NOT NULL)";
	
	// Membuat tabel SOAL
	private static final String CREATE_TABLE_SOAl = "CREATE TABLE " + TABLE_SOAL + "(" + KEY_SOAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_SOAL_JENIS + " TEXT NOT NULL, " + KEY_SOAL_KATEGORI + " TEXT NOT NULL, " + KEY_SOAL_GAMBAR + " TEXT NOT NULL, " + KEY_SOAL_PERTANYAAN + " TEXT NOT NULL, " + KEY_SOAL_STATUS + " INTEGER NULL, " + KEY_SOAL_TANGGAL_TERJAWAB + " TEXT NULL)";
	
	// Membuat tabel PILIHAN JAWABAN
	private static final String CREATE_TABLE_JAWABAN = "CREATE TABLE " + TABLE_JAWABAN + "(" + KEY_JAWAB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_JAWAB_SOAL_ID + " LONG NOT NULL, " + KEY_JAWAB_TEXT + " TEXT NOT NULL, " + KEY_JAWAB_STATUS + " INTEGER)";
	
	// Membuat tabel PUSTAKA
	private static final String CREATE_TABLE_PUSTAKA = "CREATE TABLE " + TABLE_PUSTAKA + "(" + KEY_PUSTAKA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PUSTAKA_SOAL_ID  + " INTEGER NOT NULL," + KEY_PUSTAKA_JUDUL + " TEXT NOT NULL, " + KEY_PUSTAKA_DESKRIPSI + " TEXT NOT NULL)";
	private static class DBHelper extends SQLiteOpenHelper{

		public DBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_TABLE_USER);
			db.execSQL(CREATE_TABLE_SOAl);
			db.execSQL(CREATE_TABLE_JAWABAN);
			db.execSQL(CREATE_TABLE_PUSTAKA);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_SOAL);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_JAWABAN);
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_PUSTAKA);
			onCreate(db);
		}
		
	}
	
	public DatabaseAdapter(Context ctx){
		this.mCtx = ctx;
		dbHelper = new DBHelper(mCtx);
		mDb = dbHelper.getWritableDatabase();
	} 
	
	public void close(){
		dbHelper.close();
	}
	
	public void reset(){
		mDb.execSQL("DELETE * FROM " + TABLE_USER);
		mDb.execSQL("DELETE * FROM " + TABLE_SOAL);
		mDb.execSQL("DELETE * FROM " + TABLE_JAWABAN);
		mDb.execSQL("DELETE * FROM " + TABLE_PUSTAKA);
	}
	
	public long insertSoal(String jenis, String kategori, String path, String pertanyaan){
		ContentValues cv = new ContentValues();
		cv.put(KEY_SOAL_JENIS, jenis);
		cv.put(KEY_SOAL_KATEGORI, kategori);
		cv.put(KEY_SOAL_GAMBAR, path);
		cv.put(KEY_SOAL_PERTANYAAN, pertanyaan);
		cv.put(KEY_SOAL_STATUS, 0);
		return mDb.insert(TABLE_SOAL, null, cv);
	}

	public long insertJawaban(long soalId, String jawaban, int status){
		ContentValues cv = new ContentValues();
		cv.put(KEY_JAWAB_SOAL_ID, soalId);
		cv.put(KEY_JAWAB_TEXT, jawaban);
		cv.put(KEY_JAWAB_STATUS, status);
		return mDb.insert(TABLE_JAWABAN, null, cv);
	}

	public long insertUser(String nama_depan, String nama_belakang, String kelamin, String sekolah){
		ContentValues cv = new ContentValues();
		cv.put(KEY_USER_FIRST_NAME, nama_depan);
		cv.put(KEY_USER_LAST_NAME, nama_belakang);
		cv.put(KEY_USER_GENDER, kelamin);
		cv.put(KEY_USER_SCHOOL, sekolah);
		return mDb.insert(TABLE_USER, null,cv);
	}
	
	public long updateStatusSoal(long soalId){
		ContentValues cv = new ContentValues();
		cv.put(KEY_SOAL_STATUS, 1);
		cv.put(KEY_SOAL_TANGGAL_TERJAWAB, getDateTime());
		return mDb.update(TABLE_SOAL, cv, KEY_SOAL_ID + " = " + soalId, null);
	}
	
	public long insertPustaka(long soalId, String judul, String deskripsi){
		ContentValues cv = new ContentValues();
		cv.put(KEY_PUSTAKA_SOAL_ID, soalId);
		cv.put(KEY_PUSTAKA_JUDUL, judul);
		cv.put(KEY_PUSTAKA_DESKRIPSI, deskripsi);
		return mDb.insert(TABLE_PUSTAKA, null, cv);
	}

//	public Cursor fetchSoalEtika(String kategori){
//		String selection = KEY_SOAL_JENIS + " = '" + SOAL_JENIS_ETIKA +"' AND "+ KEY_SOAL_KATEGORI + " = '"+ kategori +"'";
//		Cursor soal = mDb.query(TABLE_SOAL, KOLOM_SOAL, selection , null, null, null, null);
//		if(soal!=null)
//			soal.moveToFirst();
//		return soal;
//	}
	
	public Cursor fetchSoal(String kategori){
		String selection = KEY_SOAL_KATEGORI + " = '"+ kategori +"'";
		Cursor soal = mDb.query(TABLE_SOAL, KOLOM_SOAL, selection , null, null, null, null);
		if(soal!=null)
			soal.moveToFirst();
		return soal;		
	}
	
	public Cursor fetchSoal(long soalId){
		Cursor soal = mDb.query(TABLE_SOAL, KOLOM_SOAL, KEY_SOAL_ID + " = " + soalId, null, null, null, null);
		if(soal!=null)
			soal.moveToFirst();
		return soal;
	}

	public Cursor fetchJawaban(long soalId){
		Cursor jawaban = mDb.query(TABLE_JAWABAN, KOLOM_JAWABAN, KEY_JAWAB_SOAL_ID + " = "+ soalId, null, null, null, null);
		if(jawaban!=null)
			jawaban.moveToFirst();
		return jawaban;
	}
	
	public Cursor fetchDictionary(String kategori){
		String[] kolom = new String[]{TABLE_PUSTAKA+".*"};
		Cursor pustaka = mDb.query(TABLE_PUSTAKA +" CROSS JOIN "+ TABLE_SOAL, kolom , TABLE_PUSTAKA +"."+KEY_PUSTAKA_ID + "=" + TABLE_SOAL+"."+KEY_SOAL_ID +" and " + TABLE_SOAL+"."+KEY_SOAL_KATEGORI+"='"+kategori+"'", null, null, null, null);
//		if(pustaka.getCount() < 1)
//			pustaka = mDb.query(TABLE_PUSTAKA +" CROSS JOIN "+ TABLE_SOAL, kolom, TABLE_PUSTAKA +"."+KEY_PUSTAKA_ID + "=" + TABLE_SOAL+"."+KEY_SOAL_ID +" and " + TABLE_SOAL+"."+KEY_SOAL_KATEGORI+"='"+kategori+"'" , null, null, null, null, "1");
		if(pustaka != null)
			pustaka.moveToFirst();
		return pustaka;
	}
	
	public String[] fetchPenjelasan(long soalId){
		Cursor pustaka = mDb.query(TABLE_PUSTAKA, KOLOM_PUSTAKA, KEY_SOAL_ID + " = " + soalId, null, null, null, null);
		String[] s = new String[3];
		if(pustaka!=null)
			pustaka.moveToFirst();
		
		Cursor img = fetchSoal(soalId);
		s[0] = img.getString(img.getColumnIndex(KEY_SOAL_GAMBAR));
		s[1] = pustaka.getString(pustaka.getColumnIndex(KEY_PUSTAKA_JUDUL));
		s[2] = pustaka.getString(pustaka.getColumnIndex(KEY_PUSTAKA_DESKRIPSI));
		
		return s;
	}
	
	public Cursor getUserInfo(){
		Cursor user = mDb.query(TABLE_USER, KOLOM_USER, null, null, null, null, null);
		if(user!=null)
			user.moveToFirst();
		return user;
	}
	
	public boolean soalIsEmpty(){
		Cursor cursor = mDb.query(TABLE_SOAL, KOLOM_SOAL, null, null, null, null, null);
		if(cursor.getCount() == 0)
			return true;
		else
			return false;
	}
	
	public boolean userIsExists(){
		boolean flag = false;
		String[] kolom = new String[]{KEY_USER_ID, KEY_USER_FIRST_NAME, KEY_USER_LAST_NAME, KEY_USER_GENDER};
		Cursor user = mDb.query(TABLE_USER, kolom, null, null, null, null, null);
		if(user!=null)
			user.moveToFirst();
		
		if(user.getCount()>0)
			flag = true;
		return flag;
	}
	
	public boolean isTrue(long jawabanId){
		Cursor status = mDb.query(TABLE_JAWABAN, KOLOM_JAWABAN, KEY_JAWAB_ID + " = " + jawabanId, null, null, null, null);
		if(status!=null)
			status.moveToFirst();
		if(status.getInt(status.getColumnIndex(KEY_JAWAB_STATUS)) == 1)
			return true;
		else
			return false;
	}
	
	public int totalTerjawab(String kategori){
		int i=0;
		try{
			Cursor soal = mDb.query(TABLE_SOAL, KOLOM_SOAL, KEY_SOAL_KATEGORI + " ='"+ kategori +"' AND " + KEY_SOAL_STATUS + " = '" + 1 + "'", null, null, null, null);
			if(soal != null)
				i = soal.getCount();
			
		}catch(SQLiteException e){
			i=0;
		}
		
		return i;
	}
	
	private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyyy", Locale.US);
        Date date = new Date();
        return dateFormat.format(date);
}
}