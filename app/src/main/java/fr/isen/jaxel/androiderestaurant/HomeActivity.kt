package fr.isen.jaxel.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun EntreesBtnOnClick(view: View) {
        Toast.makeText(this, "Entrées cliqué", Toast.LENGTH_SHORT).show();
        val gameActivityIntent = Intent(this@HomeActivity, SelectorActivity::class.java);
        startActivity(gameActivityIntent);
    }

    fun PlatsBtnOnClick(view: View) {
        Toast.makeText(this, "Plats cliqué", Toast.LENGTH_SHORT).show();
    }
    fun DessertsBtnOnClick(view: View) {
        Toast.makeText(this, "Desserts cliqué", Toast.LENGTH_SHORT).show();
    }
}