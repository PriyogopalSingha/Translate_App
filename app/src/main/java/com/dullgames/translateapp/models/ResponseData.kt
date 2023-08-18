package com.dullgames.translateapp.models

import com.google.gson.annotations.SerializedName

data class ResponseData(
    @SerializedName("translatedText")
    val translatedText: String,
    @SerializedName("match")
    val match: String
)
    /*
    "responseData": {
        "translatedText": "- Bu haftasonu ne yaptım.",
        "match": 1
    }
     */


