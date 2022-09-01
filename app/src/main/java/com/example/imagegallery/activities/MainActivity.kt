package com.example.imagegallery.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imagegallery.adapter.ImageAdapter
import com.example.imagegallery.databinding.ActivityMainBinding
import com.example.imagegallery.viewmodel.ImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageAdapter: ImageAdapter
    private val viewModel: ImageViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        viewModel.getAllImages()
    }


    private fun setUpRecyclerView() {
        imageAdapter = ImageAdapter()

        binding.recyclerView.apply {
            adapter = imageAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)

        }
        viewModel.responseImages.observe(this) { response ->
            if (response != null) {
                imageAdapter.submitList(response)
            }
        }
    }
}