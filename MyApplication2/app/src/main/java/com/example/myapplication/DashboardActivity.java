    package com.example.myapplication; // PENTING: Sesuaikan dengan nama package aplikasi Anda

    import android.content.Intent;
    import android.os.Bundle;
    import androidx.appcompat.app.AppCompatActivity;

    import com.google.android.material.bottomnavigation.BottomNavigationView;

    public class DashboardActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // PENTING: Pastikan nama di R.layout. sesuai dengan nama file XML Anda.
            // Jika nama file XML Anda adalah 'activity_main.xml', ubah jadi R.layout.activity_main
            setContentView(R.layout.activity_dashboard);

            // (Opsional) Menghilangkan Action Bar default agar desain Full Screen seperti di Figma
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            // Di dalam DashboardActivity.java -> onCreate

            BottomNavigationView bottomNav = findViewById(R.id.bottomNav);

            bottomNav.setOnItemSelectedListener(item -> {
                int id = item.getItemId();

                // Ganti R.id.menu_user sesuai ID item User di file menu/bottom_nav_menu.xml anda
                if (id == R.id.nav_users) {
                    Intent intent = new Intent(DashboardActivity.this, UserListActivity.class);
                    startActivity(intent);
                    return true;
                }

                // Di dalam DashboardActivity.java
                if (id == R.id.nav_service) { // Pastikan ID sesuai menu XML (nav_service)
                    Intent intent = new Intent(DashboardActivity.this, CategoryListActivity.class);
                    startActivity(intent);
                    return true;
                }

                if (id == R.id.nav_report) { // Pastikan ID sesuai menu XML (nav_service)
                    Intent intent = new Intent(DashboardActivity.this, VerificationActivity.class);
                    startActivity(intent);
                    return true;
                }

                return true;
            });
        }
    }