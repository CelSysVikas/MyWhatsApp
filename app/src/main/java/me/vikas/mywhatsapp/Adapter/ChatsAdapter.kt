package me.vikas.mywhatsapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vikas.mywhatsapp.Activity.ChatActivity
import me.vikas.mywhatsapp.Model.Chat
import me.vikas.mywhatsapp.databinding.ItemChatBinding

class ChatsAdapter(
    private val context: Context,
    private val list: ArrayList<Chat>
) : RecyclerView.Adapter<ChatsAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemChatBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.itemChatBinding.tvTime.text = list[position].time
        holder.itemChatBinding.tvUserName.text = list[position].name
        holder.itemChatBinding.tvMessage.text = list[position].message

        list[position].dp?.let {
            holder.itemChatBinding.imageParent.visibility = View.GONE
            holder.itemChatBinding.ivProfileDP.visibility = View.VISIBLE
            holder.itemChatBinding.ivProfileDP.setImageResource(it)
        }

        if (list[position].isPinned) holder.itemChatBinding.ivChatPin.visibility = View.VISIBLE
        else holder.itemChatBinding.ivChatPin.visibility = View.GONE

        holder.itemChatBinding.parent.setOnClickListener {
            context.startActivity(Intent(context, ChatActivity::class.java))
        }
    }

    inner class viewHolder(itemView: ItemChatBinding) : RecyclerView.ViewHolder(itemView.root) {
        val itemChatBinding = itemView
    }

}