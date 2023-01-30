package fr.isen.jaxel.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import fr.isen.jaxel.androiderestaurant.databinding.ActivityDetailsBinding
import fr.isen.jaxel.androiderestaurant.model.Items

class DetailsActivity : AppCompatActivity() {
    private lateinit var item: Items
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Récupération du plat
        item = intent.getSerializableExtra("detail") as Items

        //Bouton Retour
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Récupération du nom du plat
        val title = item.nameFr

        //Affichage du nom du plat
        supportActionBar?.title = title

        val ingredients = item.ingredients

        var compteur = 0

        if (item.ingredients.isNotEmpty()){
            val ingredientsString = StringBuilder()
            ingredients.forEach { ingredients ->
                ingredientsString.append(ingredients.nameFr)
                ingredientsString.append("\n")
            }
            binding.ingredients.text = ingredientsString

            binding.plusButton.setOnClickListener {
                compteur++
                binding.quantity.text = Editable.Factory.getInstance().newEditable(compteur.toString())
                val addition = compteur * item.prices[0].price?.toDouble()!!
                binding.addition.text = addition.toString()
            }

            binding.lessButton.setOnClickListener {
                compteur--
                binding.quantity.text = Editable.Factory.getInstance().newEditable(compteur.toString())
                val addition = compteur * item.prices[0].price?.toDouble()!!
                binding.addition.text = addition.toString()
            }

            binding.quantity.text = compteur.toString()

        }
    }

    //Fonction retour
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}