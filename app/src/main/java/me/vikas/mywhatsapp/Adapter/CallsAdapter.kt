package me.vikas.mywhatsapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import me.vikas.mywhatsapp.Activity.CallinfoActivity
import me.vikas.mywhatsapp.Model.Call
import me.vikas.mywhatsapp.Model.CallType
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.ItemCallBinding

class CallsAdapter(
    private val context: Context,
    private val list: ArrayList<Call>
) : RecyclerView.Adapter<CallsAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemCallBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.itemChatBinding.tvTime.text = list[position].time

        if (list[position].isVideo) holder.itemChatBinding.ivCall.setImageResource(R.drawable.ic_video)
        if (list[position].call == CallType.SEND) holder.itemChatBinding.ivCallType.setImageResource(
            R.drawable.ic_call_send
        )
        if (list[position].call == CallType.RECEIVE) holder.itemChatBinding.ivCallType.setImageResource(
            R.drawable.ic_call_receive
        )
        if (list[position].call == CallType.MISSED) {
            holder.itemChatBinding.ivCallType.setImageResource(R.drawable.ic_call_receive)
            holder.itemChatBinding.ivCallType.setColorFilter(ContextCompat.getColor(context,R.color.missedCall))
            holder.itemChatBinding.tvName.setTextColor(ContextCompat.getColor(context,R.color.missedCall))
        }

        list[position].dp?.let {
            holder.itemChatBinding.imageParent.visibility = View.GONE
            holder.itemChatBinding.ivProfileDP.visibility = View.VISIBLE
            holder.itemChatBinding.ivProfileDP.setImageResource(it)
        }

        holder.itemChatBinding.parent.setOnClickListener {
            context.startActivity(
                Intent(
                    context,
                    CallinfoActivity::class.java
                )
            )
        }
    }

    inner class viewHolder(itemView: ItemCallBinding) : RecyclerView.ViewHolder(itemView.root) {
        val itemChatBinding = itemView
    }

}