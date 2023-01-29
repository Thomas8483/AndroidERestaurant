package fr.isen.jaxel.androiderestaurant

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.jaxel.androiderestaurant.model.Items
import com.squareup.picasso.Picasso
import fr.isen.jaxel.androiderestaurant.model.DataResult

internal class DishAdapter(private var myArrayList: ArrayList<Items>, val onItemClickListener: () -> Unit) : RecyclerView.Adapter<DishAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishTitle: TextView = view.findViewById(R.id.dishTitle)
        val contentImage: ImageView = view.findViewById(R.id.image_meal)
        val dishPrice: TextView = view.findViewById(R.id.dishPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = myArrayList[position]
        holder.dishTitle.text = item.nameFr
        holder.dishPrice.text = item.prices[0].price
        if (item.images[0].isNotEmpty()) {
            Picasso.get().load(myArrayList[position].images[0])
                .placeholder(R.drawable.android_logo)
                .into(holder.contentImage)
        }
        holder.itemView.setOnClickListener {
            //onItemClickListener()
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("title", item.nameFr)
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = myArrayList.size

    @SuppressLint("NotifyDataSetChanged")
    fun refreshList(dishFromAPI: ArrayList<Items>) {
        myArrayList = dishFromAPI
        notifyDataSetChanged()
    }
}