package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class TalentDetailActivity extends AppCompatActivity {

    // Tab Components
    LinearLayout tabTentang, tabGaleri, tabUlasan;
    TextView txtTentang, txtGaleri, txtUlasan;
    View lineTentang, lineGaleri, lineUlasan;

    // Content Layouts
    LinearLayout contentTentang, contentGaleri, contentUlasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_talent); // Pastikan nama XML sesuai

        // 1. Inisialisasi Views
        initViews();

        // 2. Setup Listener Tombol Back & Share
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());
        findViewById(R.id.btnShare).setOnClickListener(v ->
                Toast.makeText(this, "Link profil disalin!", Toast.LENGTH_SHORT).show()
        );

        // 3. Setup Logic Pindah Tab
        tabTentang.setOnClickListener(v -> switchTab("tentang"));
        tabGaleri.setOnClickListener(v -> switchTab("galeri"));
        tabUlasan.setOnClickListener(v -> switchTab("ulasan"));

        // 4. Setup Tombol Request
        MaterialButton btnRequest = findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(v ->
                Toast.makeText(this, "Permintaan akses terkirim!", Toast.LENGTH_SHORT).show()
        );
    }

    private void initViews() {
        // Tab Containers
        tabTentang = findViewById(R.id.tabTentang);
        tabGaleri = findViewById(R.id.tabGaleri);
        tabUlasan = findViewById(R.id.tabUlasan);

        // Text Titles
        txtTentang = findViewById(R.id.txtTabTentang);
        txtGaleri = findViewById(R.id.txtTabGaleri);
        txtUlasan = findViewById(R.id.txtTabUlasan);

        // Line Indicators
        lineTentang = findViewById(R.id.lineTabTentang);
        lineGaleri = findViewById(R.id.lineTabGaleri);
        lineUlasan = findViewById(R.id.lineTabUlasan);

        // Contents
        contentTentang = findViewById(R.id.contentTentang);
        contentGaleri = findViewById(R.id.contentGaleri);
        contentUlasan = findViewById(R.id.contentUlasan);
    }

    private void switchTab(String tabName) {
        // Reset Semua ke Default (Abu-abu / Hidden)
        int colorActive = Color.parseColor("#1A237E"); // Biru Tua
        int colorInactive = Color.parseColor("#808080"); // Abu-abu

        txtTentang.setTextColor(colorInactive);
        txtGaleri.setTextColor(colorInactive);
        txtUlasan.setTextColor(colorInactive);

        lineTentang.setVisibility(View.INVISIBLE);
        lineGaleri.setVisibility(View.INVISIBLE);
        lineUlasan.setVisibility(View.INVISIBLE);

        contentTentang.setVisibility(View.GONE);
        contentGaleri.setVisibility(View.GONE);
        contentUlasan.setVisibility(View.GONE);

        // Aktifkan Tab yang dipilih
        switch (tabName) {
            case "tentang":
                txtTentang.setTextColor(colorActive);
                lineTentang.setVisibility(View.VISIBLE);
                contentTentang.setVisibility(View.VISIBLE);
                break;
            case "galeri":
                txtGaleri.setTextColor(colorActive);
                lineGaleri.setVisibility(View.VISIBLE);
                contentGaleri.setVisibility(View.VISIBLE);
                break;
            case "ulasan":
                txtUlasan.setTextColor(colorActive);
                lineUlasan.setVisibility(View.VISIBLE);
                contentUlasan.setVisibility(View.VISIBLE);
                break;
        }
    }
}