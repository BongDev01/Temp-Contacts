package com.bongdev.kotlinss

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bongdev.kotlinss.databinding.CardViewBinding
import com.bongdev.kotlinss.room.Contacts

class MyRecyclerViewAdapter(
    private val contacts: List<Contacts>,
    private val clickListener: (Contacts) -> Unit
) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyviewHolder>() {

    class MyviewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contacts, clickListener: (Contacts) -> Unit) {
            binding.nameTV.text = contact.name
            binding.numberTV.text = contact.phone
            binding.emailTV.text = contact.email
            binding.listItemLayout.setOnClickListener {
                clickListener(contact)
            }

        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding: CardViewBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.card_view, parent, false)
            return MyviewHolder(binding)
        }

        override fun getItemCount(): Int {
            return contacts.size
        }

        override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
            holder.bind(contacts[position], clickListener)
        }


    }
