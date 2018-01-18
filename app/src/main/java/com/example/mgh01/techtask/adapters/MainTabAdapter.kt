package com.example.mgh01.techtask.adapters

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.mgh01.techtask.fragments.GitHubUserSearchFragment
import com.example.mgh01.techtask.fragments.LoginFragment
import com.example.mgh01.techtask.fragments.ToDoFragment

class MainTabAdapter(private val titles: List<String>,
                     fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private val fragments = listOf(GitHubUserSearchFragment(), LoginFragment(), ToDoFragment())

    override fun getItem(position: Int) = fragments[position]
    override fun getPageTitle(position: Int): CharSequence = titles[position]
    override fun getCount() = fragments.size
}