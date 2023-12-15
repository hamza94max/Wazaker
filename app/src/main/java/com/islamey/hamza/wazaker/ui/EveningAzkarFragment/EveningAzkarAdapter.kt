package com.islamey.hamza.wazaker.ui.EveningAzkarFragment


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.islamey.hamza.wazaker.domain.Models.ZekerModel
import com.islamey.hamza.wazaker.utils.Utils.shareText
import com.islamey.wazkar.databinding.MorningItemBinding

class EveningAzkarAdapter : RecyclerView.Adapter<EveningAzkarAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: MorningItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.copybtn.setOnClickListener {
                shareText(itemView.context, differ.currentList[layoutPosition].zeker)
            }
        }

        fun bind(currentItem: ZekerModel) {
            var count = 0

            binding.plustext.text = count.toString()

            binding.plusButton.setOnClickListener {
                count++
                binding.plustext.text = count.toString()
                if (count >= currentItem.counter) {
                    removeItem(currentItem)
                }
            }
        }
    }

    private val diffCallback = object : DiffUtil.ItemCallback<ZekerModel>() {
        override fun areItemsTheSame(oldItem: ZekerModel, newItem: ZekerModel): Boolean {
            return oldItem.zeker == newItem.zeker
        }

        override fun areContentsTheSame(oldItem: ZekerModel, newItem: ZekerModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EveningAzkarAdapter.ViewHolder {
        val view = MorningItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EveningAzkarAdapter.ViewHolder, position: Int) {

        val currentItem = differ.currentList[position]
        holder.bind(currentItem)

        holder.binding.zekertext.text = currentItem.zeker

    }

    private fun removeItem(currentItem: ZekerModel) {
        val newList = differ.currentList.toMutableList()
        newList.remove(currentItem)
        differ.submitList(newList)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}