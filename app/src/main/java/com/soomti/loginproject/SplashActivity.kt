package com.soomti.loginproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.soomti.loginproject.Model.User
import io.realm.Realm
import io.realm.RealmConfiguration



class SplashActivity : AppCompatActivity() {
    private var TIME: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Initialize the Handler
        // db 초기화

        Realm.init(this);

        Handler().postDelayed({
            val intent: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, TIME)


    }

}
