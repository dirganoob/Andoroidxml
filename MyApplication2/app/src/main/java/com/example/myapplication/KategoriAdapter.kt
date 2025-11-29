package com.example.myapplication // Sesuaikan package Anda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KategoriAdapter(private val listData: List<Kategori>) :
    RecyclerView.Adapter<KategoriAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNama: TextView = itemView.findViewById(R.id.tvNamaKategori)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tvDeskripsi)
        val tvSatuan: TextView = itemView.findViewById(R.id.tvSatuan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kategori, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = listData[position]
        holder.tvNama.text = data.nama
        holder.tvDeskripsi.text = data.deskripsi
        holder.tvSatuan.text = data.satuan
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}