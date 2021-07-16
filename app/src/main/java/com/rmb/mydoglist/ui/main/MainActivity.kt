package com.rmb.mydoglist.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rmb.mydoglist.databinding.ActivityMainBinding
import com.rmb.mydoglist.model.Dog

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel = MainViewModel()
    private lateinit var dogListAdapter: DogListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerview()

        mainViewModel.dogList.observe(this, Observer {
            binding.rvDogList.scrollToPosition(0)
            dogListAdapter.dogs.clear()
            dogListAdapter.dogs.addAll(it)
            dogListAdapter.notifyDataSetChanged()
        })

        binding.svSearchBreed.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val breed = query.toString()

                if(breed.isNotBlank()) {
                    mainViewModel.getDogsByBreed(breed)
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    private fun setRecyclerview() {
        binding.rvDogList.layoutManager = LinearLayoutManager(this)
        dogListAdapter = DogListAdapter(mutableListOf<Dog>())
        binding.rvDogList.adapter = dogListAdapter
    }
}