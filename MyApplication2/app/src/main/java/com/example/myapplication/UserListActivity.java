package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {

    RecyclerView rvUsers;
    UserAdapter adapter;
    List<UserModel> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manajemen_pengguna); // Pastikan nama file XML list benar

        rvUsers = findViewById(R.id.rvUsers);

        // Setup Data Dummy
        userList = new ArrayList<>();

// Format: Nama, Tanggal, Role, Status
        userList.add(new UserModel("Franz Herman", "26 Maret 2026", "Pencari\nJasa", "Aktif"));
        userList.add(new UserModel("Niky Putra", "20 Maret 2026", "Penyedia\nJasa", "Nonaktif"));
        userList.add(new UserModel("Yudil", "15 April 2026", "Pencari\nJasa", "Aktif"));

        adapter = new UserAdapter(this, userList);
        rvUsers.setAdapter(adapter);
        // Setup RecyclerView
        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        // Setup Bottom Nav (Opsional: agar tombol home bisa kembali ke dashboard)
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_dashboard) { // Asumsi ID home di menu
                finish(); // Kembali ke dashboard
                return true;
            }
            return false;
        });
    }
}