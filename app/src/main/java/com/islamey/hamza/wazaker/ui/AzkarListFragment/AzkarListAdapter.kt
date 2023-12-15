package com.islamey.hamza.wazaker.ui.AzkarListFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.islamey.hamza.wazaker.domain.Models.AzkarListModel
import com.islamey.hamza.wazaker.ui.OnItemListener
import com.islamey.wazkar.databinding.SimpleCellBinding

class AzkarListAdapter constructor(
    private val onItemListener: OnItemListener
) : RecyclerView.Adapter<AzkarListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SimpleCellBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemListener.onItemCLicked(adapterPosition)
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<AzkarListModel>() {
        override fun areItemsTheSame(oldItem: AzkarListModel, newItem: AzkarListModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: AzkarListModel, newItem: AzkarListModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AzkarListAdapter.ViewHolder {
        val view =
            SimpleCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AzkarListAdapter.ViewHolder, position: Int) {

        val currentItem = differ.currentList[position]

        holder.binding.tvTitle.text = currentItem.name

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}