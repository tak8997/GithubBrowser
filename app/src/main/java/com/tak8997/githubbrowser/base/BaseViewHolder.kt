package com.tak8997.githubbrowser.base

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView

internal open class BaseViewHolder<T : BaseItem>(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    open fun bind(item: T) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}
