package com.example.pruebaceiba.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebaceiba.databinding.ActivityMainBinding
import com.example.pruebaceiba.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel.onCreate()


        userViewModel.userModel.observe(this, Observer {
            binding.rcyList.layoutManager = LinearLayoutManager(this)
            binding.rcyList.adapter = UserListAdapter(it)
            binding.rcyList.adapter!!.notifyDataSetChanged()
            Log.e("error","data "+it[0].email)
        })

        userViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })


        binding.btn.setOnClickListener {
            userViewModel.getDataLocal()
        }


    }

}