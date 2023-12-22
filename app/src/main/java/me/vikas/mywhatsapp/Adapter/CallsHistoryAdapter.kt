package me.vikas.mywhatsapp.Adapter

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
import me.vikas.mywhatsapp.Model.CallsHistory
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.ItemCallBinding
import me.vikas.mywhatsapp.databinding.ItemCallHistoryBinding

class CallsHistoryAdapter(
    private val context: Context,
    private val list: ArrayList<CallsHistory>
) : RecyclerView.Adapter<CallsHistoryAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(ItemCallHistoryBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: viewHolder, position: Int) {

        holder.itemChatBinding.tvTime.text = list[position].time

        list[position].dataTransfer?.let {
            holder.itemChatBinding.tvData.text=it
        }

        list[position].duration?.let {
            holder.itemChatBinding.tvTimeTaken.text=it
        }

        if (list[position].isVideo) holder.itemChatBinding.ivCallType.setImageResource(R.drawable.ic_video)
        if (list[position].call == CallType.SEND) {
            holder.itemChatBinding.tvName.text="Outgoing"
            holder.itemChatBinding.imageParent.setImageResource(R.drawable.ic_call_send)
        }
        if (list[position].call == CallType.RECEIVE) {
            holder.itemChatBinding.tvName.text="Incoming"
            holder.itemChatBinding.imageParent.setImageResource(R.drawable.ic_call_receive)
        }
        if (list[position].call == CallType.MISSED) {
            holder.itemChatBinding.tvName.text="Missed"
            holder.itemChatBinding.tvData.visibility=View.GONE
            holder.itemChatBinding.imageParent.setImageResource(R.drawable.ic_call_receive)
            holder.itemChatBinding.imageParent.setColorFilter(ContextCompat.getColor(context,R.color.missedCall))
        }
    }

    inner class viewHolder(itemView: ItemCallHistoryBinding) : RecyclerView.ViewHolder(itemView.root) {
        val itemChatBinding = itemView
    }

}