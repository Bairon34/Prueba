package com.example.pruebaceiba.ui.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaceiba.databinding.AdapterViewPublicationBinding
import com.example.pruebaceiba.databinding.AdapterViewUserBinding
import com.example.pruebaceiba.domain.User
import com.example.pruebaceiba.domain.model.Publication
import com.example.pruebaceiba.ui.view.Publications

class PublicationViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
    var binding = AdapterViewPublicationBinding.bind(view)

    fun render(publication: Publication, USER_NAME: String, USER_PHONE: String, USER_EMAIL: String){

        binding.textName.text =USER_NAME
        binding.textPhone.text =USER_PHONE
        binding.textEmail.text =USER_EMAIL
        binding.textTitle.text =publication.title
        binding.textBody.text =publication.body


    }
}