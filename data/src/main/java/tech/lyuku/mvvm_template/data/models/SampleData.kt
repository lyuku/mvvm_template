package tech.lyuku.mvvm_template.data.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

data class SampleData(
    @Json(name = "id") var id: String? = null,
    @Json(name = "name") var name: String? = null,
    @Json(name = "time") var time: Long? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeValue(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SampleData> {
        override fun createFromParcel(parcel: Parcel): SampleData {
            return SampleData(parcel)
        }

        override fun newArray(size: Int): Array<SampleData?> {
            return arrayOfNulls(size)
        }
    }
}