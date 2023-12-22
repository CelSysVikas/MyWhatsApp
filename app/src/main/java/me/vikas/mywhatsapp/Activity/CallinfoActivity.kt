package me.vikas.mywhatsapp.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import me.vikas.mywhatsapp.Adapter.CallsHistoryAdapter
import me.vikas.mywhatsapp.Model.CallType
import me.vikas.mywhatsapp.Model.CallsHistory
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.ActivityCallinfoBinding

class CallinfoActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityCallinfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_callinfo)

        dataBinding.navigation.setNavigationOnClickListener { finish() }
        dataBinding.rvCallHistory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        dataBinding.rvCallHistory.adapter = CallsHistoryAdapter(this, generateDummyDataList())

    }

    private fun generateDummyDataList(): ArrayList<CallsHistory> {
        val dummyList = ArrayList<CallsHistory>()

        // Adding dummy data to the list
        dummyList.add(
            CallsHistory(
                call = CallType.RECEIVE,
                isVideo = true,
                time = "8:32 PM",
                duration = "12:02",
                dataTransfer = "7.2 MB"
            )
        )

        dummyList.add(
            CallsHistory(
                call = CallType.MISSED,
                isVideo = false,
                time = "8:32 PM",
                duration = null,
                dataTransfer = null
            )
        )

        dummyList.add(
            CallsHistory(
                call = CallType.MISSED,
                isVideo = true,
                time = "8:32 PM",
                duration = null,
                dataTransfer = null
            )
        )

        dummyList.add(
            CallsHistory(
                call = CallType.SEND,
                isVideo = false,
                time = "8:32 PM",
                duration = "12:02",
                dataTransfer = "72.2 MB"
            )
        )

        return dummyList
    }
}