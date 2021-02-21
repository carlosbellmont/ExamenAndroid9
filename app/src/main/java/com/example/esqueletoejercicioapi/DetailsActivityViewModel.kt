package com.example.esqueletoejercicioapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class DetailsActivityViewModel : ViewModel() {


    suspend fun getSingleItem(userChoice : String) : String {
        return withContext(Dispatchers.IO) {
            val resultado = viewModelScope.async {
                DownloadManager.downloadApiSingleResult(userChoice)
            }
            resultado.await()
        }
    }
}