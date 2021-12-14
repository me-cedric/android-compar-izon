package com.mecedric.androidcomparizon.persistence

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class PokemonImage(
    @PrimaryKey val imageName: String,
    @ColumnInfo val imageUrlFull: String?,
    @ColumnInfo val imageUrlRegular: String?
) : Parcelable