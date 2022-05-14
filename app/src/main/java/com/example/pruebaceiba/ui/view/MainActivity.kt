package com.example.pruebaceiba.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pruebaceiba.databinding.ActivityMainBinding
import com.example.pruebaceiba.ui.adapter.UserListAdapter
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

        userViewModel.userModel.observe(this, Observer { listUser  ->
            binding.rcyList.layoutManager = LinearLayoutManager(this)
            binding.rcyList.adapter = UserListAdapter(listUser)
            binding.rcyList.adapter!!.notifyDataSetChanged()
        })

        userViewModel.isLoading.observe(this, Observer { isVisible ->
            binding.loading.isVisible = isVisible
        })

        userViewModel.isSearch.observe(this, Observer { isVisible ->
            binding.meesage.isVisible = isVisible
            binding.rcyList.isVisible = !isVisible
        })

        binding.edtSearch.addTextChangedListener { wordSearch  ->
            userViewModel.getSearchData(wordSearch.toString().trim())
        }
    }

}