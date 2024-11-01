package com.bongdev.kotlinss.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bongdev.kotlinss.repository.ContactRepository
import com.bongdev.kotlinss.room.Contacts
import kotlinx.coroutines.launch

class ContactViewModel(private val repository: ContactRepository) : ViewModel(), Observable{

 val contacts = repository.contacts
    private var isUpdatedOrDeleted = false
    private lateinit var contactToUpdateOrDelete: Contacts

    @Bindable
    val inputName = MutableLiveData<String?>()
    @Bindable
    val inputEmail = MutableLiveData<String?>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String?>()

    @Bindable
    val clearButtonText = MutableLiveData<String?>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearButtonText.value = "Clear"
    }

    fun insert(contact: Contacts) = viewModelScope.launch {
       repository.insert(contact)
    }

   fun delete(contact: Contacts) = viewModelScope.launch {
       repository.delete(contact)
      // reseating the fields
      inputName.value = null
      inputEmail.value = null
      isUpdatedOrDeleted = false
      saveOrUpdateButtonText.value = "Save"
      clearButtonText.value = "Clear"
   }

   fun update(contact: Contacts) = viewModelScope.launch {
       repository.update(contact)

       // reseating the fields
       inputName.value = null
       inputEmail.value = null
       isUpdatedOrDeleted = false
       saveOrUpdateButtonText.value = "Save"
       clearButtonText.value = "Clear"
   }



}