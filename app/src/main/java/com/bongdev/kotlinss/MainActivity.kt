package com.bongdev.kotlinss

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bongdev.kotlinss.databinding.ActivityMainBinding
import com.bongdev.kotlinss.repository.ContactRepository
import com.bongdev.kotlinss.room.ContactDatabase
import com.bongdev.kotlinss.room.Contacts
import com.bongdev.kotlinss.viewmodel.ContactViewModel
import com.bongdev.kotlinss.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var contactViewModel: ContactViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dao = ContactDatabase.getInstance(applicationContext).contactDao()
        val repository = ContactRepository(dao)
        val factory = ViewModelFactory(repository)

        contactViewModel = ViewModelProvider(this, factory).get(ContactViewModel::class.java)
        binding.contactViewModel = contactViewModel
        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        DisplayUserList()
    }

    private fun DisplayUserList() {
        contactViewModel.contacts.observe(this,{
            binding.recyclerView.adapter = MyRecyclerViewAdapter(it, {selectedItem: Contacts -> listItemClicked(selectedItem)})
        })
    }

    private fun listItemClicked(selectedItem: Contacts) {
        Toast.makeText(this, "selected name is ${selectedItem.name}", Toast.LENGTH_SHORT).show()

    }
}