package com.tak8997.githubbrowser

import android.os.Bundle
import com.tak8997.githubbrowser.databinding.ActivityMainBinding

internal class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun getModelClass(): Class<MainViewModel> = MainViewModel::class.java
}
