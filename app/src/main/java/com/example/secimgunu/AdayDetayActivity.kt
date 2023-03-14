package com.example.secimgunu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_aday_detay.*
import kotlinx.android.synthetic.main.activity_main.*

class AdayDetayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aday_detay)

        textViewDetay.text=intent.getStringExtra("data")
        imageView3.setImageResource(intent.getIntExtra("image_id",0))

        buttonGeriDonAdayDetay.setOnClickListener {

            onBackPressed()

        }

        buttonAbout.setOnClickListener {
            val url = intent.getStringExtra("string_info")
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

    }
}