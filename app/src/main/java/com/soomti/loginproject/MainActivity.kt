package com.soomti.loginproject

import com.soomti.loginproject.Model.User
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var email: String? = null
    var password: String? = null
    var name :String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 인스턴스 가져오기
        Realm.getDefaultInstance().use { realm ->

            realm.where(User::class.java).findAll().forEach {
                this.email = it.email
                this.password = it.password
                this.name = it.identify

                Log.d("eamil", "${it.email}")
                Log.d("password", "${it.password}")
                Log.d("id", "${it.identify}")
            }
        }

            // 로그인 링크 -> 로그인 성공 화면
        loginButton.setOnClickListener{

            // 인스턴스 가져오기
            Realm.getDefaultInstance().use { realm ->

                val temp = realm.where(User::class.java).equalTo("name", login_email.text.toString()).findFirst()
                if (temp != null) {
                    if(temp.password == login_password.text.toString()) {
                        val loginIntent = Intent(this, HomeActivity::class.java)
                        loginIntent.putExtra("email", email)
                        loginIntent.putExtra("password", password)
                        startActivity(loginIntent)
                        finish();
                    }
                    else {
                        Toast.makeText(this, "아이디와 비밀번호를 확인해 주세요", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        // 1. 회원가입 링크
        movesignup.setOnClickListener{
            val signUpIntent = Intent(this, SignupActivity::class.java)
            startActivity(signUpIntent)
        }

    }
}
