package com.bongdev.kotlinss.repository

import com.bongdev.kotlinss.room.ContactDao
import com.bongdev.kotlinss.room.Contacts

class ContactRepository(private val contactDao: ContactDao) {

    val contacts = contactDao.getAll()

    suspend fun insert(contact: Contacts): Long {
        return contactDao.insert(contact)
    }

    suspend fun delete(contact: Contacts) {
        contactDao.delete(contact)
    }

    suspend fun update(contact: Contacts) {
        contactDao.update(contact)
    }


}