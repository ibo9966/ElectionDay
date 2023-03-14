package com.example.secimgunu

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tarih.*
import java.time.Duration
import java.time.LocalDateTime
import java.time.Month
import java.util.*

class TarihActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarih)

        toolbarTarih.title="2023 Genel Seçimleri"
        toolbarTarih.subtitle="Cumhurbaşkanlığı Seçimi"
        setSupportActionBar(toolbarTarih)

        buttonGeriDonTarih.setOnClickListener {

            val intent= Intent(this@TarihActivity,MainActivity::class.java)
            startActivity(intent)
        }

        val electionDay = LocalDateTime.of(2023, Month.MAY, 14, 5, 0, 0) // seçim günü tarihini buradan belirleyebilirsiniz
        val timer = object: CountDownTimer(Duration.between(LocalDateTime.now(), electionDay).toMillis(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val diff = Duration.ofMillis(millisUntilFinished)
                val diffInDays = diff.toDays()
                val diffInHours = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    diff.toHoursPart()
                } else {
                    TODO("VERSION.SDK_INT < S")
                }
                val diffInMinutes = diff.toMinutesPart()
                val diffInSeconds = diff.toSecondsPart()

                val timeLeftDaysTextView = findViewById<TextView>(R.id.textViewKalanGun)
                timeLeftDaysTextView.text = "\n$diffInDays \ngün\n"

                val timeLeftHoursTextView = findViewById<TextView>(R.id.textViewKalanSaat)
                timeLeftHoursTextView.text = "\n$diffInHours \nsaat\n"

                val timeLeftMinutesTextView = findViewById<TextView>(R.id.textViewKalanDakika)
                timeLeftMinutesTextView.text = "\n$diffInMinutes \ndakika\n"

                val timeLeftSecondsTextView = findViewById<TextView>(R.id.textViewKalanSaniye)
                timeLeftSecondsTextView.text = "\n$diffInSeconds \nsaniye\n"
            }

            override fun onFinish() {
                val timeLeftTextView = findViewById<TextView>(R.id.textViewKalanGun)
                timeLeftTextView.text = "Seçim günü geldi!"
            }
        }

        timer.start()


    }
}