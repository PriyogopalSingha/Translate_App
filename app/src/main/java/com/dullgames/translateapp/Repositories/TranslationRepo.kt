package com.dullgames.translateapp.Repositories

import com.dullgames.translateapp.models.BaseModel
import com.dullgames.translateapp.models.Translation

interface TranslationRepo {
    suspend fun translate(query: String, from: String, to: String):BaseModel<Translation>
}