package br.com.mateus.scrumcontrol.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.commom.Info
import br.com.mateus.scrumcontrol.view.adapter.InfoAdapter
import br.com.mateus.scrumcontrol.viewmodel.InfoViewModel
import kotlinx.android.synthetic.main.info_fragment.*

class InfoFragment : Fragment() {

    companion object {
        fun newInstance() = InfoFragment()
    }

    private lateinit var viewModel: InfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(InfoViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = rv_info
        recyclerView.adapter = InfoAdapter(infos(), context!!)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

    }

    private fun infos() : List<Info>{
        return listOf(
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info)),
            Info("Regras do Condomínio", getString(R.string.description_item_info))
        )
    }

}
