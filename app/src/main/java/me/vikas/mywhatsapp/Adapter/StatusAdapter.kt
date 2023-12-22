package me.vikas.mywhatsapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vikas.mywhatsapp.Model.Status
import me.vikas.mywhatsapp.databinding.ItemStatusBinding

class StatusAdapter(
    private val context: Context,
    private val list: ArrayList<Status>
) : RecyclerView.Adapter<StatusAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemStatusBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.itemStatusBinding.name.text=list[position].name

        list[position].dp?.let {
            holder.itemStatusBinding.imageParent.visibility=View.GONE
            holder.itemStatusBinding.ivProfileDP.visibility=View.VISIBLE
            holder.itemStatusBinding.ivProfileDP.setImageResource(it)
        }

    }

    inner class viewHolder(itemView: ItemStatusBinding) : RecyclerView.ViewHolder(itemView.root) {
        val itemStatusBinding = itemView
    }

}