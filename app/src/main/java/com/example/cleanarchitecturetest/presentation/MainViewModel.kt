package com.example.cleanarchitecturetest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cleanarchitecturestest.domain.usecase.GetUserNameUseCase
import com.cleanarchitecturestest.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
): ViewModel() {

    private val result = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = result

    init {
        Log.e("My", "VM created")
    }
    override fun onCleared() {
        super.onCleared()
        Log.e("My", "VM cleared")
    }
    fun get() {
        val userName = getUserNameUseCase.execute()
        result.value = "First name: ${userName.firstName} Last name: ${userName.lastName}"
    }
    fun save(text: String){
        val params = com.cleanarchitecturestest.domain.models.SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
         result.value = "Save result = $resultData"
    }
}