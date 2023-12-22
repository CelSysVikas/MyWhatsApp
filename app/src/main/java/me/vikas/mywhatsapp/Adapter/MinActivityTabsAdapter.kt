package me.vikas.mywhatsapp.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import me.vikas.mywhatsapp.Fragments.CallsTabFragment
import me.vikas.mywhatsapp.Fragments.ChatsTabFragment
import me.vikas.mywhatsapp.Fragments.CommunityTabFragment
import me.vikas.mywhatsapp.Fragments.UpdatesTabFragment

class MinActivityTabsAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return CommunityTabFragment()
            1 -> return ChatsTabFragment()
            2 -> return UpdatesTabFragment()
            3 -> return CallsTabFragment()
        }
        return ChatsTabFragment()
    }
}