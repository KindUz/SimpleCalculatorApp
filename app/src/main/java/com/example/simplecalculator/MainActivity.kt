package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import com.example.simplecalculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnC.setOnClickListener {
            if (!binding.tvInput.text.isNullOrEmpty()){
                binding.tvInput.text = binding.tvInput.text.substring(0, binding.tvInput.text.length-1)
            }
        }

        binding.btnLeftBracket.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "("
        }

        binding.btnRightBracket.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + ")"
        }

        binding.btnDivide.setOnClickListener {
            if (binding.tvInput.text.toString().last() == '*' || binding.tvInput.text.toString().last() == '/' || binding.tvInput.text.toString().last() == '+' || binding.tvInput.text.toString().last() == '-') {
                val text = binding.tvInput.text.dropLast(1)
                binding.tvInput.text = text
            }
            binding.tvInput.text = binding.tvInput.text.toString() + "/"
        }

        binding.btn7.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "7"
        }

        binding.btn8.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "8"
        }

        binding.btn9.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "9"
        }

        binding.btnMiltiply.setOnClickListener {
            if (binding.tvInput.text.toString().last() == '*' || binding.tvInput.text.toString().last() == '/' || binding.tvInput.text.toString().last() == '+' || binding.tvInput.text.toString().last() == '-') {
                val text = binding.tvInput.text.dropLast(1)
                binding.tvInput.text = text
            }
            binding.tvInput.text = binding.tvInput.text.toString() + "*"
        }

        binding.btn4.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "4"
        }

        binding.btn5.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "5"
        }

        binding.btn6.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "6"
        }

        binding.btnPlus.setOnClickListener {
            if (binding.tvInput.text.toString().last() == '*' || binding.tvInput.text.toString().last() == '/' || binding.tvInput.text.toString().last() == '+' || binding.tvInput.text.toString().last() == '-') {
                val text = binding.tvInput.text.dropLast(1)
                binding.tvInput.text = text
            }
            binding.tvInput.text = binding.tvInput.text.toString() + "+"
        }

        binding.btn1.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "1"
        }

        binding.btn2.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "2"
        }

        binding.btn3.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "3"
        }

        binding.btnMinus.setOnClickListener {
            if (binding.tvInput.text.toString().last() == '*' || binding.tvInput.text.toString().last() == '/' || binding.tvInput.text.toString().last() == '+' || binding.tvInput.text.toString().last() == '-') {
                val text = binding.tvInput.text.dropLast(1)
                binding.tvInput.text = text
            }
            binding.tvInput.text = binding.tvInput.text.toString() + "-"
        }

        binding.btnAC.setOnClickListener {
            binding.tvInput.text = ""
            binding.tvResult.text = ""
        }

        binding.btn0.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "0"
        }

        binding.btnDot.setOnClickListener {
            binding.tvInput.text = binding.tvInput.text.toString() + "."
        }

        binding.btnEqual.setOnClickListener {
            if (binding.tvInput.text.last() == '0' && binding.tvInput.text.get(binding.tvInput.text.length-2) == '/') binding.tvResult.text = "NaN"
            if (binding.tvInput.text.last() == '+' || binding.tvInput.text.last() == '-' || binding.tvInput.text.last() == '*' || binding.tvInput.text.last() == '/') {
                binding.tvResult.text = "Error"
                val text = binding.tvInput.text.dropLast(1)
                binding.tvInput.text = text
            }
            else showResult()

        }

    }

    fun showResult(){
        val expression = ExpressionBuilder(binding.tvInput.text.toString()).build()
        val result = expression.evaluate()
        val longresult = result.toLong()

        if (result == longresult.toDouble()){
            binding.tvResult.text = longresult.toString()
            binding.tvInput.text = longresult.toString()
        }
        else {
            binding.tvResult.text = result.toString()
            binding.tvInput.text = result.toString()
        }




    }


}