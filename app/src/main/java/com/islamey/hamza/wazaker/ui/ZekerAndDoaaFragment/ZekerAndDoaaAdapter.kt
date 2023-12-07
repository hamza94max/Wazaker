package com.islamey.hamza.wazaker.ui.ZekerAndDoaaFragment


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.islamey.hamza.wazaker.domain.Models.AzkarListModel
import com.islamey.hamza.wazaker.utils.Utils.shareText
import com.islamey.wazkar.databinding.FortyItemBinding

class ZekerAndDoaaAdapter : RecyclerView.Adapter<ZekerAndDoaaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: FortyItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<AzkarListModel>() {
        override fun areItemsTheSame(oldItem: AzkarListModel, newItem: AzkarListModel): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: AzkarListModel, newItem: AzkarListModel): Boolean {
            return oldItem == newItem
        }
    }

    var differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ZekerAndDoaaAdapter.ViewHolder {
        val view =
            FortyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ZekerAndDoaaAdapter.ViewHolder, position: Int) {

        val currentItem = differ.currentList[position]

        holder.binding.hadithText.text = currentItem.name

        holder.binding.copybtn.setOnClickListener {
            shareText(holder.itemView.context, currentItem.name)
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}