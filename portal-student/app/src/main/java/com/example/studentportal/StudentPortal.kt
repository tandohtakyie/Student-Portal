package com.example.studentportal

import android.os.Parcel
import android.os.Parcelable

class StudentPortal(
    var id: Int,
    var name: String?,
    var link: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(link)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StudentPortal> {
        override fun createFromParcel(parcel: Parcel): StudentPortal {
            return StudentPortal(parcel)
        }

        override fun newArray(size: Int): Array<StudentPortal?> {
            return arrayOfNulls(size)
        }
    }
}