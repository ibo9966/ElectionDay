package com.example.secimgunu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdayAdapter(var AdayListesi:ArrayList<Adaylar>) : RecyclerView.Adapter<AdayAdapter.VHolder>() {

    private var itemClick : OnItemClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return VHolder(v)

    }
    fun setOnItemClickListener(listener: OnItemClickListener?) {
        itemClick = listener
    }
    interface OnItemClickListener {
        fun onItemClick(myObject: Adaylar?)
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        itemClick
        holder.tvAd.text = AdayListesi.get(position).ad
        holder.ivResim.setImageResource(AdayListesi.get(position).adayıd)

    }

    override fun getItemCount(): Int {
        return AdayListesi.size
    }
    inner class VHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivResim: ImageView
        var tvAd: TextView

        init {
            ivResim=itemView.findViewById(R.id.imageView2)
            tvAd=itemView.findViewById(R.id.textView3)
            itemView.setOnClickListener {
                if (itemClick != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        itemClick!!.onItemClick(AdayListesi!![position])
                    }
                }
            }
        }
    }
}