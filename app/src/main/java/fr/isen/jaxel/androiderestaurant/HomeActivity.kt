package fr.isen.jaxel.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    //val button = findViewById<Button>(R.id)
    fun entreesBtnOnClick(view: View) {
        Toast.makeText(this, "Entrées cliqué", Toast.LENGTH_SHORT).show()
        val gameActivityIntent = Intent(this@HomeActivity, SelectorActivity::class.java)
        startActivity(gameActivityIntent);
    }

    fun platsBtnOnClick(view: View) {
        Toast.makeText(this, "Plats cliqué", Toast.LENGTH_SHORT).show()
    }
    fun dessertsBtnOnClick(view: View) {
        Toast.makeText(this, "Desserts cliqué", Toast.LENGTH_SHORT).show()
    }
}