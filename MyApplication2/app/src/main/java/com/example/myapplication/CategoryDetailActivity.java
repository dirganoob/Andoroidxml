package com.example.myapplication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class CategoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kategori); // XML Ketiga Anda

        ImageView btnBack = findViewById(R.id.btnBack);
        TextView tvTitle = findViewById(R.id.tvTitle);
        MaterialButton btnHapus = findViewById(R.id.btnHapusKategori);

        // Ambil Nama Kategori dari Intent
        String catName = getIntent().getStringExtra("CAT_NAME");
        if (catName != null) {
            tvTitle.setText(catName);
        }

        btnBack.setOnClickListener(v -> finish());

        // Logic Tombol Hapus -> Muncul Dialog Konfirmasi
        btnHapus.setOnClickListener(v -> showDeleteDialog());
    }

    private void showDeleteDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_konfirmasi); // Pakai XML Dialog yg sudah ada
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView tvQuestion = dialog.findViewById(R.id.tvDialogQuestion);
        tvQuestion.setText("Yakin ingin menghapus kategori ini?");

        TextView btnYes = dialog.findViewById(R.id.btnDialogYes);
        btnYes.setOnClickListener(v -> {
            Toast.makeText(this, "Kategori Dihapus", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
            finish(); // Kembali ke list
        });

        TextView btnNo = dialog.findViewById(R.id.btnDialogNo);
        btnNo.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}