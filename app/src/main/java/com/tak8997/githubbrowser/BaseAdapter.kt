package com.tak8997.githubbrowser

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.tak8997.githubbrowser.base.BaseDiffItemCallback
import com.tak8997.githubbrowser.base.BaseItem
import com.tak8997.githubbrowser.base.BaseViewHolder


internal abstract class BaseAdapter<T : BaseItem>(
    private val viewModel: BaseViewModel,
    diffCallback: DiffUtil.ItemCallback<T> = BaseDiffItemCallback()
) : ListAdapter<T, BaseViewHolder<T>>(diffCallback) {

    abstract fun layoutIdByViewType(viewType: Int): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> {
        val binding = createDataBinding(parent, layoutIdByViewType(viewType))
        val viewHolder = createViewHolder(binding, viewType)

        onBindingAndHolderCreated(viewHolder, binding, viewType)

        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int, payloads: MutableList<Any>) {
        holder.bind(getItem(position))
    }

    open fun onBindingAndHolderCreated(viewHolder: BaseViewHolder<T>, binding: ViewDataBinding, viewType: Int) {}

    open fun createViewHolder(binding: ViewDataBinding, viewType: Int): BaseViewHolder<T> {
        return BaseViewHolder(binding)
    }

    open fun createDataBinding(parent: ViewGroup, layoutIdByViewType: Int): ViewDataBinding {
        return DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutIdByViewType,
            parent,
            false
        ).apply {
            setVariable(BR.viewModel, viewModel)
        }
    }
}
