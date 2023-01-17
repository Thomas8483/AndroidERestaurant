package fr.isen.jaxel.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.jaxel.androiderestaurant.databinding.ActivityMealListBinding

class MealListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealListBinding
    private var itemsList = ArrayList<String>()
    private lateinit var myCategoryAdapter : CategorieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val extras = intent.extras
        if (extras != null) {
            var value = extras.getString("menu")
            supportActionBar?.title = value
        }

        myCategoryAdapter = CategorieAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recycleView.layoutManager = layoutManager
        binding.recycleView.adapter = myCategoryAdapter
        prepareItems()

        binding.buttonBack.setOnClickListener {
            val myIntent = Intent(this@MealListActivity, HomeActivity::class.java)
            startActivity(myIntent)
        }
    }
    private fun prepareItems() {

        itemsList.add("Item 3")
        itemsList.add("Item 4")

        //itemsList = resources.getStringArray(R.array.Lines).toList() as ArrayList<String>


        Log.d("HUMAN", itemsList.toString())
        myCategoryAdapter.notifyDataSetChanged()
    }

}