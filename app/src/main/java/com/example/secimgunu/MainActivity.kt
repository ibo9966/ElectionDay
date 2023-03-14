package com.example.secimgunu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonSayac.setOnClickListener{

            val intent=Intent(this@MainActivity,TarihActivity::class.java)
            startActivity(intent)

        }
        buttonAday.setOnClickListener{

            val intent=Intent(this@MainActivity,AdayActivity::class.java)
            startActivity(intent)

        }
        buttonAnket.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.Anket)))
            startActivity(intent)
        }
    }
}