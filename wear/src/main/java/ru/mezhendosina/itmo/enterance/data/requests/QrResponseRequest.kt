package ru.mezhendosina.itmo.enterance.data.requests

import com.google.gson.annotations.SerializedName

data class QrResponseRequest(
    @SerializedName("P121_HEXCODE") val hexcode: String
)
