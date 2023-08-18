package com.dullgames.translateapp.Repositories

import com.dullgames.translateapp.Network.TranslationApi
import com.dullgames.translateapp.models.BaseModel
import com.dullgames.translateapp.models.Translation

class TranslationRepoImpl(private val api: TranslationApi): TranslationRepo {
    override suspend fun translate(
        query: String,
        from: String,
        to: String
    ): BaseModel<Translation> {
        try {
            api.translate(
                query = query,
                langPair = "$from|$to"
            ).also {
                return if (it.isSuccessful) {
                    BaseModel.Success(data = it.body()!!)
                } else {
                    BaseModel.Error(error = it.errorBody()?.string().toString())
                }
            }
        }catch (e: Exception){
            return BaseModel.Error(error = e.message.toString())
        }

    }
}