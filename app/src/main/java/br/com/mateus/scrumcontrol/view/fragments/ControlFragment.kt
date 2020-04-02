package br.com.mateus.scrumcontrol.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.viewmodel.ControlViewModel
import kotlinx.android.synthetic.main.control_fragment.*

class ControlFragment : Fragment() {

    companion object {
        fun newInstance() = ControlFragment()
    }

    private lateinit var viewModel: ControlViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.control_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ControlViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_temporary.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_title", "VISITANTE TEMPORÁRIO/DELIVERY")
            findNavController().navigate(R.id.visitorsFragment, bundle) }

        btn_permanent.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_title", "VISITANTE PERMANENTE")
            findNavController().navigate(R.id.visitorsFragment, bundle) }

        btn_provider_services.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_title", "PRESTADOR DE SERVIÇOS")
            findNavController().navigate(R.id.visitorsFragment, bundle) }

        tb_control.setNavigationOnClickListener { activity?.onBackPressed() }

        mcv_btn_authorizations.setOnClickListener { findNavController().navigate(R.id.authorizationsFragment) }
    }

}
