package com.example.pruebaceiba.ui.adapter


import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaceiba.databinding.AdapterViewUserBinding
import com.example.pruebaceiba.domain.User
import com.example.pruebaceiba.ui.view.Publications


class UserViewHolder(view: View):RecyclerView.ViewHolder(view) {
    var binding = AdapterViewUserBinding.bind(view)

    fun render(user: User){
        binding.textName.text =user.name
        binding.textPhone.text =user.phone
        binding.textEmail.text =user.email

        binding.textSee.setOnClickListener {
            val intent = Intent(binding.textSee.context, Publications::class.java)
            intent.putExtra("userId", user.id.toString())
            intent.putExtra("userName", user.name)
            intent.putExtra("userPhone", user.phone)
            intent.putExtra("userEmail", user.email)
            binding.textSee.context.startActivity(intent)
        }
    }
}




