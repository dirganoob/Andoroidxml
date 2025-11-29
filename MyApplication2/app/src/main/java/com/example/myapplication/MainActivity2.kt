package com.example.myapplication // Sesuaikan package

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() { // Ganti nama class jika perlu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manajemen_pengguna)

        // 1. Ambil RecyclerView
        val rvUsers = findViewById<RecyclerView>(R.id.rvUsers)

        // 2. Siapkan Data (Franz, Yuki, Niky)
        val dataUsers = listOf(
            User("Franz Herman", "26 Maret 2026", "Pencari Jasa", true),  // Aktif (Hijau)
            User("Yuki", "26 Maret 2026", "Pencari Jasa", false),         // Nonaktif (Merah)
            User("Niky Putra", "26 Maret 2026", "Penyedia Jasa", true),   // Aktif (Hijau)
            User("Budi Santoso", "27 Maret 2026", "Penyedia Jasa", false) // Tambahan contoh
        )

        // 3. Pasang Adapter
        val adapter = UserAdapter(dataUsers)
        rvUsers.layoutManager = LinearLayoutManager(this) // Wajib agar list muncul
        rvUsers.adapter = adapter
    }
}