package com.islamey.hamza.wazaker.ui.AzkarListFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.islamey.hamza.wazaker.domain.Models.AzkarListModel
import com.islamey.hamza.wazaker.ui.OnItemListener
import com.islamey.wazkar.R

class AzkarListAdapter(private val azkar_modelList: List<AzkarListModel>) :
    RecyclerView.Adapter<AzkarListAdapter.ViewHolder>() {
    private var listener: OnItemListener? = null
    fun setListner(listener: OnItemListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(R.layout.simple_cell, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name) = azkar_modelList[position]
        holder.title.text = name
    }

    override fun getItemCount(): Int {
        return azkar_modelList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView

        init {
            title = itemView.findViewById(R.id.tvTitle)
            itemView.setOnClickListener {
                listener!!.onItemCLicked(
                    adapterPosition
                )
            }
        }
    }
}