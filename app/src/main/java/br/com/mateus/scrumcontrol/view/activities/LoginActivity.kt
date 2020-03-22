package br.com.mateus.scrumcontrol.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mateus.scrumcontrol.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tv_forget_password.setOnClickListener { forgetPassword() }
        btn_register.setOnClickListener { register() }
        btn_login.setOnClickListener { login() }

    }

    fun forgetPassword(){
        val intent = Intent(this, ForgetPasswordActivity::class.java)
        startActivity(intent)
    }

    fun register(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun login(){
        val intent = Intent(this, NavHostActivity::class.java)
        startActivity(intent)
    }
}
