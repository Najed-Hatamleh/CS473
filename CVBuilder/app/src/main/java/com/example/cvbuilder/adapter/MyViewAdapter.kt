package com.example.cvbuilder.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvbuilder.data.Work
import com.example.cvbuilder.ui.fragment.AboutFragment
import com.example.cvbuilder.ui.fragment.ContactFragment
import com.example.cvbuilder.ui.fragment.HomeFragment
import com.example.cvbuilder.ui.fragment.WorkFragment


class MyViewAdapter(fm:FragmentManager,lc:Lifecycle) : FragmentStateAdapter(fm,lc) {
    override fun getItemCount(): Int = 4
    val workFragment = WorkFragment()
    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> workFragment
            3-> ContactFragment()
            else-> Fragment()
        }
    }

    fun addWork(work: Work){
        workFragment.onAddWOrk(work)
    }
}

