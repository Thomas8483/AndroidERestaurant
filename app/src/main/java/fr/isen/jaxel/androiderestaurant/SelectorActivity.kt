package fr.isen.jaxel.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.jaxel.androiderestaurant.databinding.ActivitySelectorBinding

class SelectorActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}