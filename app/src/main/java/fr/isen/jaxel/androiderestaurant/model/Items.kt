package fr.isen.jaxel.androiderestaurant.model

import com.google.gson.annotations.SerializedName


data class Items (

  @SerializedName("id"            ) var id          : String?                = null,
  @SerializedName("name_fr"       ) var nameFr      : String?                = null,
  @SerializedName("name_en"       ) var nameEn      : String?                = null,
  @SerializedName("id_category"   ) var idCategory  : String?                = null,
  @SerializedName("categ_name_fr" ) var categNameFr : String?                = null,
  @SerializedName("categ_name_en" ) var categNameEn : String?                = null,
  @SerializedName("images"        ) var images      : ArrayList<String>      = arrayListOf(),
  @SerializedName("ingredients"   ) var ingredients : ArrayList<Ingredients> = arrayListOf(),
  @SerializedName("prices"        ) var prices      : ArrayList<Prices>      = arrayListOf()

):java.io.Serializable