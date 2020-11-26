package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.logging.ErrorManager

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtLenght: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtWidth: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtLenght = findViewById(R.id.edt_lenght)
        edtHeight = findViewById(R.id.edt_height)
        edtWidth = findViewById(R.id.edt_width)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate = findViewById(R.id.btn_volume)


        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_volume) {
            val inputLenght = edtLenght.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            val inputWidht = edtWidth.text.toString().trim()

            var isEmptyField = false

            when{
                inputHeight.isEmpty() ->{
                    isEmptyField = true
                    edtHeight.error = "Field tidak boleh kosong"
                }
                inputLenght.isEmpty() ->{
                    isEmptyField = true
                    edtLenght.error = "Field tidak boleh kosong"
                }
                inputWidht.isEmpty() ->{
                    isEmptyField = true
                    edtWidth.error = "Field tidak boleh kosong"
                }
            }

            if (!isEmptyField){
                val volume = inputHeight.toDouble() * inputLenght.toDouble() * inputWidht.toDouble()
                tvResult.text = volume.toString()

            }

        }
    }

}