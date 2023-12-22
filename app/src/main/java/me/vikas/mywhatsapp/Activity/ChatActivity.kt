package me.vikas.mywhatsapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_chat)

        dataBinding.navigation.setNavigationOnClickListener { finish() }

        dataBinding.navigation.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.videoCall -> {
                    startActivity(Intent(this, CallinfoActivity::class.java))
                }

            }
            return@setOnMenuItemClickListener true
        }

        dataBinding.chatText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                dataBinding.camera.visibility = View.GONE
                dataBinding.rupee.visibility = View.GONE
                dataBinding.sendBtn.setImageResource(R.drawable.ic_forward)
            } else {
                dataBinding.camera.visibility = View.VISIBLE
                dataBinding.rupee.visibility = View.VISIBLE
                dataBinding.sendBtn.setImageResource(R.drawable.ic_mic)
            }
        }
    }
}