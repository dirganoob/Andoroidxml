package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvRole: TextView = itemView.findViewById(R.id.tvRole)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // Pastikan nama layout item anda adalah 'item_user'
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]

        holder.tvName.text = user.name
        holder.tvDate.text = user.date
        holder.tvRole.text = user.role

        // Logika Warna Status (Hijau/Merah)
        if (user.isActive) {
            holder.tvStatus.text = "Aktif"
            holder.tvStatus.setTextColor(Color.parseColor("#4CAF50")) // Hijau
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_active)
        } else {
            holder.tvStatus.text = "Nonaktif"
            holder.tvStatus.setTextColor(Color.parseColor("#F44336")) // Merah
            holder.tvStatus.setBackgroundResource(R.drawable.bg_status_inactive)
        }
    }

    override fun getItemCount() = userList.size
}