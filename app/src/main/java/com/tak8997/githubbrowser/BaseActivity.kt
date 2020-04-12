package com.tak8997.githubbrowser

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


abstract class BaseActivity<VB : ViewDataBinding, VM : ViewModel>: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var binding: VB
    lateinit var viewModel: VM

    private var lastClickTime = 0L

    @LayoutRes
    protected abstract fun getLayoutRes(): Int
    protected abstract fun getModelClass(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(getModelClass())

        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this
        binding.setVariable(BR.view, this)
        binding.setVariable(BR.viewModel, viewModel)
    }

//    override fun onClick(view: View?) {
//        val currentClickTime = SystemClock.uptimeMillis()
//        val elapsedTime = currentClickTime - lastClickTime
//        lastClickTime = currentClickTime
//
//        if (elapsedTime <= OnSingleClickListener.CLICK_INTERVAL) {
//            return
//        }
//        onSingleClick(view)
//    }
}