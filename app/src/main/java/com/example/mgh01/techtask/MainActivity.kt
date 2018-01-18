package com.example.mgh01.techtask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.mgh01.techtask.adapters.MainTabAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tab_pager.adapter = MainTabAdapter(fragmentManager = supportFragmentManager, titles = getTabTitles())
        tab_layout.setupWithViewPager(tab_pager)
    }

    private fun getTabTitles() = listOf(getString(R.string.github_tab_title), getString(R.string.login_tab_title), getString(R.string.todo_tab_title))
}
