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
import fr.isen.jaxel.androiderestaurant.databinding.ActivityCategoryBinding
import fr.isen.jaxel.androiderestaurant.model.DataResult
import fr.isen.jaxel.androiderestaurant.model.Items
import org.json.JSONObject


class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding
    private var itemsList = ArrayList<Items>()
    private lateinit var category: String
    private lateinit var myCategoryAdapter : DishAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = intent.getStringExtra("categoryName") ?: ""
        this.title=category

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val menuName = intent.getStringExtra("categoryName") ?: ""
        val menuList = intent.getStringArrayListExtra("List_Meal")

        if (menuList != null) {
            supportActionBar?.title = menuName

            myCategoryAdapter = DishAdapter(itemsList){
                val intent = Intent(this, CategoryActivity::class.java)
                intent.putExtra("categoryName", "Entrées")
                startActivity(intent)
            }
            val layoutManager = LinearLayoutManager(applicationContext)
            binding.categoryList.layoutManager = layoutManager
            binding.categoryList.adapter = myCategoryAdapter

            binding.categoryList.layoutManager = LinearLayoutManager(this)
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
                Log.w("CategoryActivity", "response : $it")
                handleAPIData(it.toString())
            },
            {
                Log.w("CategoryActivity", "error : $it")
            })
        Volley.newRequestQueue(this).add(jsonRequest)
    }

    private fun handleAPIData(data: String){
        val dishesResult = Gson().fromJson(data, DataResult::class.java)
        val dishCategory = dishesResult.data.firstOrNull { it.nameFr == category }
        val adapter = binding.categoryList.adapter as DishAdapter
        adapter.refreshList(dishCategory?.items as ArrayList<Items>)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}
