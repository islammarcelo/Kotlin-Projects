package com.example.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_detials.*

class AnimalDetialsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detials)

        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val des = bundle?.getString("des")
        val image = bundle!!.getInt("image")
        animal_details_image.setImageResource(image)
        name_details.text = name
        des_detials.text = des

    }
}
