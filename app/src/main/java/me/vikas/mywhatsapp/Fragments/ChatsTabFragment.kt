package me.vikas.mywhatsapp.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import me.vikas.mywhatsapp.Adapter.ChatsAdapter
import me.vikas.mywhatsapp.Model.Chat
import me.vikas.mywhatsapp.R
import me.vikas.mywhatsapp.databinding.FragmentChatsTabBinding

class ChatsTabFragment : Fragment() {

    private lateinit var dataBinding: FragmentChatsTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_chats_tab, container, false)
        dataBinding.rvChat.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        dataBinding.rvChat.adapter = ChatsAdapter(requireActivity(), generateDummyDataList())


        return dataBinding.root
    }

    private fun generateDummyDataList(): ArrayList<Chat> {
        val dummyList = ArrayList<Chat>()

        // Adding dummy data to the list
        dummyList.add(Chat("Vikas Kumar", R.drawable.img, "Hi bro", "now", true))
        dummyList.add(Chat("Vikas kjbd skjn", null, "Hi", "Yesterday", false))
        dummyList.add(Chat("Golu CE Branch", null, "Hoe", "Yesterday", false))
        dummyList.add(
            Chat(
                "Bhalu Office Walla",
                null,
                "How are you man I am Missing you, where are you",
                "3/3/23",
                false
            )
        )
        dummyList.add(Chat("Chaalu", R.drawable.img, "Hi bro", "5/5/22", false))
        dummyList.add(Chat("Vikas Kumar", R.drawable.img, "Hi bro", "now", true))
        dummyList.add(Chat("Vikas kjbd skjn", null, "Hi", "Yesterday", false))
        dummyList.add(Chat("Golu CE Branch", null, "Hoe", "Yesterday", false))
        dummyList.add(
            Chat(
                "Bhalu Office Walla",
                null,
                "How are you man I am Missing you, where are you",
                "3/3/23",
                false
            )
        )
        dummyList.add(Chat("Chaalu", R.drawable.img, "Hi bro", "5/5/22", false))
        dummyList.add(Chat("Vikas Kumar", R.drawable.img, "Hi bro", "now", true))
        dummyList.add(Chat("Vikas kjbd skjn", null, "Hi", "Yesterday", false))
        dummyList.add(Chat("Golu CE Branch", null, "Hoe", "Yesterday", false))
        dummyList.add(
            Chat(
                "Bhalu Office Walla",
                null,
                "How are you man I am Missing you, where are you",
                "3/3/23",
                false
            )
        )
        dummyList.add(Chat("Chaalu", R.drawable.img, "Hi bro", "5/5/22", false))

        return dummyList
    }

}