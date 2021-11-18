package com.example.ejerciciolisteners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejerciciolisteners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.b1.setOnClickListener {
            binding.tv1.text=numeroAle().toString()
        }

        binding.b2.setOnClickListener {
            binding.tv1.text= letraAleatoria().toString()
        }

        binding.b3.setOnClickListener {
            binding.tv1.text= palabraAleatoria()
        }

    }

    fun numeroAle() :Int {
        var num = (1..100).random()
        return num
    }

    fun letraAleatoria() : Char{
        var letra = (97..122).random()
        return letra.toChar()
    }

    fun palabraAleatoria() : String{
        var aux = ""
        for (i in 1..5){
            var palabra = (97..122).random()
            aux+=palabra
        }
        return aux
    }



}