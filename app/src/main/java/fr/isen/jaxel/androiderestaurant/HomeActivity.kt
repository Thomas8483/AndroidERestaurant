package fr.isen.jaxel.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.jaxel.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this@HomeActivity, CategoryActivity::class.java)

        binding.buttonEntrees.setOnClickListener {
            intent.putExtra("categoryName", "Entrées")
            val mealList = resources.getStringArray(R.array.entries_list).toList() as ArrayList<String>
            intent.putExtra("List_Meal", mealList)
            startActivity(intent)
        }

        binding.buttonPlats.setOnClickListener {
            intent.putExtra("categoryName", "Plats")
            val mealList = resources.getStringArray(R.array.main_courses_list).toList() as ArrayList<String>
            intent.putExtra("List_Meal", mealList)
            startActivity(intent)
        }

        binding.buttonDesserts.setOnClickListener {
            intent.putExtra("categoryName", "Desserts")
            val mealList = resources.getStringArray(R.array.desserts_list).toList() as ArrayList<String>
            intent.putExtra("List_Meal", mealList)
            startActivity(intent)
        }
    }
}