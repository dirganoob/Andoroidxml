package com.example.myapplication // Sesuaikan package Anda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class KategoriJasaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_jasa)

        // 1. Setup RecyclerView
        val rvKategori = findViewById<RecyclerView>(R.id.rvKategori)

        // 2. Data Dummy (Sesuai Figma)
        val dataKategori = listOf(
            Kategori(
                "Les & Bimbingan",
                "Jasa bimbingan belajar untuk berbagai mata pelajaran (SD, SMP, SMA) atau keahlian khusus seperti musik, mengaji, dan bahasa asing.",
                "Per Jam"
            ),
            Kategori(
                "Menjahit & Kriya",
                "Jasa perbaikan dan pemeliharaan untuk berbagai kebutuhan rumah tangga, mulai dari servis elektronik, perbaikan atap, hingga servis kendaraan.",
                "Per Item"
            ),
            Kategori(
                "Makanan",
                "Layanan penyediaan makanan untuk berbagai acara (catering), pembuatan kue pesanan, atau jasa masak panggilan untuk acara di rumah.",
                "Per Porsi"
            ),
            Kategori(
                "Servis & Perbaikan",
                "Jasa perbaikan dan pemeliharaan untuk berbagai peralatan elektronik dan kendaraan.",
                "Per Unit"
            )
        )

        // 3. Pasang Adapter
        val adapter = KategoriAdapter(dataKategori)
        rvKategori.layoutManager = LinearLayoutManager(this)
        rvKategori.adapter = adapter

        // 4. Setup Bottom Navigation (Supaya icon Jasa terpilih)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_service // Pastikan ID ini ada di menu xml
    }
}