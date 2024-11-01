package com.bongdev.kotlinss.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact.table")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone: String,
    val email: String
)
