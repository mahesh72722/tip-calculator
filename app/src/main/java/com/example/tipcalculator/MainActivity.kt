package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding
import kotlin.math.ceil
import kotlin.math.cos

class MainActivity : AppCompatActivity() {
    // lateinit is a promise that your code will initialize the variable
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // best way with view

        binding.btnCalculate.setOnClickListener{
            calculateTip();
        }


    }

    private fun calculateTip() {

        val cost = binding.etCostOfService.text.toString()


       if (cost == "") {
           Toast.makeText(this,"Please enter the cost of service",Toast.LENGTH_SHORT).show()
           return
       }
        if (binding.rdGrp.checkedRadioButtonId == null) {
            Toast.makeText(this,"Please enter level of service",Toast.LENGTH_SHORT).show()
            return
        }
        val costInNum = cost.toDouble()

       println(" value of costInNum is $costInNum")

        // Determining the tip amount
        val tipPercent = when (binding.rdGrp.checkedRadioButtonId) {
            R.id.rdAmazing -> 0.20
            R.id.rdGood -> 0.18
            R.id.rdGood -> 0.15
            else -> 0.0
        }

        var totalTip = costInNum * tipPercent

        if (binding.swRound.isChecked) {
            totalTip = ceil(totalTip)
        }

        // Rounding to two digit as its a currency
        totalTip = String.format("%.2f", totalTip).toDouble()
        val totalCost = costInNum + totalTip

        // Displaying the final result
        binding.txtTipAmount.text = "$ $totalTip"
        binding.txtTotalAmount.text ="$  $totalCost"




    }
}