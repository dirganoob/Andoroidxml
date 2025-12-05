package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VerificationActivity extends AppCompatActivity {

    TextView btnBulan, btnPekan, btnHari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifikasi_detail); // Pastikan nama XML benar

        // --- 1. LOGIC FILTER STATISTIK (YANG SUDAH ADA) ---

        // Inisialisasi Tombol Filter
        btnBulan = findViewById(R.id.filterBulan);
        btnPekan = findViewById(R.id.filterPekan);
        btnHari = findViewById(R.id.filterHari);

        // Set Listener Filter
        if (btnBulan != null) {
            btnBulan.setOnClickListener(v -> updateFilter(btnBulan));
            btnPekan.setOnClickListener(v -> updateFilter(btnPekan));
            btnHari.setOnClickListener(v -> updateFilter(btnHari));
        }

        // --- 2. LOGIC BOTTOM NAVIGATION (BARU DITAMBAHKAN) ---

        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

        // Agar tidak ada item yang terpilih secara visual (karena ini halaman detail)
        // bottomNav.getMenu().setGroupCheckable(0, false, true); // (Opsional)

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            // 1. Ke Dashboard
            if (id == R.id.nav_dashboard) {
                Intent intent = new Intent(VerificationActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish(); // Tutup halaman verifikasi ini agar tidak menumpuk
                return true;
            }

            // 2. Ke Halaman Pengguna (Users)
            if (id == R.id.nav_users) {
                Intent intent = new Intent(VerificationActivity.this, UserListActivity.class);
                startActivity(intent);
                finish();
                return true;
            }

            // 3. Ke Halaman Jasa (Services)
            if (id == R.id.nav_service) {
                Intent intent = new Intent(VerificationActivity.this, CategoryListActivity.class);
                startActivity(intent);
                finish();
                return true;
            }

            // 4. Laporan (Jika ada)
            // if (id == R.id.nav_report) { ... }

            return false;
        });
    }

    // --- METHOD BANTUAN FILTER ---

    private void updateFilter(TextView selectedBtn) {
        // Reset style tombol lain ke inactive
        resetFilterStyle(btnBulan);
        resetFilterStyle(btnPekan);
        resetFilterStyle(btnHari);

        // Set style tombol terpilih ke active
        selectedBtn.setBackgroundResource(R.drawable.bg_filter_active);
        selectedBtn.setTextColor(Color.WHITE);
    }

    private void resetFilterStyle(TextView btn) {
        if (btn != null) {
            btn.setBackgroundResource(R.drawable.bg_filter_inactive);
            btn.setTextColor(Color.BLACK);
        }
    }
}