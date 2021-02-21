package com.example.esqueletoejercicioapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {


    suspend fun getApiResults() : List<String> {
        return withContext(Dispatchers.IO) {
            val resultado = viewModelScope.async {
                DownloadManager.downloadApiResults()
            }
            resultado.await()
        }
    }
}