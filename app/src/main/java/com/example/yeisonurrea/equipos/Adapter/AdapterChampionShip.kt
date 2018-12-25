package com.example.yeisonurrea.equipos.Adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.yeisonurrea.equipos.Model.Championship
import com.example.yeisonurrea.equipos.R

class AdapterChampionShip(private var activity: Activity, private var items: MutableList<Championship>): BaseAdapter() {
    private class ViewHolder(row: View?) {
        var txtNameChamp: TextView? = null
        var txtIdChamp: TextView? = null
        var txtIdUser: TextView? = null

        init {
            this.txtNameChamp = row?.findViewById(R.id.cusListChamp_name) as TextView?
            this.txtIdChamp = row?.findViewById(R.id.cusListChamp_idChamp) as TextView?
            this.txtIdUser = row?.findViewById(R.id.cusListChamp_idUser) as TextView?
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View?
        val viewHolder: ViewHolder
        if (convertView == null) {
            val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.custom_list_camp, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var champ = items[position]
        viewHolder.txtNameChamp?.text = champ.nameChampionShip
        viewHolder.txtIdChamp?.text = champ.idChampionShip.toString()
        viewHolder.txtIdUser?.text = champ.idUser.toString()

        return view as View
    }

    override fun getItem(i: Int): Championship {
        return items[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}