package com.tak8997.githubbrowser.ui

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.tak8997.githubbrowser.BaseActivity
import com.tak8997.githubbrowser.R
import com.tak8997.githubbrowser.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

internal class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getLayoutRes(): Int = R.layout.activity_main
    override fun getModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBottomNav()
    }

    private fun setupBottomNav() {
        navHostFragment.findNavController().let {
            bottomNav.setupWithNavController(it)
        }
    }
}
