package com.tak8997.githubbrowser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

internal abstract class BaseFragment<VB: ViewDataBinding, VM: ViewModel> : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var binding: VB
    lateinit var viewModel: VM

    @LayoutRes
    protected abstract fun getLayoutRes(): Int
    protected abstract fun getModelClass(): Class<VM>

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this, viewModelFactory).get(getModelClass())

        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.viewModel, viewModel)

        return binding.root
    }
}