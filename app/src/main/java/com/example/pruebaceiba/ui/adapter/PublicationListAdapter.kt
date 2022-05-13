package com.example.pruebaceiba.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaceiba.R
import com.example.pruebaceiba.domain.model.Publication

class PublicationListAdapter(
    private val publicationList: List<Publication>,
    private val  USER_NAME: String,
    private val  USER_PHONE: String,
    private val  USER_EMAIL: String
): RecyclerView.Adapter<PublicationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PublicationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PublicationViewHolder(
            layoutInflater.inflate(
                R.layout.adapter_view_publication,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PublicationViewHolder, position: Int) {
        val item = publicationList[position]
        if (item != null) {
            holder.render(item,USER_NAME, USER_PHONE, USER_EMAIL)
        }
    }

    override fun getItemCount(): Int = publicationList.size

}