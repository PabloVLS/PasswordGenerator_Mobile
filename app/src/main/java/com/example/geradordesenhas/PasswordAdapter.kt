package com.example.geradordesenhas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PasswordAdapter(private val senhas: List<String>) :
    RecyclerView.Adapter<PasswordAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val tv: TextView = view.findViewById(R.id.tv_password_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_password, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tv.text = senhas[position]
    }

    override fun getItemCount() = senhas.size
}