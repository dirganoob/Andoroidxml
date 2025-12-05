package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class AddCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kategori); // XML Kedua Anda

        ImageView btnBack = findViewById(R.id.btnBack);
        MaterialButton btnSimpan = findViewById(R.id.btnSimpan);

        btnBack.setOnClickListener(v -> finish()); // Kembali

        btnSimpan.setOnClickListener(v -> {
            // Di sini nanti logika simpan ke database
            Toast.makeText(this, "Kategori Berhasil Disimpan!", Toast.LENGTH_SHORT).show();
            finish(); // Kembali ke halaman list setelah simpan
        });
    }
}