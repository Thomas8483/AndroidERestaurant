package fr.isen.jaxel.androiderestaurant


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import fr.isen.jaxel.androiderestaurant.databinding.ActivityCategorieBinding
import org.json.JSONObject


class ActivityCategorie : AppCompatActivity() {

    private lateinit var binding: ActivityCategorieBinding
    private var itemsList = ArrayList<String>()
    private lateinit var myCategoryAdapter : AdapterDish

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val extras = intent.extras
        var menuName = extras?.getString("categoryName")
        var menuList = intent.getStringArrayListExtra("List_Meal")

        if (menuName != null && menuList != null) {
            supportActionBar?.title = menuName

            myCategoryAdapter = AdapterDish(menuList){
                val intent = Intent(this@ActivityCategorie, ActivityCategorie::class.java)
                intent.putExtra("categoryName", "Entree")
                startActivity(intent);
            }
            val layoutManager = LinearLayoutManager(applicationContext)
            binding.RecyclerView.layoutManager = layoutManager
            binding.RecyclerView.adapter = myCategoryAdapter
        }

        val queue = Volley.newRequestQueue(this)
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject,
            Response.Listener { response ->
            },
            Response.ErrorListener { error ->
            })
        queue.add(jsonRequest)
    }
}
