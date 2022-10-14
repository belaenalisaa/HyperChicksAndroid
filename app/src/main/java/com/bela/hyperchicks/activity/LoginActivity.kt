package com.bela.hyperchicks.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bela.hyperchicks.R
import com.bela.hyperchicks.helper.SharedPref
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    lateinit var s:SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        s = SharedPref(this)

        btn_Masuk.setOnClickListener {
            s.setStatusLogin(true)
    }
}



}
