package br.com.mateus.scrumcontrol.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_change_password.setOnClickListener { findNavController().navigate(R.id.changePasswordFragment) }
        tv_contact_profile.setOnClickListener { findNavController().navigate(R.id.contactFragment) }

        tv_about.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_about", "SOBRE")
            findNavController().navigate(R.id.aboutFragment, bundle) }

        tv_privacy_policy.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_about", "POLÍTICA DE PRIVACIDADE")
            findNavController().navigate(R.id.aboutFragment, bundle) }

        tv_terms_of_use.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key_about", "TERMOS DE USO")
            findNavController().navigate(R.id.aboutFragment, bundle) }
    }


}
