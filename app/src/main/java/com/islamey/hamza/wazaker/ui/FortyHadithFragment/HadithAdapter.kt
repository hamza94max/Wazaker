package com.islamey.hamza.wazaker.ui.FortyHadithFragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.islamey.hamza.wazaker.domain.Models.Hadith
import com.islamey.hamza.wazaker.utils.Utils.shareText
import com.islamey.wazkar.databinding.FortyItemBinding

class HadithAdapter : RecyclerView.Adapter<HadithAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: FortyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.copybtn.setOnClickListener {
                shareText(itemView.context, differ.currentList[layoutPosition].hadith)
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<Hadith>() {
        override fun areItemsTheSame(oldItem: Hadith, newItem: Hadith): Boolean {
            return oldItem.hadith == newItem.hadith
        }

        override fun areContentsTheSame(oldItem: Hadith, newItem: Hadith): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithAdapter.ViewHolder {
        val view = FortyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadithAdapter.ViewHolder, position: Int) {

        val currentItem = differ.currentList[position]

        holder.binding.hadithText.text = currentItem.hadith

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}