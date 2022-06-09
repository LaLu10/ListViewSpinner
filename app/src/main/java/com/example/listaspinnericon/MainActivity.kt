package com.example.listaspinnericon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.listaspinnericon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun getSpinner(context: Context, spinner: Spinner, select:Array<String>, idValores:Int){
            val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(context, idValores,
                android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adaptador
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    select[0] = parent?.getItemAtPosition(position).toString()
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    select[0] = "Sin selección"
                }
            }
        }

    }
}