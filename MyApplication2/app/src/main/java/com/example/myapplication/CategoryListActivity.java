package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity {

    RecyclerView rvKategori;
    CardView cvTambahLayanan;
    CategoryAdapter adapter;
    List<CategoryModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_jasa);

        rvKategori = findViewById(R.id.rvKategori);
        cvTambahLayanan = findViewById(R.id.cvTambahLayanan);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // 1. Setup Data Dummy (DESKRIPSI PANJANG)
        list = new ArrayList<>();

        list.add(new CategoryModel(
                "Les & Bimbingan",
                "Jasa bimbingan belajar intensif untuk berbagai mata pelajaran sekolah (SD, SMP, SMA) termasuk persiapan ujian nasional dan tes masuk perguruan tinggi. Mentor berpengalaman siap datang ke rumah.",
                "Per jam"
        ));

        list.add(new CategoryModel(
                "Menjahit & Kriya",
                "Layanan profesional untuk perbaikan pakaian (vermak), pembuatan baju custom (kebaya, jas, seragam), serta pembuatan kerajinan tangan berkualitas tinggi sesuai permintaan pelanggan.",
                "Per item"
        ));

        list.add(new CategoryModel(
                "Makanan & Katering",
                "Penyediaan aneka makanan lezat untuk berbagai acara seperti pesta ulang tahun, syukuran, rapat kantor, atau katering harian rumah tangga dengan menu yang higienis dan variatif setiap harinya.",
                "Per Porsi"
        ));

        list.add(new CategoryModel(
                "Servis & Elektronik",
                "Jasa perbaikan peralatan elektronik rumah tangga seperti AC, Kulkas, Mesin Cuci, dan Televisi. Teknisi bersertifikat dan memberikan garansi servis selama 30 hari untuk setiap pengerjaan.",
                "Per Unit"
        ));

        // 2. Setup RecyclerView
        rvKategori.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CategoryAdapter(this, list);
        rvKategori.setAdapter(adapter);

        // 3. Logic Tombol Tambah
        cvTambahLayanan.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryListActivity.this, AddCategoryActivity.class);
            startActivity(intent);
        });

        // 4. Logic Bottom Nav
        bottomNav.setSelectedItemId(R.id.nav_service);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_dashboard) {
                finish();
                return true;
            } else if (id == R.id.nav_users) {
                startActivity(new Intent(this, UserListActivity.class));
                finish(); // Tutup agar tidak menumpuk
                return true;
            }
            return id == R.id.nav_service;
        });
    }
}