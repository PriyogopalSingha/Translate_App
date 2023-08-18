package com.dullgames.translateapp.models

import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName("responseData")
    val responseData: ResponseData,
    @SerializedName("quotaFinished")
    val quotaFinished: Boolean,
    @SerializedName("mtLangSupported")
    val mtLangSupported: String,
    @SerializedName("responseDetails")
    val responseDetails: String,
    @SerializedName("responseStatus")
    val responseStatus: String,
    @SerializedName("responderId")
    val responsderId: Int?,
    @SerializedName("exception_code")
    val exceptionCode: Int,
    @SerializedName("matches")
    val matches: List<Match>

)
/*
"quotaFinished": false,
"mtLangSupported": null,
"responseDetails": "",
"responseStatus": 200,
"responderId": null,
"exception_code": null,

 */