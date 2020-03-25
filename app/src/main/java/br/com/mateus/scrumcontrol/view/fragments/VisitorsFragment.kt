package br.com.mateus.scrumcontrol.view.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.viewmodel.VisitorsViewModel
import kotlinx.android.synthetic.main.visitors_fragment.*

class VisitorsFragment : Fragment() {

    companion object {
        fun newInstance() = VisitorsFragment()
    }

    private lateinit var viewModel: VisitorsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.visitors_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VisitorsViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("key_title") ?: "NAO VEIO"
        if (title == "VISITANTE TEMPORÁRIO/DELIVERY") {
            tv_title_control.text = title
            tv_tv_description_visitors.setText(R.string.tv_description_visitors)
            tv_et_name_visitors.text = "Nome e Sobrenome ou Entrega"
            cb_visitors.visibility = View.GONE
            btn_confirm_visitors.setOnClickListener {
                Toast.makeText(context,"Visitante Temporário cadastrado!", Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
            }

        } else if (title == "VISITANTE PERMANENTE") {
            tv_title_control.text = title
            tv_tv_description_visitors.setText(R.string.tv_description_visitors_permanent)
            tv_et_name_visitors.text = "Nome e Sobrenome"
            cl_date.visibility = View.GONE
            btn_confirm_visitors.setOnClickListener {
                Toast.makeText(context,"Visitante Permanente cadastrado!", Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
            }

        } else if (title == "PRESTADOR DE SERVIÇOS") {
            tv_title_control.text = title
            tv_tv_description_visitors.setText(R.string.tv_description_visitors_services)
            tv_et_name_visitors.text = "Nome e Sobrenome"
            cb_visitors.visibility = View.GONE
            btn_confirm_visitors.setOnClickListener {
                Toast.makeText(context,"Prestador de Serviços cadastrado!", Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
            }
        }

        tb_visitors.setNavigationOnClickListener { activity?.onBackPressed() }
    }

}
