package br.com.mateus.scrumcontrol.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.viewmodel.AboutViewModel
import kotlinx.android.synthetic.main.about_fragment.*

class AboutFragment : Fragment() {

    companion object {
        fun newInstance() = AboutFragment()
    }

    private lateinit var viewModel: AboutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.about_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AboutViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*Aqui recebe o valor do fragment que está passando, posso alterar o titulo e esconder itens*/
        val title = arguments?.getString("key_about") ?: "NAO VEIO"
        if (title == "SOBRE") {
            tv_title_about.text = title

        } else if (title == "POLÍTICA DE PRIVACIDADE") {
            tv_title_about.text = title


        } else if (title == "TERMOS DE USO") {
            tv_title_about.text = title
        }

        tb_about.setNavigationOnClickListener { activity?.onBackPressed() }
    }

}
