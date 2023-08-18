package com.dullgames.translateapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dullgames.translateapp.Repositories.TranslationRepo
import com.dullgames.translateapp.models.BaseModel
import com.dullgames.translateapp.models.Translation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {
    private val repo: TranslationRepo by inject()
    private val _translation: MutableStateFlow<BaseModel<Translation>?> = MutableStateFlow(null)
    val translation = _translation.asStateFlow()

    fun translate(query: String, source: String, target: String) {
        _translation.update { BaseModel.Loading }
        viewModelScope.launch {
            repo.translate(query, source, target).also { response ->
                _translation.update { response }
            }
        }
    }

    fun clear(){
        _translation.update { null }
    }
}