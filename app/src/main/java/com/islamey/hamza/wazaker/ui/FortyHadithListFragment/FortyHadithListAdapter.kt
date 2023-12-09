package com.islamey.hamza.wazaker.ui.FortyHadithListFragment


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.islamey.hamza.wazaker.domain.Models.AzkarListModel
import com.islamey.hamza.wazaker.ui.OnItemListener
import com.islamey.wazkar.databinding.FortyListItemBinding

class FortyHadithListAdapter constructor(
    private val onItemListener: OnItemListener
) : RecyclerView.Adapter<FortyHadithListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: FortyListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<AzkarListModel>() {
        override fun areItemsTheSame(oldItem: AzkarListModel, newItem: AzkarListModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: AzkarListModel, newItem: AzkarListModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FortyHadithListAdapter.ViewHolder {
        val view =
            FortyListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FortyHadithListAdapter.ViewHolder, position: Int) {

        val currentItem = differ.currentList[position]

        holder.binding.tvTitle.text = currentItem.name

        holder.itemView.setOnClickListener {
            onItemListener.onItemCLicked(position)
        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}