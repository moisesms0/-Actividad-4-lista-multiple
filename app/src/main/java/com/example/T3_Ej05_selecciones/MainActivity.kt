package com.example.T3_Ej05_selecciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provincias = arrayOf(
            "Ávila",
            "Burgos",
            "León",
            "Palencia",
            "Salamanca",
            "Segovia",
            "Soria",
            "Valladolid",
            "Zamora"
        )

        // Enlazamos con los elementos de la interfaz
        val ListViewProvincias = findViewById<ListView>(R.id.provinceListView)
        val TextViewProvinciaSeleccionada = findViewById<TextView>(R.id.selectedProvinceTextView)

        //Declaramos un adaptador
        //Pasamos el contexto
        //El layout de la vista
        //El array que se va a mostrar
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, provincias)
        //val adapter = ArrayAdapter(this, R.layout.fila, provincias)
        ListViewProvincias.adapter = adapter

        // Usamos el modo de seleccion multiple
        ListViewProvincias.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        // Listener para el boton de confirmacion
        val confirmButton = findViewById<Button>(R.id.confirmButton)
        confirmButton.setOnClickListener {
            val provinciasSeleccionadas = mutableListOf<String>()
            val provinciasChecked = ListViewProvincias.checkedItemPositions

            for (i in 0 until ListViewProvincias.count) {
                // Comprueba si la provincia esta seleccionada y la agrega al array
                if (provinciasChecked[i]) {
                    provinciasSeleccionadas.add(provincias[i])
                }
            }
            if (provinciasSeleccionadas.size == 0){
                TextViewProvinciaSeleccionada.text = ""
            }else{
                TextViewProvinciaSeleccionada.text = "Provincias seleccionadas: ${provinciasSeleccionadas.joinToString(", ")}"
            }
        }
    }
}