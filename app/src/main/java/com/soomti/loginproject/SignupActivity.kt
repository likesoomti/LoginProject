package com.soomti.loginproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    val email by lazy {
        findViewById(R.id.email) as EditText
    }
    val password by lazy {
        findViewById(R.id.password) as EditText
    }
    val password2 by lazy {
        findViewById(R.id.passwordMore) as EditText
    }
    val createButton by lazy {
        findViewById(R.id.createButton) as Button
    }
    // 이메일 정규표현식
    fun emailCheck(email:String):Boolean {
        //val regex = "/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}\$/i;".toRegex()
        //return !regex.containsMatchIn(email)

        return !(email.contains("@"))
    }
    fun nullCheck(str:String) :Boolean {
        return (str=="")
    }
    // 비밀번호 같은지 체크
    fun passwordCheck(password1:String,password2:String):Boolean{
        return !(password1 == password2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var flag = true


        createButton.setOnClickListener{
            var email = email.text.toString()
            var password = password.text.toString()
            var password2 = password2.text.toString()
            //1. 이메일 정규표현식이 적합하지 않으면
            if (emailCheck(email)) {
                Toast.makeText(this,"이메일 표현이 맞지 않습니다.",Toast.LENGTH_LONG).show()
                flag = false

            }else if (nullCheck(email) || nullCheck(password) || nullCheck(password2)) {
                Toast.makeText(this,"공란이 있습니다.",Toast.LENGTH_LONG).show()
                flag = false
            }else if (passwordCheck(password,password2)) {
                Toast.makeText(this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_LONG).show()
                flag = false
            }else {
                flag = true
            }

            if(flag == true){
                // 화면 넘기기
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
            }

        }



    }
}
