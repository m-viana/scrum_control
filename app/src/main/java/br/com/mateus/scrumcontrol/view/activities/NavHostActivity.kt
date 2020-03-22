package br.com.mateus.scrumcontrol.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import br.com.mateus.scrumcontrol.R
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_nav_host.*


class NavHostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_host)
        setUpNavigation()

        /*Mudar cor do StatusBar*/
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary))

    }

    /*Função para add cada fragment ao menu navigation*/
    fun setUpNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_home) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottomNavigation,
            navHostFragment!!.navController
        )
    }
}
