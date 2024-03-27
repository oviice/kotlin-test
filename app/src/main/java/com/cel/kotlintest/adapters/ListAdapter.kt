package com.cel.kotlintest.adapters

import android.content.Context
import android.transition.CircularPropagation
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.cel.kotlintest.R
import com.cel.kotlintest.model.User

class ListAdapter(private val context: Context, private val dataList: List<User>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: ${dataList.get(position).organizationsUrl}")
        holder.name.text=dataList.get(position).organizationsUrl
        holder.image.load(dataList.get(position).avatarUrl){
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
            //transformations(CircleCropTransformation())
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(context,"Id: ${dataList[position].id}",Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var image: ImageView

        init {
            name = itemView.findViewById(R.id.name)
            image = itemView.findViewById(R.id.image)
        }
    }
}