package com.example.room.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.Data.DataClass
import com.example.room.R
import kotlinx.android.synthetic.main.item_recyc.view.*

class Room(private val  listener: ItemListener):RecyclerView.Adapter<Room.VHolder>() {

    private var data = arrayListOf<DataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyc,parent,false)
        return VHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    fun update (data : List<DataClass>){
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    class VHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(data: DataClass, listener: ItemListener){
            itemView.tvFirst.text=data.etFirst
            itemView.tvSecond.text=data.etSecond
        }
    }
}