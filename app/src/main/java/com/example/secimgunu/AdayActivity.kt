package com.example.secimgunu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_aday.*

class AdayActivity : AppCompatActivity() {
    val AdayListesi=ArrayList<Adaylar>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aday)
        AdayListesi.add(Adaylar("Muharrem İnce",R.mipmap.muharrem,getString(R.string.muharrem)))
        AdayListesi.add(Adaylar("Kemal Kılıçdaroğlu",R.mipmap.kilic,getString(R.string.kilic)))
        AdayListesi.add(Adaylar("Recep Tayyip Erdoğan",R.mipmap.recep,getString(R.string.recep)))
        AdayListesi.add(Adaylar("Sinan Ogan",R.mipmap.sinan,getString(R.string.sinan)))

        val adapter= AdayAdapter(AdayListesi)
        val intent = Intent(this,AdayDetayActivity::class.java)
        adapter.setOnItemClickListener(object : AdayAdapter.OnItemClickListener{
            override fun onItemClick(myObject: Adaylar?) {
                val mBundle = Bundle()
                mBundle.putString("data", myObject?.ad)
                myObject?.adayid?.let { mBundle.putInt("image_id", it) }
                myObject?.adayInfo?.let { mBundle.putString("string_info",it) }
                intent.putExtras(mBundle)
                startActivity(intent)
            }
        })
        rvAdaylar.adapter=adapter

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation= LinearLayoutManager.VERTICAL
        layoutManager.scrollToPosition(0)
        rvAdaylar.layoutManager = layoutManager
        rvAdaylar.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
    }
}