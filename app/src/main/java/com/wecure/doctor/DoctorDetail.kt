package com.wecure.doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DoctorDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_detail)
        supportActionBar?.hide()
    }
}