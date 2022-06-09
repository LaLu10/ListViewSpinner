package com.example.listviewimage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listaspinnericon.R

class Lenguaje (
    var nombre:String,
    var description:String,
    var icon:Int)

class LenguajesArrayAdapter(
    context: Context?,
    resource: Int,
    objects:  List<Lenguaje>?
): ArrayAdapter<Lenguaje>(context!!,resource,objects!!){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view: View= convertView?:LayoutInflater.from(this.context).inflate(R.layout.item_lenguaje,parent,false)
        val tvNombre= view.findViewById<TextView>(R.id.etNombre)
        val tvDesc= view.findViewById<TextView>(R.id.editTextTextPersonName)
        val ivIcono= view.findViewById<ImageView>(R.id.spinner)
        getItem(position)?.let {
            tvNombre.text=it.nombre
            tvDesc.text=it.description
            ivIcono.setImageResource(it.icon)
        }
        return view
    }
}
