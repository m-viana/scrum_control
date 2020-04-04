package br.com.mateus.scrumcontrol.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mateus.scrumcontrol.R
import br.com.mateus.scrumcontrol.commom.Info
import kotlinx.android.synthetic.main.item_adapter_info.view.*

class InfoAdapter(private val infos: List<Info>, private val context : Context) : RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.title_item_info
        val description = itemView.description_item_info

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_adapter_info, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return infos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info = infos[position]
        holder.title.text = info.title
        holder.description.text = info.description

    }

}

