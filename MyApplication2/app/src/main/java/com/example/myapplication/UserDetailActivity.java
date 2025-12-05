package com.example.myapplication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class UserDetailActivity extends AppCompatActivity {

    ImageView btnBack;
    TextView tvDetailName, tvDetailEmail;
    MaterialButton btnNonaktif, btnHapus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengguna); // Nama XML Detail Anda

        // Inisialisasi View
        btnBack = findViewById(R.id.btnBack);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailEmail = findViewById(R.id.tvDetailEmail);
        btnNonaktif = findViewById(R.id.btnNonaktif);
        btnHapus = findViewById(R.id.btnHapus);

        // Ambil data yang dikirim dari List
        String name = getIntent().getStringExtra("USER_NAME");
        String email = getIntent().getStringExtra("USER_EMAIL");

        if (name != null) tvDetailName.setText(name);
        if (email != null) tvDetailEmail.setText(email);

        // Logic Tombol Back
        btnBack.setOnClickListener(v -> onBackPressed());

        // Logic Tombol Nonaktifkan -> Muncul Dialog
        btnNonaktif.setOnClickListener(v -> showCustomDialog("nonaktifkan"));

        // Logic Tombol Hapus -> Muncul Dialog
        btnHapus.setOnClickListener(v -> showCustomDialog("menghapus"));
    }

    // Fungsi untuk memunculkan Dialog Custom (XML ke-3 Anda)
    private void showCustomDialog(String actionType) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_konfirmasi); // Nama XML Dialog Anda
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // Init Komponen dalam Dialog
        TextView tvQuestion = dialog.findViewById(R.id.tvDialogQuestion);
        TextView btnYes = dialog.findViewById(R.id.btnDialogYes);
        TextView btnNo = dialog.findViewById(R.id.btnDialogNo);

        // Ubah teks pertanyaan sesuai tombol yang diklik (Hapus/Nonaktif)
        tvQuestion.setText("Yakin ingin " + actionType + " pengguna?");

        // Logic Tombol YA di Dialog
        btnYes.setOnClickListener(v -> {
            Toast.makeText(UserDetailActivity.this, "Pengguna berhasil di-" + actionType, Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            finish(); // Kembali ke list setelah aksi selesai
        });

        // Logic Tombol TIDAK di Dialog
        btnNo.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}