package fr.isen.jaxel.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
//import android.widget.Button
import fr.isen.jaxel.androiderestaurant.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val myIntent = Intent(this@HomeActivity, SelectorActivity::class.java)

        binding.buttonEntrees.setOnClickListener {
            Toast.makeText(this, "Entrées cliqué", Toast.LENGTH_SHORT).show()
            myIntent.putExtra("menu", "starters")
            startActivity(myIntent)
        }

        binding.buttonPlats.setOnClickListener {
            Toast.makeText(this, "Plats cliqué", Toast.LENGTH_SHORT).show()
            myIntent.putExtra("menu", "Plats")
            startActivity(myIntent)
        }

        binding.buttonDesserts.setOnClickListener {
            Toast.makeText(this, "Desserts cliqué", Toast.LENGTH_SHORT).show()
            myIntent.putExtra("menu", "desserts")
            startActivity(myIntent)
        }
    }
}