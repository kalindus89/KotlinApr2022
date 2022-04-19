package com.kotlin.testkotlinapr2022.project1.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.testkotlinapr2022.R
import com.kotlin.testkotlinapr2022.project1.models.AllResultsModel
import com.kotlin.testkotlinapr2022.project1.models.BasicDataModel
import com.squareup.picasso.Picasso

class GithubRecyclerAdapter : RecyclerView.Adapter<GithubRecyclerAdapter.MyViewHolder>(){


    var items = ArrayList<BasicDataModel>()

    fun setUpdatedData(items:ArrayList<BasicDataModel>){
        this.items=items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.github_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


      holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val avater =itemView.findViewById<ImageView>(R.id.avater)
        val tvTitle =itemView.findViewById<TextView>(R.id.tvTitle)
        val tvDesc =itemView.findViewById<TextView>(R.id.tvDesc)

        fun bind(data:BasicDataModel){

            tvTitle.text=data.name
            tvDesc.text=data.description

            Picasso.get().load(data.owner.avatar_url).into(avater)

        }

    }
}