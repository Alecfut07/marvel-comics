package com.example.marvelcomics

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Character(var name: String, var id: String = UUID.randomUUID().toString()) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString(), parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Character> {
        override fun createFromParcel(parcel: Parcel): Character {
            return Character(parcel)
        }

        override fun newArray(size: Int): Array<Character?> {
            return arrayOfNulls(size)
        }
    }
}
