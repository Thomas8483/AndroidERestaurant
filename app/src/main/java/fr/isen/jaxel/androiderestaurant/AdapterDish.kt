package fr.isen.jaxel.androiderestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class AdapterDish(var myArrayList: ArrayList<String>, val onItemClickListener: () -> Unit) : RecyclerView.Adapter<AdapterDish.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentName: TextView = view.findViewById(R.id.content_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = myArrayList[position]
        holder.contentName.text = item
        holder.itemView.setOnClickListener {
            onItemClickListener()
        }
    }

    override fun getItemCount(): Int = myArrayList.size
}