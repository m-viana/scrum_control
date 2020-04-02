package br.com.mateus.scrumcontrol.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        btn_authorize.setOnClickListener { findNavController().navigate(R.id.controlFragment)}
        btn_contact.setOnClickListener { findNavController().navigate(R.id.contactFragment)}
    }

}

/* 1 forma
* btn_authorize.setOnClickListener { findNavController().navigate(R.id.controlFragment) }*/

/* 2 forma - para passar valor
* btn_authorize.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("CHAVE", "TESTE")
            findNavController().navigate(R.id.controlFragment, bundle)
        }*/
