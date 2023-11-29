package com.islamey.hamza.wazaker.ui.EveningAzkarFragment


import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.islamey.hamza.wazaker.domain.Models.ZekerModel
import com.islamey.wazkar.databinding.MorningItemBinding

class EveningAzkarAdapter : RecyclerView.Adapter<EveningAzkarAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: MorningItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<ZekerModel>() {
        override fun areItemsTheSame(oldItem: ZekerModel, newItem: ZekerModel): Boolean {
            return oldItem.zeker == newItem.zeker
        }

        override fun areContentsTheSame(oldItem: ZekerModel, newItem: ZekerModel): Boolean {
            return oldItem == newItem
        }
    }

    var differ = AsyncListDiffer(this, diffCallback)

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
        var count = 0

        holder.binding.zekertext.text = currentItem.zeker
        holder.binding.copybtn.setOnClickListener {

            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, currentItem.zeker)
            sendIntent.type = "text/plain"
            val shareIntent = Intent.createChooser(sendIntent, null)
            it.context.startActivity(shareIntent)
        }


        holder.binding.plustext.text = count.toString()

        holder.binding.plusButton.setOnClickListener {
            count++
            holder.binding.plustext.text = count.toString()
            if (count >= currentItem.counter) {
                removeItem(currentItem)
            }
        }

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