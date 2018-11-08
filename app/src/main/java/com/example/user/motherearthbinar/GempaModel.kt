package com.example.user.motherearthbinar

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class GempaModel(
    @SerializedName("lokasi") var lokasi: String? = "lokasi",
    @SerializedName("tanggal") var tanggal: String? = "tanggal",
    @SerializedName("waktu") var waktu: String? = "waktu",
    @SerializedName("SR") var SR: Double? = 8.1,
    @SerializedName("status") var status: String? = "bahaya"
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(lokasi)
        parcel.writeString(tanggal)
        parcel.writeString(waktu)
        parcel.writeValue(SR)
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GempaModel> {
        override fun createFromParcel(parcel: Parcel): GempaModel {
            return GempaModel(parcel)
        }

        override fun newArray(size: Int): Array<GempaModel?> {
            return arrayOfNulls(size)
        }
    }
}