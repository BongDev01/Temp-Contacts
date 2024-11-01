package com.bongdev.kotlinss.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {
    @Insert
    suspend fun insert(contact: Contacts) : Long

    @Delete
    suspend fun delete(contact: Contacts)

    @Query("SELECT * FROM `Contact.table`")
    fun getAll(): LiveData<List<Contacts>>

    @Update
    suspend fun update(contact: Contacts)
}