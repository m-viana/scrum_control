package br.com.mateus.scrumcontrol.view.fragments

import android.graphics.Color
import android.graphics.Typeface
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.contact_fragment.*
import org.w3c.dom.Text

class ContactFragment : Fragment() {

    companion object {
        fun newInstance() = ContactFragment()
    }

    private lateinit var viewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tb_contact.setNavigationOnClickListener { activity?.onBackPressed() }

        btn_contact.setOnClickListener {
            Toast.makeText(context, "Mensagem Enviada!", Toast.LENGTH_SHORT).show()
            activity?.onBackPressed()
        }

        /*Deixando um pedaço do texto colorido e negrito*/
        val styledString = SpannableString(
            getString(R.string.tv_description_contact)
        )
        styledString.setSpan(ForegroundColorSpan(resources.getColor(R.color.colorAccent)), 0, 17, 0)
        styledString.setSpan(StyleSpan(Typeface.BOLD), 0, 17, 0)
        tv_tv_description_visitors.text = styledString

    }

}
