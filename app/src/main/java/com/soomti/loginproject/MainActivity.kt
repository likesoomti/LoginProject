package com.soomti.loginproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val pref = this.getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        editor.putString("id","soomti@likelion.org")
        editor.putString("pwd","qwer1234")

        editor.commit();


            // 로그인 링크 -> 로그인 성공 화면
        loginButton.setOnClickListener{
            val email = login_email.text.toString()
            val password = login_password.text.toString()
            if ((email== pref.getString("id","") && password == pref.getString("pwd",""))) {
                val loginIntent = Intent(this, HomeActivity::class.java)
                loginIntent.putExtra("email", email )
                loginIntent.putExtra("password", password )
                startActivity(loginIntent)

            }else {
                Toast.makeText(this,"아이디와 비밀번호를 확인해 주세요",Toast.LENGTH_LONG).show()
            }

        }
        // 1. 회원가입 링크
        movesignup.setOnClickListener{
            val signUpIntent = Intent(this, SignupActivity::class.java)
            startActivity(signUpIntent)
        }

    }
}
