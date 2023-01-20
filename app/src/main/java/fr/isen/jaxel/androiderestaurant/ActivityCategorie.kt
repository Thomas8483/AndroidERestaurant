package fr.isen.jaxel.androiderestaurant


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.jaxel.androiderestaurant.databinding.ActivityCategorieBinding
import org.json.JSONObject


class ActivityCategorie : AppCompatActivity() {

    private lateinit var binding: ActivityCategorieBinding
    private lateinit var category: String
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
        loadDishesFromAPI()
    }

    private fun loadDishesFromAPI(){
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val jsonObject = JSONObject()
        jsonObject.put("id_shop", "1")
        val jsonRequest = JsonObjectRequest(
            Request.Method.POST, url, jsonObject,
            {
                Log.w("ActivityCategorie", "response : $it")
                handleAPIData(it, toString())
            },
            {
                Log.w("ActivityCategorie", "error : $it")
            })
        Volley.newRequestQueue(this).add(jsonRequest)
    }


    private fun handleAPIData(jsonObject: JSONObject, data: String){
        var dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategory = dishesResult.data.firstOrNull { it.nameFr == category}
        val adapter = binding.categoryList.adapter as CategoryAdapter
        adapter.refreshList(dishCategory)
    }
}
