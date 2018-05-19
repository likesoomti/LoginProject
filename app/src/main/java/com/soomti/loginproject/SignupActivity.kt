package com.soomti.loginproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.soomti.loginproject.Model.User
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_signup.*
import java.lang.reflect.Member
import java.util.regex.Matcher
import java.util.regex.Pattern
import android.text.Editable
import android.text.TextWatcher
import android.R.id.edit



class SignupActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val check_email ="[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\\\w+\\\\.)+\\\\w+\$";

        val check_pwd = Pattern.compile("^(?=.*[0-9])(?=.*[a-z]).{8,16}$")

        var flag = true

        createButton.setOnClickListener{
            Log.i("email",email.text.toString())

            val isMatchPWD = check_pwd.matcher(password.text.toString())

            if (!Pattern.matches(check_email,email.text.toString())) {
                flag = false
                Toast.makeText(this,"이메일 정확히 지켜주세요",Toast.LENGTH_LONG).show();
            }
            if(identify.text.length < 5) {
                flag = false
                Toast.makeText(this,"아이디 길이가 짧습니다.",Toast.LENGTH_LONG).show();
            }
            if(!isMatchPWD.find()) {
                flag = false
                Toast.makeText(this,"비밀번호 정확히 지켜주세요",Toast.LENGTH_LONG).show();
            }

            if(flag == true){
                // 화면 넘기기

                Realm.getDefaultInstance().use { realm ->
                    realm.executeTransaction {
                        val member = User()
                        member.identify = identify.text.toString()
                        member.email = email.text.toString()
                        member.password = password.text.toString()

                        realm.copyToRealm(member)
                    }
                }
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }

        }



    }
}
