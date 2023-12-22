package me.vikas.mywhatsapp.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import me.vikas.mywhatsapp.Adapter.MinActivityTabsAdapter
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.viewPager2.adapter = MinActivityTabsAdapter(this)
        dataBinding.viewPager2.currentItem = 1

        TabLayoutMediator(dataBinding.tabLayout, dataBinding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.setIcon(R.drawable.ic_community)
                }

                1 -> {
                    tab.text = getString(R.string.chats)
                }

                2 -> {
                    tab.text = getString(R.string.updates)
                }

                3 -> {
                    tab.text = getString(R.string.calls)
                }
            }
        }.attach()

        manageViewPager()
    }

    private fun manageViewPager() {
        dataBinding.viewPager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        dataBinding.fabMainSmall.visibility=View.GONE
                        dataBinding.fabMain.visibility = View.GONE
                    }

                    1 -> {
                        dataBinding.fabMainSmall.visibility=View.GONE
                        dataBinding.fabMain.visibility = View.VISIBLE
                        dataBinding.fabMain.setImageResource(R.drawable.ic_chat)
                        dataBinding.fabMain.setOnClickListener {
                            startActivity(Intent(this@MainActivity,NewChatActivity::class.java))
                        }
                    }

                    2 -> {
                        dataBinding.fabMainSmall.visibility=View.VISIBLE
                        dataBinding.fabMain.visibility = View.VISIBLE
                        dataBinding.fabMain.setImageResource(R.drawable.ic_camera_filled)
                    }

                    3 -> {
                        dataBinding.fabMainSmall.visibility=View.GONE
                        dataBinding.fabMain.visibility = View.VISIBLE
                        dataBinding.fabMain.setImageResource(R.drawable.ic_add_call)

                        dataBinding.fabMain.setOnClickListener {
                            startActivity(Intent(this@MainActivity,CallinfoActivity::class.java))
                        }
                    }
                }
            }
        })
    }
}