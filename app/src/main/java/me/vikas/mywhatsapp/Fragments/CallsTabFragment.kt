package me.vikas.mywhatsapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import me.vikas.mywhatsapp.Adapter.CallsAdapter
import me.vikas.mywhatsapp.Model.Call
import me.vikas.mywhatsapp.Model.CallType
import me.vikas.mywhatsapp.Model.Chat
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.FragmentCallsTabBinding

class CallsTabFragment : Fragment() {

    private lateinit var dataBinding:FragmentCallsTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_calls_tab, container, false)

        dataBinding.rvCalls.layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        dataBinding.rvCalls.adapter=CallsAdapter(requireActivity(),generateDummyDataList())


        return dataBinding.root
    }

    private fun generateDummyDataList(): ArrayList<Call> {
        val dummyList = ArrayList<Call>()

        // Adding dummy data to the list
        dummyList.add(Call(name = "Vikas Kumar", isVideo = true, call = CallType.SEND, dp = R.drawable.img,time = "now"))
        dummyList.add(Call(name = "Vikas Kumar", isVideo = false, call = CallType.RECEIVE, dp = null,time = "December 25, 2:33 PM"))
        dummyList.add(Call(name = "Vikas Kumar", isVideo = true, call = CallType.MISSED, dp = R.drawable.img,time = "November 11, 3:22 AM"))
    dummyList.add(Call(name = "Vikas Kumar", isVideo = true, call = CallType.SEND, dp = R.drawable.img,time = "now"))
        dummyList.add(Call(name = "Vikas Kumar", isVideo = false, call = CallType.RECEIVE, dp = null,time = "December 25, 2:33 PM"))
        dummyList.add(Call(name = "Vikas Kumar", isVideo = true, call = CallType.MISSED, dp = R.drawable.img,time = "November 11, 3:22 AM"))
        dummyList.add(
            Call(
                name = "Vikas Kumar",
                isVideo = true,
                call = CallType.SEND,
                dp = R.drawable.img,
                time = "now"
            )
        )
        dummyList.add(
            Call(
                name = "Vikas Kumar",
                isVideo = false,
                call = CallType.RECEIVE,
                dp = null,
                time = "December 25, 2:33 PM"
            )
        )
        dummyList.add(
            Call(
                name = "Vikas Kumar",
                isVideo = true,
                call = CallType.MISSED,
                dp = R.drawable.img,
                time = "November 11, 3:22 AM"
            )
        )

        return dummyList
    }
}