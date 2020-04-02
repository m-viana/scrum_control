package br.com.mateus.scrumcontrol.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.viewmodel.AuthorizationsViewModel
import kotlinx.android.synthetic.main.authorizations_fragment.*

class AuthorizationsFragment : Fragment() {

    companion object {
        fun newInstance() = AuthorizationsFragment()
    }

    private lateinit var viewModel: AuthorizationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.authorizations_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthorizationsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tb_authorizations.setNavigationOnClickListener { activity?.onBackPressed() }
    }

}
