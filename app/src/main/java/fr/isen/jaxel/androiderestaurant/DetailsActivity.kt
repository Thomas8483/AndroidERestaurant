package fr.isen.jaxel.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        //Bouton Retour
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("title")
        supportActionBar?.title = title
    }

    //Fonction retour
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}