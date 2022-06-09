package com.example.listviewimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.listaspinnericon.R
import com.example.listaspinnericon.databinding.ActivityResultBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val valoresLenguaje = mutableListOf<Lenguaje>()
        valoresLenguaje.add(Lenguaje("C", "Lenguaje Procedural", R.drawable._138993))
        valoresLenguaje.add(Lenguaje("Python", "Lenguaje Genérico", R.drawable._138993))
        valoresLenguaje.add(Lenguaje("Kotlin", "Lenguaje Móviles", R.drawable._138993))
        val myAdaptadorCustom = LenguajesArrayAdapter(this, R.layout.item_lenguaje, valoresLenguaje)
        binding.listview.adapter = myAdaptadorCustom
        //binding.listview.choiceMode = ListView.CHOICE_MODE_SINGLE
        binding.listview.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        binding.listview.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int,
                                                  id: Long ->
            val elemento = myAdaptadorCustom.getItem(position)?.nombre.toString()
            Toast.makeText(this, elemento, Toast.LENGTH_SHORT).show()
        }

        binding.listview.setOnItemLongClickListener { parent: AdapterView<*>, view: View, pos: Int,
                                                      id: Long ->
            Toast.makeText(parent.context, pos.toString(), Toast.LENGTH_LONG).show()
            true
        }
    }
}
