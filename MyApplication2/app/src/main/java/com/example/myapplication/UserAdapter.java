package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    List<UserModel> userList;

    public UserAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserModel user = userList.get(position);

        // 1. Set Nama
        holder.tvName.setText(user.getName());

        // 2. Set Tanggal
        holder.tvDate.setText(user.getDate());

        // 3. Set Role (Pencari Jasa / Penyedia Jasa)
        holder.tvRole.setText(user.getRole());

        // 4. Set Status & Warnanya
        holder.tvStatus.setText(user.getStatus());

        // Logika warna status sederhana
        if (user.getStatus().equalsIgnoreCase("Aktif")) {
            holder.tvStatus.setTextColor(Color.parseColor("#4CAF50")); // Hijau
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_active); // Pastikan drawable ini ada
        } else {
            holder.tvStatus.setTextColor(Color.RED);
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_inactive); // Pastikan drawable ini ada (atau pakai yg active sementara)
        }

        // Logika Klik Pindah Halaman
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, UserDetailActivity.class);
            // Kirim data ke detail
            intent.putExtra("USER_NAME", user.getName());
            intent.putExtra("USER_ROLE", user.getRole());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        // Deklarasi variabel sesuai XML Anda
        TextView tvName, tvDate, tvRole, tvStatus;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            // PENTING: ID DISINI HARUS SAMA DENGAN XML item_user.xml
            tvName = itemView.findViewById(R.id.tvName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvRole = itemView.findViewById(R.id.tvRole);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}