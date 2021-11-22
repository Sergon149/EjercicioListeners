package com.example.ejerciciolisteners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.ejerciciolisteners.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.b1.setOnClickListener {
            var num = (Random.nextInt(99)+1)
            binding.tv1.text= num.toString()
            //
        }

        binding.b2.setOnClickListener {
            binding.tv1.text= letraAleatoria().toString()
        }

        binding.b3.setOnClickListener {
            binding.tv1.text= palabraAleatoria()
        }
        binding.tv1.doOnTextChanged { text, start, before, count ->
            if(count==5){
                binding.b4.visibility = View.VISIBLE
            }
        }
        binding.b4.setOnClickListener{
            var letra = palabra.toCharArray()
            var posicion = (Random.nextInt(4))
            var aleatorio = Random.nextInt(97, 122).toChar()

            Toast.makeText(this,"Cambiamos la letra ${letra[posicion]} por ${aleatorio}",Toast.LENGTH_LONG).show()
            palabra=palabra.replaceRange(posicion,posicion+1, aleatorio.toString())
            binding.tv1.text=palabra
        }

    }

    /*fun numeroAle() :Int {
        var num = (1..100).random()
        return num
    }*/

    fun letraAleatoria() : Char{
        var letra = (97..122).random()
        return letra.toChar()
    }
    var palabra = ""
    fun palabraAleatoria() : String{

        for (i in 1..5){
            var letra = (97..122).random().toChar()
            palabra+=letra
        }
        return palabra
    }



}