package com.example.pruebaceiba.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebaceiba.databinding.ActivityPublicationsBinding
import com.example.pruebaceiba.ui.adapter.PublicationListAdapter
import com.example.pruebaceiba.ui.viewmodel.PublicationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Publications : AppCompatActivity() {

  private  var USER_ID :String = ""
  private  var USER_NAME :String = ""
  private  var USER_PHONE :String = ""
  private  var USER_EMAIL :String = ""

  private lateinit var binding: ActivityPublicationsBinding
  private val publicationViewModel: PublicationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        publicationViewModel.onCreate(USER_ID.toInt())

        publicationViewModel.publicationModel.observe(this, Observer { listPublication  ->
            binding.rcyListPublication.layoutManager = LinearLayoutManager(this)
            binding.rcyListPublication.adapter = PublicationListAdapter(listPublication,USER_NAME,USER_PHONE,USER_EMAIL)
            binding.rcyListPublication.adapter!!.notifyDataSetChanged()
        })

        publicationViewModel.isLoading.observe(this, Observer { isVisible ->
            binding.loading.isVisible = isVisible
        })
    }

     private fun loadData() {
         USER_ID  =  intent.getStringExtra("userId").toString()
         USER_NAME  = intent.getStringExtra("userName").toString()
         USER_PHONE = intent.getStringExtra("userPhone").toString()
         USER_EMAIL = intent.getStringExtra("userEmail").toString()
     }
 }