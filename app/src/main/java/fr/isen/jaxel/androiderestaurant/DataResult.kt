package fr.isen.jaxel.androiderestaurant

import com.google.gson.annotations.SerializedName
import fr.isen.jaxel.androiderestaurant.model.Data


data class DataResult (

  @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

)