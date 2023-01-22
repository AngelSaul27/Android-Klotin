package android.example.com.tiptime

import android.example.com.tiptime.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    //La palabra clave lateinit es algo nuevo. Es una promesa de que tu código inicializará
    // la variable antes de usarla. De lo contrario, tu app fallará.

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Esta línea inicializa el objeto binding que usarás para acceder a Views en el diseño
        // activity_main.xml.
        binding = ActivityMainBinding.inflate(layoutInflater)

        //En lugar de pasar el ID de recurso del diseño, R.layout.activity_main, especifica la raíz
        // de la jerarquía de vistas en tu app, binding.root.
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{
            calculateTip()
        }
    }

    private fun calculateTip(){
        val costServicesString = binding.costServiceInput.text.toString()
        val cost = costServicesString.toDoubleOrNull()
        if (cost == null || cost == 0.0) {
            displayTip(0.0)
            return
        }

        val tipPorcentage = when(binding.tipOptions.checkedRadioButtonId){
            R.id.option_eighteen_percent -> 0.18
            R.id.option_twenty_percent -> 0.20
            else -> 0.15
        }

        var tip = tipPorcentage * cost
        if(binding.roundUpTip.isChecked){
            tip = kotlin.math.ceil(tip)
        }

        displayTip(tip)
    }

    private fun displayTip(tip : Double){
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.resultAmount.text = getString(R.string.tip_amount, formattedTip)
    }
}