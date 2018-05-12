package com.soomti.loginproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 검사 먼저
        if(intent.hasExtra("email")) {
            homeemail.text = intent.getStringExtra("email")
        }
    }
}
