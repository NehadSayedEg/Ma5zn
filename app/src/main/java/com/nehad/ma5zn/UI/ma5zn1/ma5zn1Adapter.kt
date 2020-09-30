package com.nehad.ma5zn.UI.ma5zn1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nehad.ma5zn.Data.entities.Item
import com.nehad.ma5zn.R
import kotlinx.android.synthetic.main.item.view.*


 public class ma5zn1Adapter:RecyclerView.Adapter<ma5zn1Adapter.ma5zn1ViewHolder>() {
     public var itemsList: ArrayList<Item> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ma5zn1ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ma5zn1ViewHolder(view)

    }
    fun setItems(item: ArrayList<Item>) {
        itemsList = item
    }

    override fun onBindViewHolder(holder: ma5zn1ViewHolder, position: Int) {
        val ma5zn1List =  itemsList[position]
        holder.itemView.tvCode.text =ma5zn1List.code
        holder.itemView.tvAmount.text ="${ma5zn1List.qty}"

        holder.itemView.ivDelete.setOnClickListener {
            //viewModel.delete(ma5zn1List)
        }

        holder.itemView.ivPlus.setOnClickListener {
            ma5zn1List.qty++
            //viewModel.upsert(ma5zn1List)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(ma5zn1List.qty > 0){
                ma5zn1List.qty--
                //viewModel.upsert(ma5zn1List)
            }

        }

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
    inner class ma5zn1ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


}