package com.example.pruebaceiba.ui.view

import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaceiba.R
import com.example.pruebaceiba.databinding.AdapterViewUserBinding
import com.example.pruebaceiba.domain.User

class UserViewHolder(view: View):RecyclerView.ViewHolder(view) {
    var binding = AdapterViewUserBinding.bind(view)

    fun render(user: User){
        binding.textName.text =user.name
        binding.textPhone.text =user.phone
        binding.textEmail.text =user.email



        binding.textSee.setOnClickListener {


        }
    }
}




