package fr.isen.jaxel.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import fr.isen.jaxel.androiderestaurant.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this@HomeActivity, ActivityCategorie::class.java)

        binding.buttonEntrees.setOnClickListener(){
            //Toast.makeText(this,"Entrees button clicked", Toast.LENGTH_SHORT).show()
            intent.putExtra("categoryName", "Entrees")
            val mealList = resources.getStringArray(R.array.entries_list).toList() as ArrayList<String>
            intent.putExtra("List_Meal", mealList)
            startActivity(intent);
        }

        binding.buttonPlats.setOnClickListener(){
            //Toast.makeText(this,"Plats button clicked", Toast.LENGTH_SHORT).show()
            intent.putExtra("categoryName", "Entrees")
            val mealList = resources.getStringArray(R.array.main_courses_list).toList() as ArrayList<String>
            intent.putExtra("List_Meal", mealList)
            startActivity(intent);
        }

        binding.buttonDesserts.setOnClickListener(){
            //Toast.makeText(this,"Desserts button clicked", Toast.LENGTH_SHORT).show()
            intent.putExtra("categoryName", "Entrees")
            val mealList = resources.getStringArray(R.array.desserts_list).toList() as ArrayList<String>
            intent.putExtra("List_Meal", mealList)
            startActivity(intent);
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeActivity", "L'activité Home a été détruite")
    }
}