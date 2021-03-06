package br.com.mateus.scrumcontrol.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.mateus.scrumcontrol.R
import kotlinx.android.synthetic.main.activity_forget_password.*

class ForgetPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        tb_forget_password.setOnClickListener { finish() }
        btn_send_forget_password.setOnClickListener {
            Toast.makeText(this, "E-mail enviado com sucesso!", Toast.LENGTH_SHORT).show()
            finish() }

    }
}
