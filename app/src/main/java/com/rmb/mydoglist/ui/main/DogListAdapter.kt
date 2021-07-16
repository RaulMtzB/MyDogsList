package com.rmb.mydoglist.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rmb.mydoglist.R
import com.rmb.mydoglist.databinding.DogListItemBinding
import com.rmb.mydoglist.model.Dog

class DogListAdapter(var dogs: MutableList<Dog>): RecyclerView.Adapter<DogListAdapter.DogListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogListViewHolder {
        return DogListViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.dog_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: DogListViewHolder, position: Int) {
        holder.bind(dogs[position])
    }

    override fun getItemCount(): Int {
        return dogs.size
    }

    class DogListViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val dogListItemBinding = DogListItemBinding.bind(view)

        fun bind(dog: Dog) {
            Glide.with(view.context).load(dog.image).into(dogListItemBinding.ivDog)
        }
    }
}