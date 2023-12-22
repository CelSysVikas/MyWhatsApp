package me.vikas.mywhatsapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import me.vikas.mywhatsapp.Adapter.StatusAdapter
import me.vikas.mywhatsapp.Model.Chat
import me.vikas.mywhatsapp.Model.Status
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.FragmentUpdatesTabBinding


class UpdatesTabFragment : Fragment() {

    private lateinit var dataBinding: FragmentUpdatesTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_updates_tab, container, false)

        dataBinding.rvStatus.adapter=StatusAdapter(requireActivity(),generateDummyDataList())

        return dataBinding.root
    }

    private fun generateDummyDataList(): ArrayList<Status> {
        val dummyList = ArrayList<Status>()

        dummyList.add(Status(R.drawable.img,"Hello"))
        dummyList.add(Status(R.drawable.img,"Hello"))
        dummyList.add(Status(null,"Bhanu Office Walla"))
        dummyList.add(Status(null,"Golu"))

        return dummyList
    }
}