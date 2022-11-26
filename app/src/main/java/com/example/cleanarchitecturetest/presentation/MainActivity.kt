package com.example.cleanarchitecturetest.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturetest.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("My", "Activity created")
        buttonClick()
    }
    private fun buttonClick() = with(binding){

        viewModel.resultLiveData.observe(this@MainActivity) {
            tvGet.text = it
        }

        btnGet.setOnClickListener {
            //Обработчик нажатия кнопки Get User Data
             viewModel.get()
        }
        btnSave.setOnClickListener {
            //Обработчик нажатия кнопки Save User Data
            viewModel.save(edtSave.text.toString())
        }
    }
}