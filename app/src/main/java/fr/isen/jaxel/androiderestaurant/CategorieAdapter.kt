package fr.isen.jaxel.androiderestaurant
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class CategorieAdapter(var myArrayList: ArrayList<String>) : RecyclerView.Adapter<CategorieAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contentName: TextView = view.findViewById(R.id.content_name)
        val contentAllergen : TextView = view.findViewById(R.id.content_allergen)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = myArrayList[position]
        holder.contentName.text = item
        holder.contentAllergen.text = item + "---"
    }

    override fun getItemCount(): Int = myArrayList.size
}