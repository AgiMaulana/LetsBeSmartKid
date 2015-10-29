package com.candlelightstudio.letsbesmartkid;

import android.content.Context;

public class InitDatabase {
	
	private Context ctx;
	private DatabaseAdapter DBAdapter;
	
	public InitDatabase(Context context){
		this.ctx = context;
		DBAdapter = new DatabaseAdapter(ctx);
		if(DBAdapter.soalIsEmpty()){
			initSoalRumah();
			initSoalSekolah();
			initSoalSosial();
			
			initSoalMataUang();
			initSoalFauna();
			initSoalFlora();
			initSoalBudaya();
		}
		DBAdapter.close();
	}
	
	private void initSoalSosial(){
		long soalId;
		String[] jawaban;
		int[] status;
		
		String assets = "soal/sosial/";
		
		soalId = insertSoalSosial(assets + "1.png", "Jika tetangga sedang mangadakan kerja bakti , kita sebaiknya ...");
		jawaban = new String[]{"Membantunya","Mengunci rumah", "Pergi keluar", "Bermain"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Membantunya", "Kita harus ikut membantu tetangga yang sedang kerja bakti");	

		soalId = insertSoalSosial(assets + "2.png", "Apabila tetangga kita meminta tolong sebaiknya kita ...");
		jawaban = new String[]{"Membantunya","Membiarkannya", "Menjauhinya", "Melupakannya"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Membantunya", "Kita harus ikut membantu tetangga yang membutuhkan pertolongan");

		soalId = insertSoalSosial(assets + "3.png", "Apabila tetangga sedang sakit sebaiknya kita  ...");
		jawaban = new String[]{"Menjenguknya","Membiarkannya", "Menjauhinya", "Melupakannya"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Menjenguknya", "Kita harus menjenguknya dan mendoakannya");

		soalId = insertSoalSosial(assets + "4.png", "Dengan teman yang berbeda agama kita harus....");
		jawaban = new String[]{"Memusuhi","Menghormati", "Memarahi", "Memaki-maki"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Menghormati", "Meskipun kita berbeda agama tetapi kita harus saling menghormati");

		soalId = insertSoalSosial(assets + "5.png", "Anak laki-laki dan perempuan harus hidup....");
		jawaban = new String[]{"Rukun","Sedih", "Sendiri", "Marah"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Rukun", "Meskipun kita berbeda kita juga memiliki hak yang sama, kita juga harus hidup rukun dan tentram");

		soalId = insertSoalSosial(assets + "6.png", "Jika saling menghargai akan terhindar dari....");
		jawaban = new String[]{"Kerukunan","Persahabatan", "Permusuhan", "Ketentraman"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Kerukunan", "jika kita ingin hidup kita rukun sebaiknya kita harus saling menghargai agar terhindar dari hal-hal yang tidak diinginkan");

		soalId = insertSoalSosial(assets + "7.png", "Tolong menolong dapat....");
		jawaban = new String[]{"Meringankan beban","Menambah beban", "Memberatkan beban", "Membuat orang berkelahi"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Meringankan beban", "Tolong menolong dapat meringankan beban dan mempercepat pekerjaan, jadi kita dapat menghemat waktu juga");

		soalId = insertSoalSosial(assets + "8.png", "Anak jujur selalu berkata....");
		jawaban = new String[]{"Bohong","Benar", "Halus", "Kasar"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Benar", "Orang jujur selalu berkata benar, perkataannya tidak dilebih-lebihi dan tidak di kurang-kurangi");

		soalId = insertSoalSosial(assets + "9.png", "Jika kita berbohong maka kita....");
		jawaban = new String[]{"Tidak dipercaya semua orang","Akan disayang semua orang", "Akan banyak teman", "Melupakannya"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Tidak dipercaya semua orang", "Jika kita selalu berbohong maka kita tidak akan dipercaya semua orang lagi");

		soalId = insertSoalSosial(assets + "10.png", "Contoh disiplin dijalan raya....");
		jawaban = new String[]{"Melanggar lampu merah","Menyebrang jalan sembarangan", "Menggunakan helm standar", "Tidak memakai helm"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Menggunakan helm standar", "Menggunakan helm standar merupakan contoh disiplin dijalan raya, itu sesuai dengan peraturannya");

		soalId = insertSoalSosial(assets + "11.png", "Ikut kerja bakti berarti....");
		jawaban = new String[]{"Bekerja disekolah","Bekerja dirumah", "Bekerja dimasyarakat", "Bekerja dikantor"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Bekerja dimasyarakat", "ikut kerja bakti merupakan contoh kerjasama di lingkungan masyarakat");

		soalId = insertSoalSosial(assets + "12.png", "Warga masyrakat yang melanggar peraturan akan mendapat....");
		jawaban = new String[]{"Sanksi","Celaan", "Pujian", "Melupakannya"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Sanksi", "Setiap orang yang melanggar peraturan akan diberi sanksi, agar dia tidak mengulangi perbuatan melanggar peraturan lagi");

		soalId = insertSoalSosial(assets + "13.png", "Menjaga kebersihan merupakan tanggung jawab dari...");
		jawaban = new String[]{"Ketua RT","Ketua RW", "Warga masyarakat", "Orang tua"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Warga masyarakat", "Tanggung jawab untuk menjaga kebersihan dilingkungan mana pun merupakan tanggung jawab warga masyarakat (kita semua)");

		soalId = insertSoalSosial(assets + "14.png", "Jika ada seseorang yang berbuat baik kepadamu, kata yang kamu ucapkan adalah....");
		jawaban = new String[]{"Terimakasih","Sama-sama", "Maaf", "Melupakannya"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Terimakasih", "Saat kita dibantu apapun oleh orang sebaiknya kita mengucapkan terimakasih, itu contoh tanda orang yang menghargai");

		soalId = insertSoalSosial(assets + "15.png", "Contoh berbicara yang baik berdasarkan tata krama adalah....");
		jawaban = new String[]{"Panjang lebar","Jelas dan sopan", "Keras dan berani", "Membentak"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Jelas dan sopan", "Contoh berbicara yang sopan sesuai dengan tatakrama itu kita berbica jelas dan sopan");
	}
	
	private void initSoalRumah(){
		long soalId;
		String[] jawaban;
		int[] status;
		
		String assets = "soal/rumah/";
		
		soalId = insertSoalRumah(assets + "1.png", "Apabila kita hendak bepergian keluar rumah , sebaiknya kita ...");
		jawaban = new String[]{"Menengok kanan kiri","Mengucapkan salam", "keluar tanpa bilang", "Berlari"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mengucapkan salam", "Kita harus megucapkan salam, agar kita selamat sampai tujuan kita");

		soalId = insertSoalRumah(assets + "2.png", "Apabila kita hendak bersendawa sebaiknya kita ...");
		jawaban = new String[]{"Membuka mulut dengan lebar","Menutup mulut", "Bersendawa dengan keras", "Bersendawa di depan orang lain"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Menutup mulut", "Kita harus menutup mulut kita, agar terlihat sopan di depan orang lain"); 

		soalId = insertSoalRumah(assets + "3.png", "Apabila kita hendak makan sebaiknya kita ...");
		jawaban = new String[]{"Berdoa","Berlari", "Bercanda", "Bersendawa"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Berdoa", "Kita harus berdoa sebelum makan , agar dapat berkah");

		soalId = insertSoalRumah(assets + "4.png", "Apabila kita melihat ibu kita sedang mengepel sebaiknya kita  ...");
		jawaban = new String[]{"Menginjaknya","Minggir", "Berlari", "Mengotorinya"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Minggir", "Ketika ibu kita sedang mnegepel lantai sebaiknya kita minggir dan tidak menginjaknya lagi");

		soalId = insertSoalRumah(assets + "5.png", "Apabila kita melihat benda tajam di lantai sebaiknya kita  ...");
		jawaban = new String[]{"Menginjaknya","Mengamankannya", "Melihatnya", "Menjauhinya"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mengamankannya", "Kita harus melakukan hal itu, karena jika tidak, akan merugikan orang lain");

		soalId = insertSoalRumah(assets + "6.png", "Setelah bangun tidur sebaiknya....");
		jawaban = new String[]{"Membereskan tempat tidur","Langsung main", "Langsung makan", "Langsung mandi"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Membereskan tempat tidur", "Setelah bangun tidur sebaiknya langsung membereskan tempat tidur, merupakan contoh membantu ibu dirumah");

		soalId = insertSoalRumah(assets + "7.png", "Sebelum berangkat sekolah sebaiknya kita.... kepada orangtua");
		jawaban = new String[]{"Pamit","Pergi", "Pulang", "Marah"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Pamit", "Saat kita akan berangkat kesekolah atau main sebaiknya kita berpamitan dulu kepada orangtua");

		soalId = insertSoalRumah(assets + "8.png", "Pakaian yang bersih disimpan di....");
		jawaban = new String[]{"Lemari","Kamar mandi", "Ruang tamu", "Kamar ibu dan ayah"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Lemari", "Pakaian yang bersih sebaiknya disimpan dilemari agar terlihat rapi");

		soalId = insertSoalRumah(assets + "9.png", "Jika melihat ibu sedang membereskan rumah, sebaiknya kita...");
		jawaban = new String[]{"Melihat saja","Bermain", "Memberantakkan rumah", "Membantunya"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Membantunya", "Saat kita melihat ibu membereskan rumah sebaiknya kita membantunya, jangan hanya melihatnya dan memberantakkan kembali");

		soalId = insertSoalRumah(assets + "10.png", "Contoh tindakan disiplin adalah");
		jawaban = new String[]{"Mengerjakan pekerjaan rumah","Terlambat sekolah", "Bangun kesiangan", "Tidak tepat waktu"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mengerjakan pekerjaan rumah", "Mengerjakan pekerjaan rumah merupakan contoh tindakan disiplin");

		soalId = insertSoalRumah(assets + "11.png", "Jika orang tua sedang menasihati sebaiknya kita....");
		jawaban = new String[]{"Tidak peduli","Mendengarkan", "Menirukan", "Menggerutu"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mendengarkan", "Saat orang tua menasihati sebaiknya kita mendengarkan dia, jangan sampai kita marah-marah apalagi menggerutu");

		soalId = insertSoalRumah(assets + "12.png", "Hak anak dirumah mendapatkan kasih sayang dari....");
		jawaban = new String[]{"Orangtua","Guru", "Tetangga", "Ketua RT"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Orangtua", "hak anak dirumah itu yaitu mendapatkan kasih sayang dan perhatian dari otang tua");

		soalId = insertSoalRumah(assets + "13.png", "Saudara kita yang dari kampung akan menginap dirumah kita, maka sebaiknya kita melaporkan kedatangannya kepada....");
		jawaban = new String[]{"Ketua RT","Tetangga", "Hansip", "Teman-teman"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Ketua RT", "saat ada yang bertamu ke rumah kita dan dia akan menginap dirumah, sebaiknya kita melapor ke Ketua RT agar terdaftar");

		soalId = insertSoalRumah(assets + "14.png", "Jika kamu akan bertamu, sikap yang baik adalah....");
		jawaban = new String[]{"Langsung masuk ke rumah","Mengetuk pintu dahulu", "Memangil namanya", "Berlari"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mengetuk pintu dahulu", "Etika saat akan bertamu itu harus mengetuk pintu dulu, jika pemilik rumah mempersilahkan masuk kita baru boleh masuk, dan jika pemilik rumah tersebut mempersilahkan duduk baru kita duduk");

		soalId = insertSoalRumah(assets + "15.png", "Dirumah kita harus hormat kepada....");
		jawaban = new String[]{"Guru","Tetangga", "Orangtua", "Ketua RT"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Orangtua", "Dirumah kita harus hormat kepada Orangtua, sedangkan Disekolah kita harus hormat kepada guru");
	}
	
	private void initSoalSekolah(){
		long soalId;
		String[] jawaban;
		int[] status;
		
		String assets = "soal/sekolah/";
		
		soalId = insertSoalSekolah(assets + "1.png", "Apabila kita hendak berangkat sekolah sebaiknya kita menggunakan seragam yang ...");
		jawaban = new String[]{"Rapi dan bersih","Bau", "Kotor", "Berantakan"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Rapi dan bersih", "Kita harus memakai pakaian yang rapi dan bersih agar terlihat orang yang terpelajar");

		soalId = insertSoalSekolah(assets + "2.png", "Apabila kita hendak masuk ke dalam ruang kelas , sebaiknya kita  ...");
		jawaban = new String[]{"Teriak-teriak","Mengucapkan salam", "Berlari", "Merangkak"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mengucapkan salam", "Kita harus  mengucapkan salam agar dilihat bahwa kita anak yang sopan");

		soalId = insertSoalSekolah(assets + "3.png", "Apabila guru menerangkan di depan kelas sebaiknya kita  ...");
		jawaban = new String[]{"Teriak-teriak","Berbicara juga", "Bercanda", "Memperhatikan"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Memperhatikan", "Kita harus memperhatikan guru yang menerangkan agar kita paham");

		soalId = insertSoalSekolah(assets + "4.png", "Apabila kita melihat teman kita yang berkelahi sebaiknya kita ...");
		jawaban = new String[]{"Menjauhinya","Menontonnya", "Membantunya", "Melerainya"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Melerainya", "Kita harus melerainya dan jangan sampai perkelahian terjadi lagi");

		soalId = insertSoalSekolah(assets + "5.png", "Apabila ada tetangga yang menyapa sebaiknya kita ...");
		jawaban = new String[]{"Menyapanya kembali","Mengacuhkannya", "Melupakannya", "Melihatnya"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Menyapanya kembali", "Kita harus menyapanya kembali agar tidak dinilai sombong");

		soalId = insertSoalSekolah(assets + "6.png", "Jika teman kita tidak membawa pensil apa yang harus kita lakukan?");
		jawaban = new String[]{"Memberinya pinjaman","Mengacuhkannya", "Melupakannya", "Melihatnya"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Memberinya pinjaman", "jika teman tidak membawa pensil(alat tulis) sebaiknya kita beri dia pinjaman jangan mengacuhkannya");

		soalId = insertSoalSekolah(assets + "7.png", "Apabila mendapat tugas atau pr sebaiknya....");
		jawaban = new String[]{"Dibiarkan saja","Dikerjakan", "Disimpan", "Dibuang"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Dikerjakan", "jika kita mendapat tugas sebaiknya kita kerjakan, bisa dengan ibu ayah kaka nene kake, alangkah lebih baiknya lagi jika kita mengerjakannya dengan sendiri");

		soalId = insertSoalSekolah(assets + "8.png", "Jika kita tidak mengerti dalam belajar kita harus....");
		jawaban = new String[]{"Diam","Menangis", "Bertanya", "Marah-marah"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Bertanya", "saat kita tidak mengerti saat buguru/paguru sedang menerangkan sebaiknya kita langsung bertanya kepada mereka");

		soalId = insertSoalSekolah(assets + "9.png", "Apabila ada teman terjatuh maka kita sebaiknya....");
		jawaban = new String[]{"Membiarkannya","Menolongnya", "Menertawakannya", "Mengejeknya"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Menolongnya", "Kita harus menolong saat teman terjatuh, itu adalah contoh berkelakuan baik");

		soalId = insertSoalSekolah(assets + "10.png", "Pekerjaan seorang pelajar adalah....");
		jawaban = new String[]{"Mencari nafkah","Bermain", "Belajar", "Mencuri"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Belajar", "Sebagai seorang pelajar sebaiknya kita fokus belajar, karena tugas mencari nafkah itu adalah tugas untuk orang tua, dan mencuri merupakan tindakan tidak terpuji");

		soalId = insertSoalSekolah(assets + "11.png", "Berlatih pramuka disekolah dapat mempererat....");
		jawaban = new String[]{"Kesamaan hak","Persaudaraan", "Kehidupan", "Perceraian"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Persaudaraan", "contoh kegiatan disekolah yang mempererar persaudaraan merupakan kegiatan pramuka, karena kita dilatih kebersamaan");

		soalId = insertSoalSekolah(assets + "12.png", "Peraturan disekolah harus ditaati agar tercipta....");
		jawaban = new String[]{"Kekacauan","Keindahan", "Ketertiban", "Keseruan"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Ketertiban", "Fungsi dari dibuatnya peraturan untuk ketertiban, agar suasan sekolah aman, tentram, nyaman.");

		soalId = insertSoalSekolah(assets + "13.png", "Setiap prestasi yang diperoleh harus....");
		jawaban = new String[]{"Dihormati","Dibanggakan", "Disyukuri", "Dipamerkan"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Disyukuri", "Saat kita memiliki kelebihan lalu kita berprestasi seaiknya kita harus bersyukur dan terus berprestasi lagi");

		soalId = insertSoalSekolah(assets + "14.png", "Contoh perilaku percaya diri dalam melaksanankan tugas yang diberikan guru adalah....");
		jawaban = new String[]{"Menuruti kata-kata teman","Menyontek kepada teman", "Bekerja sesuai kemampuan", "Mencuri"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Bekerja sesuai kemampuan", "contoh dalam perilaku percaya diri yaitu bekerja sesuai dengan kemampuan, mencontek dan mencuri merupakan sikap yang tidak terpuji");

		soalId = insertSoalSekolah(assets + "15.png", "Mengikuti upacara bendera di sekolah dengan khidmat merupakan contoh bentuk sikap....");
		jawaban = new String[]{"Tidak terpuji","Terpuji", "Dibanggakan", "Disyukuri"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Terpuji", "Saat upacara bendera dengan khidmat merupakan contoh terpuji, mengikuti upacara juga menunjukkan bahwa kita menghargai dan mengenang para pahlawan");
		
	}
	
	private void initSoalBudaya(){
		long soalId;
		String[] jawaban;
		int[] status;
		
		String assets = "soal/budaya/";
		
		soalId = insertSoalBudaya(assets + "budaya_pencak_silat.png", "seni bela diri asli indonesia adalah...");
		jawaban = new String[]{"Karate","Taekwondo","Pencak Silat","Judo"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Pencak silat", "Pencak silat merupakan warisan budaya bangsa Indonesia yang sudah tumbuh dan berkembang ke mancanegara. Walau sejarah tidak bisa menun­jukkan secara pasti kapan lahirnya pencak silat, namun pencak silat sudah lahir di bumi pertiwi sejak peradaban manusia. Sejak jaman pra sejarah sudah lahir  ilmu beladiri yang sederhana guna mempertahankan hidup dari ganasnya alam."
							  +"\n\nPada jaman kerajaan-kerajaan beladiri berkembang sebagai alat berkuasa, baik mempertahankan kerajaannya maupun untuk menyerang lawan. Tahun 1019–1041 istilah pencak silat mulai muncul sejak kerajaan Kahuripan dengan nama “Eh Hok Hik”. Pada jaman penjajahan peran pencak silat sangat besar dalam membantu pertahanan negara untuk mengusir penjajah.");

		soalId = insertSoalBudaya(assets + "budaya_rumah_gadang.png", "Rumah apakah ini");
		jawaban = new String[]{"Rumah Gadang","Rumah Panggung","Rumah Honai","Tongkonan"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Rumah Gadang", "Rumah adat Sumatra Barat  disebut Rumah Gadang . Rumah Gadang  memiliki tiang yang tidak tegak lurus atau horizontal tapi punya kemiringan. Kenapa? Karena dulu, masyarakat di sana banyak yang datang dari laut, sehingga mereka hanya tahu cara membuat kapal dan tak tahu cara membuat rumah."
							  +"Rumah ini memiliki keunikan dalam bentuk arsitekturnya dengan atap yang menyerupai tanduk kerbau dibuat dari bahan ijuk. Di halaman depan Rumah Gadang biasanya selalu terdapat dua buah bangunan rangkiang , digunakan untuk menyimpan padi."
							  +"Rumah Gadang disebut juga sebagai Rumah Baanjuang . Sebab di sayap bangunan sebelah kanan dan kirinya ruang anjuang  (anjung). Ruang ini digunakan oleh masyarakat setempat sebagai tempat pengantin bersanding atau tempat penobatan kepala adat."
							  +"Sebagai suku bangsa yang menganut falsafah alam, garis dan bentuk rumah adatnya kelihatan serasi dengan bentuk alam Bukit Barisan. Coba deh perhatikan bagian puncaknya yang bergaris lengkung meninggi pada bagian tengah. Lalu, garis lerengnya melengkung dan mengembang ke bawah dengan bentuk persegi tiga."
							  +"\n\nhttp://www.kidnesia.com/Kidnesia2014/Indonesiaku/Teropong-Daerah/Sumatera-Barat/Seni-Budaya/Rumah-Gadang-Rumah-Adat-Sumatera-Barat");

		soalId = insertSoalBudaya(assets + "budaya_batik.png", "Kain khas indonesia yang diakui oleh UNESCO sebagai warisan budaya dunia yang biasanya memiliki motif daun atau bunga");
		jawaban = new String[]{"ulos","Batik","Kebaya","Kain tenun"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Batik", "Batik adalah kain bergambar yang pembuatannya secara khusus dengan menuliskan atau menerakan malam pada kain itu, kemudian pengolahannya diproses dengan cara tertentu yang memiliki kekhasan. Batik Indonesia, sebagai keseluruhan teknik, teknologi, serta pengembangan motif dan budaya yang terkait, oleh UNESCO telah ditetapkan sebagai Warisan Kemanusiaan untuk Budaya Lisan dan Nonbendawi (Masterpieces of the Oral and Intangible Heritage of Humanity) sejak 2 Oktober 2009.[1]"
							  +"\n\nhttp://id.wikipedia.org/wiki/Batik");

		soalId = insertSoalBudaya(assets + "budaya_keris.png", "Senjata khas Indonesia yang juga diakui oleh UNESCO");
		jawaban = new String[]{"Kapak","Palu","Katana","Keris"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Keris", "Keris adalah senjata tikam golongan belati (berujung runcing dan tajam pada kedua sisinya) dengan banyak fungsi budaya yang dikenal di kawasan Nusantara bagian barat dan tengah. Bentuknya khas dan mudah dibedakan dari senjata tajam lainnya karena tidak simetris di bagian pangkal yang melebar, seringkali bilahnya berkelok-kelok, dan banyak di antaranya memiliki pamor (damascene), yaitu terlihat serat-serat lapisan logam cerah pada helai bilah. Jenis senjata tikam yang memiliki kemiripan dengan keris adalah badik. Senjata tikam lain asli Nusantara adalah kerambit.\n"
						   +"\nPada masa lalu keris berfungsi sebagai senjata dalam duel/peperangan,[1] sekaligus sebagai benda pelengkap sesajian. Pada penggunaan masa kini, keris lebih merupakan benda aksesori (ageman) dalam berbusana, memiliki sejumlah simbol budaya, atau menjadi benda koleksi yang dinilai dari segi estetikanya."
						   +"\nPenggunaan keris tersebar pada masyarakat penghuni wilayah yang pernah terpengaruh oleh Majapahit, seperti Jawa, Madura, Nusa Tenggara, Sumatera, pesisir Kalimantan, sebagian Sulawesi, Semenanjung Malaya, Thailand Selatan, dan Filipina Selatan (Mindanao). Keris Mindanao dikenal sebagai kalis. Keris di setiap daerah memiliki kekhasan sendiri-sendiri dalam penampilan, fungsi, teknik garapan, serta peristilahan."
						   +"\nKeris Indonesia telah terdaftar di UNESCO sebagai Warisan Budaya Dunia Non-Bendawi Manusia sejak 2005."
						   +"\n\nhttp://id.wikipedia.org/wiki/Keris");

		soalId = insertSoalBudaya(assets + "budaya_reog_ponorogo.png", "apakah nama dari kesenian diatas");
		jawaban = new String[]{"Reog Ponorogo","Ondel - ondel","Ogoh - ogoh","Wayang golek"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Reog Ponorogo", "Reog adalah salah satu kesenian budaya yang berasal dari Jawa Timur bagian barat-laut dan Ponorogo dianggap sebagai kota asal Reog yang sebenarnya. Gerbang kota Ponorogo dihiasi oleh sosok warok dan gemblak, dua sosok yang ikut tampil pada saat reog dipertunjukkan. Reog adalah salah satu budaya daerah di Indonesia yang masih sangat kental dengan hal-hal yang berbau mistik dan ilmu kebatinan yang kuat."
							   +"\n\nTokoh dalam Reog : "
							   +"\n1. Jathil, prajurit berkuda dan merupakan salah satu tokoh dalam seni Reog."
							   +"\n2. Warok, yang berasal dari kata wewarah adalah orang yang mempunyai tekad suci, memberikan tuntunan dan perlindungan tanpa pamrih."
							   +"\n3. Barongan (Dadak merak) merupakan peralatan tari yang paling dominan dalam kesenian Reog Ponorogo. Bagian-bagiannya antara lain; Kepala Harimau (caplokan), terbuat dari kerangka kayu, bambu, rotan ditutup dengan kulit Harimau Gembong."
							   +"\n4. Klono Sewandono atau Raja Kelono adalah seorang raja sakti mandraguna yang memiliki pusaka andalan berupa Cemeti yang sangat ampuh dengan sebutan Kyai Pecut Samandiman kemana saja pergi sang Raja yang tampan dan masih muda ini selalu membawa pusaka tersebut."
							   +"\n5. Bujang Ganong (Ganongan) atau Patih Pujangga Anom adalah salah satu tokoh yang enerjik, kocak sekaligus mempunyai keahlian dalam seni bela diri sehingga disetiap penampilannya senantiasa di tunggu - tunggu oleh penonton khususnya anak-anak. Bujang Ganong menggambarkan sosok seorang Patih Muda yang cekatan, berkemauan keras, cerdik, jenaka dan sakti."
							   +"\n\nhttp://id.wikipedia.org/wiki/Reog_%28Ponorogo%29");

		soalId = insertSoalBudaya(assets + "budaya_pramuka.png", "Rasa sayange... rasa sayang sayange..."
									+ "\nKulihat dari jauh rasa sayang sayange"
									+ "\nRasa sayange... rasa sayang sayange..."
									+ "\nKulihat dari jauh rasa sayang sayange"
									+ "\n\nApakah judul lagu dari potongan lagu diatas?");
		jawaban = new String[]{"Tokecang","Rasa sayange","Indonesia raya","Ampar - ampar pisang"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Lirik lagu Rasa Sayange", "Rasa sayange... rasa sayang sayange..."
							  +"\nKulihat dari jauh rasa sayang sayange"
							  +"\nRasa sayange... rasa sayang sayange..."
							  +"\nKulihat dari jauh rasa sayang sayange"

							  +"\n\nJalan jalan kekota paris"
							  +"\nLihat gedung berbaris baris"
							  +"\nAnak manis jangan menangis"
							  +"\nKalau menangis malah meringis"

							  +"\n\nRasa sayange... rasa sayang sayange..."
							  +"\nKulihat dari jauh rasa sayang sayange"
							  +"\nRasa sayange... rasa sayang sayange..."
							  +"\nKulihat dari jauh rasa sayang sayange"

							  +"\n\nSana belang disini belang"
							  +"\nAnak kucingku yang manis"
							  +"\nSana senang disini senang"
							  +"\nAyo kita menyanyi lagi"

							  +"\n\nRasa sayange... rasa sayang sayange..."
							  +"\nKulihat dari jauh rasa sayang sayange"
							  +"\nRasa sayange... rasa sayang sayange..."
							  +"\nKulihat dari jauh rasa sayang sayange");

		soalId = insertSoalBudaya(assets + "budaya_pramuka.png", "Ampar ampar pisang"
									   +"\nPisangku balum masak"
									   +"\nMasak bigi di hurung ... "
									   +"\n\napakah lanjutan dari lirik lagu di atas?");
		jawaban = new String[]{"Buru - buru","Buri - buri","Bara - bara","Bari - bari"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Lirik lagu Ampar - ampar pisang", "Ampar ampar pisang"
									     +"\nPisangku balum masak"
									     +"\nMasak bigi di hurung bari-bari"
									     +"\nMasak bigi di hurung bari-bari"

									+"\n\nManggalepak manggalepok"
									+"\nPatah kayu bengkok"
									+"\nBengkok dimakan api"
									+"\napinya cang curupan"

									+"\n\nNang mana batis kutung"
									+"\nDikitipi dawang (2x)"


									+"\n\nAmpar ampar pisang"
									+"\nPisangku balum masak"
									+"\nMasak bigi di hurung bari-bari"
									+"\nMasak bigi di hurung bari-bari");

		soalId = insertSoalBudaya(assets + "budaya_tari_saman.png", "Dari manakah asal tari Saman");
		jawaban = new String[]{"Aceh","Maluku","Papua","Makassar"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Tari Saman", "Tari Saman adalah sebuah tarian suku Gayo (Gayo Lues) yang biasa ditampilkan untuk merayakan peristiwa-peristiwa penting dalam adat. Syair dalam tarian Saman mempergunakan bahasa Arab dan bahasa Gayo. Selain itu biasanya tarian ini juga ditampilkan untuk merayakan kelahiran Nabi Muhammad SAW. Dalam beberapa literatur menyebutkan tari Saman di Aceh didirikan dan dikembangkan oleh Syekh Saman, seorang ulama yang berasal dari Gayo di Aceh Tenggara. Tari Saman ditetapkan UNESCO sebagai Daftar Representatif Budaya Takbenda Warisan Manusia dalam Sidang ke-6 Komite Antar-Pemerintah untuk Pelindungan Warisan Budaya Tak benda UNESCO di Bali, 24 November 2011."
							+"\nTari saman merupakan salah satu media untuk pencapaian pesan (dakwah). Tarian ini mencerminkan pendidikan, keagamaan, sopan santun, kepahlawanan, kekompakan dan kebersamaan.Sebelum saman dimulai yaitu sebagai mukaddimah atau pembukaan, tampil seorang tua cerdik pandai atau pemuka adat untuk mewakili masyarakat setempat (keketar) atau nasihat-nasihat yang berguna kepada para pemain dan penonton.");

		soalId = insertSoalBudaya(assets + "budaya_rumah_honai.png", "Apakah nama rumah khas Papua?");
		jawaban = new String[]{"Rumah Gadang","Rumah Panggung","Rumah Honai","Judo"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Rumah Honai", "Rumah Honai terbuat dari kayu dengan atap berbentuk kerucut yang terbuat dari jerami atau ilalang. Honai sengaja dibangun sempit atau kecil dan tidak berjendela yang bertujuan untuk menahan hawa dingin pegunungan Papua. Honai biasanya dibangun setinggi 2,5 meter dan pada bagian tengah rumah disiapkan tempat untuk membuat api unggun untuk menghangatkan diri. Rumah Honai terbagi dalam tiga tipe, yaitu untuk kaum laki-laki (disebut Honai), wanita (disebut Ebei), dan kandang babi (disebut Wamai)."
							 +"\n\nRumah Honai biasa ditinggali oleh 5 hingga 10 orang. Rumah Honai dalam satu bangunan digunakan untuk tempat beristirahat (tidur), bangunan lainnya untuk tempat makan bersama, dan bangunan ketiga untuk kandang ternak.[1] Rumah Honai pada umumnya terbagi menjadi dua tingkat. Lantai dasar dan lantai satu dihubungkan dengan tangga dari bambu. Para pria tidur pada lantai dasar secara melingkar, sementara para wanita tidur di lantai satu.");

		soalId = insertSoalBudaya(assets + "budaya_kain_ulos.png", "Apa ya nama kain yang turun temurun dikembangkan oleh maysarakat Batak, Sumatera utara.");
		jawaban = new String[]{"ulos","Batik","Kebaya","Kain tenun"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Kain Ulos", "Ulos atau sering juga disebut kain ulos adalah salah satu busana khas Indonesia. Ulos secara turun temurun dikembangkan oleh masyarakat Batak, Sumatera utara. Dari bahasa asalnya, ulos berarti kain. Cara membuat ulos serupa dengan cara membuat songket khas Palembang, yaitu menggunakan alat tenun bukan mesin."
						       +"\n\nWarna dominan pada ulos adalah merah, hitam, dan putih yang dihiasi oleh ragam tenunan dari benang emas atau perak. Mulanya ulos dikenakan di dalam bentuk selendang atau sarung saja, kerap digunakan pada perhelatan resmi atau upacara adat Batak, namun kini banyak dijumpai di dalam bentuk produk sovenir, sarung bantal, ikat pinggang, tas, pakaian, alas meja, dasi, dompet, dan gorden."
						       +"\n\nUlos juga kadang-kadang diberikan kepada sang ibu yang sedang mengandung supaya mempermudah lahirnya sang bayi ke dunia dan untuk melindungi ibu dari segala mara bahaya yang mengancam saat proses persalinan.");

		soalId = insertSoalBudaya(assets + "budaya_tari_kecak.png", "Tarian ini sangat terkenal hingga ke mancanegara dan berasal dari pulau dewata Bali");
		jawaban = new String[]{"Tari jaipong","Tari Selamat Datang","Tari kecak","Tari"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Tari Kecak", "Tari Kecak ialah pertunjukan seni khas Bali yang diciptakan pada tahun 1930-an dan dimainkan terutama oleh laki-laki. Tarian ini dipertunjukkan oleh banyak (puluhan atau lebih) penari laki-laki yang duduk berbaris melingkar dan dengan irama tertentu menyerukan “cak” dan mengangkat kedua lengan, menggambarkan kisah Ramayana saat barisan kera membantu Rama melawan Rahwana. Namun demikian, Kecak berasal dari ritual Sanghyang, yaitu tradisi tarian yang penarinya akan berada pada kondisi tidak sadar, melakukan komunikasi dengan Tuhan atau roh para leluhur dan kemudian menyampaikan harapan-harapannya kepada masyarakat."
							+"\n\nPara penari yang duduk melingkar tersebut mengenakan kain kotak-kotak seperti papan catur melingkari pinggang mereka. Selain para penari itu, ada pula para penari lain yang memerankan tokoh-tokoh Ramayana seperti Rhama, Shinta, Rahwana, Hanoman, dan Sugriwa.");

		soalId = insertSoalBudaya(assets + "budaya_hanoman.png", "Ia adalah salah satu tokoh yang muncul dalam tari kecak. Siapakah dia?");
		jawaban = new String[]{"Si Unyil","Hanoman","si gale-gale","komodo"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Hanoman", "Diceritakan pula ketika Raja Rahwana menculik Dewi Sita, didalam perjalanannya dilihat oleh Sang Jatayu, seekor burung Garuda yang merupakan sahabat dari Sang Rama Dewa. Ketika Jatayu mengetahui bahwa wanita yang sedang diculik oleh Rahwana adalah permaisuri dari sahabatny yaitu Sang Rama Dewa, maka burung Jatayu pun berusaha menyelamatkan sang permaisuri. Namun karena kesaktian Rahwana melebihi Jatayu, maka Jatayu dapat dikalahkan."
						     +"\n\nPada bagian selanjutnya diceritakan kembali perjalanan Sang Rama Dewa yang hanya ditemani oleh adiknya Laksamana kemudian bertemu dengan Sang hanoman, seorang panglima perang pasukan kera yang merupakan keponakan dari seorang raja kera bernama Sugriwa. Karena pernah merasa berhutang budi kepada sang Rama Dewa, pasukan kera yang dipimpin oleh panglima perang Hanoman dan Raja Sugriwa bersedia membantu Sang Rama Dewa untuk merebut kembali permaisurinya. Karena kesaktiannya kera putih Hanoman dapat menyusup kedalam istana Raja Rahwana dan kemudian menemui Dewi Sita. Bagimana kemudian dengan kesaktiannya, Kera Putih Hanoman kemudian membakar istana Raja Rahwana yang didalam pementasan kecak diilustrasikan dengan fire dance. Dimana Hanoman kemudian ditangkap dan dibakar oleh para prajurit Rahwana yang semuanya adalah para raksasa. Perjuangan Hanoman dalam membantu Rama Dewa untuk mendapatkan permaisurinya kembali, menjadi sebuah cerita dan tarian yang sangat menarik untuk anda nikmati."				     
						     +"\n\nDidalam pementasan juga akan muncul beberapa karakter lain yang menarik untuk anda amati lebih dalam karena dibawakan oleh pemuda-pemudi masyarakat Pecatu yang begitu lemah gemulai dalam membawakan karakternya masing-masing.");

		soalId = insertSoalBudaya(assets + "budaya_dalang.png", "Orang yang memainkan sebuah boneka yang terbuat dari kayu atau kulit");
		jawaban = new String[]{"Pembalap","Presenter","Wayang","Dalang"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Dalang", "Dalang dalam dunia pewayangan diartikan sebagai seseorang yang mempunyai keahlian khusus memainkan boneka wayang (ndalang). Keahlian ini biasanya diperoleh dari bakat turun - temurun dari leluhurnya. Seorang anak dalang akan bisa mendalang tanpa belajar secara formal. Ia akan mengikuti ayahnya selagi mendalang dengan membawakan peralatan, menata panggung, mengatur wayang (nyimping), menjadi pengrawit, atau duduk di belakang ayahnya untuk membantu mempersiapkan wayang yang akan dimainkan.");

		soalId = insertSoalBudaya(assets + "budaya_wayang.png", "Benda ini dimainkan dengan sebuah alur cerita oleh seorang dalang");
		jawaban = new String[]{"Pensil","Wayang","Gamelan","Dalang"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Wayang", "Wayang adalah seni pertunjukkan asli Indonesia yang berkembang pesat di Pulau Jawa dan Bali. Pertunjukan ini juga populer di beberapa daerah seperti Sumatera dan Semenanjung Malaya juga memiliki beberapa budaya wayang yang terpengaruh oleh kebudayaan Jawa dan Hindu."
						    +"\n\nUNESCO, lembaga yang membawahi kebudayaan dari PBB, pada 7 November 2003 menetapkan wayang sebagai pertunjukkan bayangan boneka tersohor dari Indonesia, sebuah warisan mahakarya dunia yang tak ternilai dalam seni bertutur (Masterpiece of Oral and Intangible Heritage of Humanity).");

		soalId = insertSoalBudaya(assets + "budaya_gamelan.png", "Siapakah nama tokoh diatas?");
		jawaban = new String[]{"Drum","Gamelan","Gitar","Seruling"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Pencak silat", "Gamelan adalah ensembel musik yang biasanya menonjolkan metalofon, gambang, gendang, dan gong. Istilah gamelan merujuk pada instrumennya / alatnya, yang mana merupakan satu kesatuan utuh yang diwujudkan dan dibunyikan bersama. Kata Gamelan sendiri berasal dari bahasa Jawa gamel yang berarti memukul / menabuh, diikuti akhiran an yang menjadikannya kata benda. Orkes gamelan kebanyakan terdapat di pulau Jawa, Madura, Bali, dan Lombok di Indonesia dalam berbagai jenis ukuran dan bentuk ensembel. Di Bali dan Lombok saat ini, dan di Jawa lewat abad ke-18, istilah gong lebih dianggap sinonim dengan gamelan.");
	}
	
	private void initSoalMataUang(){
		long soalId;
		String[] jawaban;
		int[] status;
		
		String assets = "soal/mata_uang/";
		
		soalId = insertSoalMataUang(assets + "bendera_indonesia.png", "Mata uang Indonesia");
		jawaban = new String[]{"DOLLAR","Rupiah","Ringgit","Yen"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang rupiah", "Mata uang rupiah adalah mata uang Indonesia ( kodenya adalah IDR ). Nama ini diambil dari mata uang India, Rupee. Sebelumnya di daerah yang disebut Indonesia sekarang menggunakan gulden Belanda dari tahun 1610 sampai tahun 1817, ketika gulden Hindia Belanda diperkenalkan."
		+"\n\nNama rupiah pertama kali digunakan secara resmi dengan dikeluarkannya mata uang rupiah jaman pendudukan Dai Nippon pada Perang Dunia II. Setelah perang selesai, Bank Jawa, pelopor Bank Indonesia, mengeluarkan Rupiah. Sedangkan Tentara Sekutu mengeluarkan Gulden Nica."
		+"\n\nSementara itu di daerah-daerah lain di di daerah yang sekarang disebut Indonesia, banyak beredar uang yang bertalian dengan aktivitas gerilya."
		+"\n\nPada tanggal 2 November 1949 rupiah ditetapkan sebagai mata uang nasional. Di daerah kepulauan Riau dan Papua, kala itu masih digunakan mata uang lain. Baru pada tahun 1964 dan 1971 rupiah digunakan di sana."
		+"\n\nDi daerah Timor Timur, saat masih bergabung dengan Republik Indonesia, rupiah digunakan dari tahun 1976 – 2001.");

		soalId = insertSoalMataUang(assets + "bendera_malaysia.png", "Mata uang Malaysia");
		jawaban = new String[]{"Dolar","Rupiah","Ringgit","Yen"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Ringgit","Mata uang ringgit adalah mata uang MALAYSIA ini memiliki pecahan uang receh dan pecahan uang kertas. Pecahan uang recehnya terdiri dari 1 sen, 5 sen, 10 sen, 20 sen, dan 50 sen. Sedangkan pecahan uang kertasnya terdiri dari RM2, RM5, RM10, dan RM20."
		+"\n\nAwalnya istilah Ringgit berasal diri sisi bergerigi pada perak dolar Spanyol yang pada saat itu dibawa oleh orang – orang Portugis pada sekitar abad ke 16 sampai abad ke 17 banyak digunakan oleh masyarakat disana. Selain itu, Dolar Brunei, dan Dolar Singapura dulu juga disebut sebagai ringgit. Istilah Ringgit sebagai mata uang resmi Malaysia mulai diberlakukan secara resmi sejak bulan Agustus 1975. Sebelumnya nama mata uang tersebut dikenal dengan dollar dalam bahasa Inggris dan dalam bahasa Melayunya adalah Ringgit. Pada saat itu, simbolisasi $ masih umum digunakan hingga pada akhirnya diubah menjari RM yang merupakan kependekan dari Ringgit Malaysia mulai dari tahun 90an."
		+"\n\nPada tahun 1997 sampai tahun 1998, terjadi krisis ekonomi dunia. Pasca kejadian tersebut uang resmi Ringgit Malaysia tersebut tetap dipatok dalam nilai yang tidak berubah yaitu RM3.80 tiap satu dollar. Bank Nasional Malaysia pada bulan Juli 2005 memutuskan untuk tetap mengembangkan mata uang Ringgit Malaysia untuk beberapa mata uang besar. Hal tersebut dilakukan pada hari yang sama dengan terjadinya revaluasi mata uang Yuan."
		+"\n\nWalaupun Ringgit MALAYSIA adalah mata uang resmi di MALAYSIA, ternyata mata uang dari negeri tetangga ini juga pernah digunakan oleh masyarakat Indonesia yaitu sekitar tahun 70an. Hal ini mungkin belum begitu diketahui oleh masyarakat Indonesia saat ini. Saat itu, pecahan 1 Ringit Malaysia bernilai dua setengah rupiah. Selain itu, Ringgit juga digunakan sebagai satuan keuangan pada masa Kesultanan Deli dengan memiliki nilai 2 kupang. Namun, saat ini uang tersebut tentu sudah tidak digunakan lagi di Indonesia karena Indonesia telah memiliki mata uang resmi sendiri yaitu Rupiah.");

		soalId = insertSoalMataUang(assets + "bendera_Singapura.png", "Mata uang Singapura");
		jawaban = new String[]{"Dolar","Rupiah","Ringgit","Yen"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Dolar","Mata uang Singapura adalah dolar Singapura yang ditandai dengan simbol S$ atau singkatan ISO SGD. Bank sentralnya adalah Otoritas Moneter Singapura (Monetary Authority of Singapore) yang bertugas mengeluarkan mata uang.");

		soalId = insertSoalMataUang(assets + "bendera_Spanyol.png", "Mata uang Spanyol");
		jawaban = new String[]{"Peseta","Pound sterling","Rupee","Yuan"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Peseta","Mata uang peseta adalah mata uang Spanyol sejak tahun 1869 hingga 2002 ketika digantikan oleh euro. Seiring dengan franc Perancis, peseta juga merupakan mata uang de facto yang digunakan di negara Andorra (yang tidak memiliki mata uang nasional dengan alat pembayaran yang sah.");

		soalId = insertSoalMataUang(assets + "bendera_Inggris.png", "Mata uang Inggris");
		jawaban = new String[]{"Peseta","Pound sterling","Rupee","Yuan"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Pound sterling","Mata uang inggris adalah Pound sterling yang merupakan mata uang tertua di dunia yang telah ada dan tidak berubah sejak 600 tahun terakhir. Kata \"pound\" dan \"sterling\" sendiri merujuk pada logam perak seberat satu pound yang digunakan sebagai nilai pembanding mata uang tersebut. Pada masa modern, nilai Pound Sterling tidak lagi dikaitkan dengan nilai perak dalam berat tertentu - melainkan ditentukan oleh mekanisme pasar berdasarkan penawaran dan permintaan. Pihak yang paling bertanggung jawab atas sirkulasi dan nilai tukar Pound Sterling adalah Bank of England selaku bank sentral.");

		soalId = insertSoalMataUang(assets + "bendera_India.png", "Mata uang India");
		jawaban = new String[]{"Peseta","Pound sterling","Rupee","Yuan"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Rupee","Mata uang rupee adalah mata uang resmi negara India yang setiap satuannya dibagi menjadi 100 paisa. Simbol yang paling umum digunakan untuk rupee adalah Rs. Mata uang ini digunakan pertama kali sejak 1862."
		+"Rupee berasal dari bahasa Sanskerta rup atau rupa yang berarti perak.");

		soalId = insertSoalMataUang(assets + "bendera_China.png", "Mata uang China");
		jawaban = new String[]{"Peseta","Pound sterling","Rupee","Yuan"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Yuan","Yuan (dikenal dengan nama Renminbi (RMB) di RRT) adalah mata uang Republik Rakyat Tiongkok. Mata uang ini dicetak dan diatur penggunaannya oleh Bank Rakyat Cina. Renminbi pernah dipatok pada nilai 8,28 terhadap dolar AS selama 11 tahun hingga 21 Juli 2005. Hal ini menimbulkan kecaman dari Amerika Serikat yang menganggap hal ini dilakukan Tiongkok untuk menjaga agar barang-barang produksi negara tersebut tetap murah di pasar internasional.");

		soalId = insertSoalMataUang(assets + "bendera_Jepang.png", "Mata uang Jepang");
		jawaban = new String[]{"Franc","Escudo","Yen","Won"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Yen","Yen adalah mata uang Jepang.Pemerintah Jepang menetapkan mata uang Yen sejak 27 Juni 1871 berdasarkan Shinka jorei (peraturan pemerintahan tentang mata uang baru.");

		soalId = insertSoalMataUang(assets + "bendera_Prancis.png", "Mata uang Francins");
		jawaban = new String[]{"Euro","Escudo","Yen","Won"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Euro","Franc merupakan nama beberapa unit keuangan. Franc yang paling dikenali adalah Franc Swiss yang merupakan salah satu mata uang yang terpenting di dunia. Franc juga merupakan nama mata uang Perancis terdahulu, yaitu Franc Perancis, sebelum negara tersebut menerima pakai euro sebagai mata uang. Nama franc dikatakan berasal dari tulisan bahasa Latin francorum rex (Raja Orang Frank) pada koin Perancis awal, atau perkataan bahasa Perancis franc, yang bermakna \"bebas\" atau \"jujur.\"");

		soalId = insertSoalMataUang(assets + "bendera_Korea_Selatan.png", "Mata uang Korea Selatan");
		jawaban = new String[]{"Euro","Escudo","Yen","Won"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang won","Won adalah mata uang di Korea Utara dan Korea Selatan. Won dibagi menjadi 100 chon  di . Won diperkenalkan sebagai mata uang Korea pada tahun 1902 menggantikan yen. Pada tahun 1910, seiring dengan pendudukan Jepang terhadap Korea,won digantikan oleh yen.");

		soalId = insertSoalMataUang(assets + "bendera_Portugal.png", "Mata uang Portugal");
		jawaban = new String[]{"Euro","Escudo","Yen","Won"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Escudo","Escudo adalah mata uang Portugal, yang dipakai sampai tahun 1999. Semenjak tahun 1999, mata uang yang dipakai adalah Euro. Satu escudo dibagi menjadi 100 centavos. Selain pernah menjadi mata uang Portugal, escudo masih merupakan mata uang Tanjung Verde.");

		soalId = insertSoalMataUang(assets + "bendera_Thailand.png", "Mata uang thailand");
		jawaban = new String[]{"Dolar","Dong","Peso","Bath"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Bath","Baht adalah mata uang resmi Thailand. Penerbitan mata uang ini merupakan tanggung jawab Bank of Thailand. Satu baht dibagi menjadi 100 satang.");


		soalId = insertSoalMataUang(assets + "bendera_Vietnam.png", "Mata uang vietnam");
		jawaban = new String[]{"Dolar","Dong","Peso","Bath"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Dong","Mata uang Dong yang pertama kali diperkenalkan dan diedarkan kepada publik di Vietnam terjadi pada tahun 1946. Kemunculan mata uang Dong ini sekaligus menggantikan mata uang yang sebelumnya berlaku disana yaitu Piastre at par.");

		soalId = insertSoalMataUang(assets + "bendera_Argentina.png", "Mata uang Argentina");
		jawaban = new String[]{"Dolar","Dong","Peso","Bath"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Peso","Peso Argentina merupakan sebuah mata uang resmi Argentina sejak tahun 1992 menggantikan mata uang Austral Argentina. Mata uang ini setiap satu-satunya dibagi menjadi 100 centavo. Setiap mata uangnya terbagi menjadi 2, 5, 10, 20, 50, 100 peso.");

		soalId = insertSoalMataUang(assets + "bendera_Australia.png", "Mata uang Australia");
		jawaban = new String[]{"Dolar","Dong","Peso","Bath"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Mata uang Dolar","Dolar Australia, AUD atau A$, adalah mata uang resmi Australia, termasuk Pulau Natal, Kepulauan Cocos, Pulau Heard dan Kepulauan McDonald dan Pulau Norfolk, serta negara-negara-pulau merdeka Kiribati, Nauru dan Tuvalu. Mata uang ini dicetak dan diatur penggunaannya oleh Reserve Bank of Australia, dan diperkenalkan pada 14 Februari 1966 untuk mengganti Pound Australia, ketika negara ini mendesimalkan mata uangnya.");

	}
	
	private void initSoalFauna(){
		long soalId;
		String[] jawaban;
		int[] status;
		
		String assets = "soal/fauna/";
		
		soalId = insertSoalFauna(assets + "CENDRAWASI.png", "Apa nama burung pada gambar tersebut?");
		jawaban = new String[]{"Kakatua","Cendrawasi","Merak","Elang"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Cendrawasi","gambar tersebut menunjukkan bahwa burung tersebut adalah burung cendrawasi)");

		soalId = insertSoalFauna(assets + "CENDRAWASI.png", "Berasal dari manakah burung cendrawasi?");
		jawaban = new String[]{"Indonesia Timur","Jakarta","Sumatera","Papua"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Indonesia Timur","burung cendrawasi ditemukan di Indonesia Timur, pulau-pulau selat Torres, Papua Nugini, dan Australia Timur");

		soalId = insertSoalFauna(assets + "CENDRAWASI.png", "Apa nama ordo dari burung cendrawasi?");
		jawaban = new String[]{"Indoe","Passeriformes","Raflesia","Anggrek"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Passeriformes","Passeriformes merupakan ordo dari burung cendrawasi");

		soalId = insertSoalFauna(assets + "MERAK.png", "Apa nama burung yang ada digambar tersebut?");
		jawaban = new String[]{"Bangau","Cendrawasi","Kakatua","Merak"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Merak","nama burung yang ditujukkan dalam gambar tersebut adalah burung merak");

		soalId = insertSoalFauna(assets + "MERAK.png", ".... merupakan cara untukmenarik perhatiannya terhadap merak betina.");
		jawaban = new String[]{"Kaki","Badan","Tangan","Buku ekor"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "bulu ekor","bulu ekor yang di kembangkan dapat menarik perhatian kepada merak betina");

		soalId = insertSoalFauna(assets + "KOMODO.png", "apa nama hewan yang ditunjukkan di gambar tersebut?");
		jawaban = new String[]{"Ayam","Kadal","Komodo","Ular"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Komodo","yang ditunjukkan dalam gambar tersebut adalah komodo");

		soalId = insertSoalFauna(assets + "KOMODO.png", "dimanakah hewan tersebut ditemukan?");
		jawaban = new String[]{"Pulau komodo","Pantai","Sungai","Jakarta"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Pulau komodo","komodo ditemukan di Pulau Komodo, RInca, Flores, Gili Motang, dan Gili Damasi di Nusa Tenggara");

		soalId = insertSoalFauna(assets + "KOMODO.png", "apa nama lain komodo?");
		jawaban = new String[]{"Biawak","Kadal","Cicak","Ular"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Biawak","Biawak merupakan nama lain dari Komodo");

		soalId = insertSoalFauna(assets + "BADAK.png", "Apa nama hewan yang ada digambar?");
		jawaban = new String[]{"Gajah","Zebra","Jerapah","Badak"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Badak","gambar tersebut merupakan badak");

		soalId = insertSoalFauna(assets + "BADAK.png", "Berasal darimanakah badak?");
		jawaban = new String[]{"Afrika","Eropa","Arab","Bogor"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Afrika","badak berasal dari afrika dan asia");

		soalId = insertSoalFauna(assets + "GAJAH.png", "Apa nama hewan yang ada digambar?");
		jawaban = new String[]{"Kerbau","Sapi","Badak","Gajah"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Gajah","gambar di atas menunjukkan bahwa itu adalah gajah");

		soalId = insertSoalFauna(assets + "GAJAH.png", "Ordo apakah gajah?");
		jawaban = new String[]{"parasitisem","Pachyderm","Omnivora","Herbivora"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Pachydem","Pachydem merupakan ordo dari gajah");

		soalId = insertSoalFauna(assets + "MALEO.png", "Apa nama hewan yang ada digambar?");
		jawaban = new String[]{"Kakatua","Elangi","Maleo","Camar"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Maleo","gambar tersebut menunjukkan bahwa itu adalah burung maleo");

		soalId = insertSoalFauna(assets + "MALEO.png", "Apa nama ilmiah burung maleo?");
		jawaban = new String[]{"Tectona grandis","Armorphophallus titanium","Macrocephalon","Mawar"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Macrocephalon","Macrocephalon merupakan nama lain dari burung Maleo");

		soalId = insertSoalFauna(assets + "MALEO.png", "DImanakan ditemukannya burung maleo?");
		jawaban = new String[]{"Bali","Sulawesi Tengah","Jawa","Kalimantan"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Sulawesi Tengah","burung maleo ditemukanna di Sulawesi Tengah");

	}
	
	private void initSoalFlora(){
		long soalId;
		String[] jawaban;
		int[] status;
		
		String assets = "soal/flora/";
		

		soalId = insertSoalFlora(assets + "BUNGA_BANGKAI.png", "Apa nama lain dari bunga bangkai?");
		jawaban = new String[]{"Raflesia","Armorphophallus titanium","Araceae","Mawar"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Armorphophallus titanium", "Amorphophallus titanium Becc nama lain dari bunga bangkai, bunga bangkai merupakan tumbuhan semacam talas(Araceae)");
		
		soalId = insertSoalFlora(assets + "RAFLESIA.png", "Apa nama bunga yang ada digambar?");
		jawaban = new String[]{"Bangkai","Melati","Raflesia","Anggrek"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Raflesia", "nama bunga ini yaitu bunga Raflesia, bunga Raflesia itu tumbuhan parasit");
		
		soalId = insertSoalFlora(assets + "BUNGA_BANGKAI.png", "Apa nama bunga yang ada digambar?");
		jawaban = new String[]{"Bangkai","Melati","Raflesia","Anggrek"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Bangkai", "bunga ini merupakan bunga bangkai, yaitu bunga yang terbesar di dunia");
		
		soalId = insertSoalFlora(assets + "CENDANA.png", "Apa nama pohon yang ada digambar?");
		jawaban = new String[]{"Cendana","Melati","Raflesia","Anggrek"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Cendana", "nama pohon diata gambar tersebut yaitu cendana");
		
		soalId = insertSoalFlora(assets + "BUNGA_BANGKAI.png", "Berasal dari manakah bunga bangkai?");
		jawaban = new String[]{"Bandung","Jakarta","Sumatera","Papua"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Sumatera", "bunga bangkai berasal dari endemik Sumatera");
		
		soalId = insertSoalFlora(assets + "RAFLESIA.png", "Ditemukan dimakah bunga ini?");
		jawaban = new String[]{"Bandung","Jakarta","Hutan hujan Kalimantan","Papua"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Hutan hujan Kalimantan", "bunga Raflesia ditemukan di hutan hujan Kalimantan dan Sumatera");
		
		soalId = insertSoalFlora(assets + "CENDANA.png", "apa manfaat pohon yang ada digambar?");
		jawaban = new String[]{"Campuran parfum","Makanan","Jamu","Minuman"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Campuran parfum", "manfaat pohon cendana yaitu untuk rempah-rempah, bahan dupa, aromaterapi, campuran parfum, warangka(sangkur keris");
		
		soalId = insertSoalFlora(assets + "DAMAR.png", "Apa nama pohon yang ada digambar?");
		jawaban = new String[]{"Bangkai","Melati","Raflesia","Damar"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Damar", "gambar tersebut merupakan pohon damar");
		
		soalId = insertSoalFlora(assets + "JATI.png", "Apa nama pohon yang ada digambar?");
		jawaban = new String[]{"Bangkai","Melati","Jati","Damar"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Jati", "pohon terssebut merupakan pohon jati");
		
		soalId = insertSoalFlora(assets + "CENDANA.png", "Ditemukan dimana pohon diatas?");
		jawaban = new String[]{"Bandung","Nusa Tenggara Timur","Bali","Bogor"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Cendana", "pohon tersebut pertama ditemukan di Nusa Tenggara Timur, tapi sekarang sudah menyebar ke pulau Jawa dan pulau Nusa Tenggara lainnya");
		
		soalId = insertSoalFlora(assets + "DAMAR.png", "Ditemukan dimana pohon diatas?");
		jawaban = new String[]{"Maluku","Makasar","Bandung","Bogor"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Maluku", "pohon damar ditemukan di maluku dan sulawesi");
		
		soalId = insertSoalFlora(assets + "ULIN.png", "Apa nama pohon yang ada digambar?");
		jawaban = new String[]{"Bangkai","Melati","Raflesia","Ulin"};
		status = new int[]{0,0,0,1};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Ulin", "gambar di atas merupakan pohon ulin");
		
		soalId = insertSoalFlora(assets + "ULIN.png", "Ditemukan dimana pohon diatas?");
		jawaban = new String[]{"Maluku","Sulawesi","Bandung","Bogor"};
		status = new int[]{0,1,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Sulawesi", "ulin ditemukan di hutan tropik basah yang tumbuh secara alami di wilayah Sumatera bagian selatan dan Kalimantan");
		
		soalId = insertSoalFlora(assets + "JATI.png", "Apa nama lain pohon yang ada digambar ini?");
		jawaban = new String[]{"Tectona grandis","Armorphophallus titanium","Araceae","Mawar"};
		status = new int[]{1,0,0,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Tectona grandis", "Tectona grandis merupakan nama lain dari pohon jati");
		
		soalId = insertSoalFlora(assets + "JATI.png", "Apa nama pohon yang ada digambar?");
		jawaban = new String[]{"Bangkai","Melati","Jati","Damar"};
		status = new int[]{0,0,1,0};
		insertJawaban(soalId, jawaban, status);
		insertPerpustakaan(soalId, "Jati", "gambar tersebut merupakan pohon damar");
	}
	
	private long insertSoalRumah(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_ETIKA, DatabaseAdapter.SOAL_KATEGORI_RUMAH, gambar, pertanyaan);
	}
	
	private long insertSoalSekolah(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_ETIKA, DatabaseAdapter.SOAL_KATEGORI_SEKOLAH, gambar, pertanyaan);
	}
	
	private long insertSoalSosial(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_ETIKA, DatabaseAdapter.SOAL_KATEGORI_SOSIAL, gambar, pertanyaan);
	}
	
	private long insertSoalFasilitasUmum(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_ETIKA, DatabaseAdapter.SOAL_KATEGORI_FASILITAS_UMUM, gambar, pertanyaan);
	}
	
	private long insertSoalFauna(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_UMUM, DatabaseAdapter.SOAL_KATEGORI_FAUNA, gambar, pertanyaan);
	}
	
	private long insertSoalFlora(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_UMUM, DatabaseAdapter.SOAL_KATEGORI_FLORA, gambar, pertanyaan);
	}
	
	private long insertSoalMataUang(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_UMUM, DatabaseAdapter.SOAL_KATEGORI_MATA_UANG, gambar, pertanyaan);
	}
	
	private long insertSoalBudaya(String gambar, String pertanyaan){
		return DBAdapter.insertSoal(DatabaseAdapter.SOAL_JENIS_UMUM, DatabaseAdapter.SOAL_KATEGORI_BUDAYA, gambar, pertanyaan);
	}
	
	private void insertJawaban(long soalId, String jawaban[], int status[]){
		for(int i=0; i<4; i++)
			DBAdapter.insertJawaban(soalId, jawaban[i], status[i]);
	}
	
	private void insertPerpustakaan(long soalId, String judul, String deskripsi){
			DBAdapter.insertPustaka(soalId, judul, deskripsi);
	}
	
}