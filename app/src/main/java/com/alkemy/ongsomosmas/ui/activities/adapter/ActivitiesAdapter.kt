package com.alkemy.ongsomosmas.ui.activities.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse
import com.alkemy.ongsomosmas.databinding.ItemActivityBinding
import com.squareup.picasso.Picasso
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ActivitiesAdapter(val activitesList: List<ActivitiesResponse>, val context: Context) :
    RecyclerView.Adapter<ActivitiesAdapter.ActivitiesHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivitiesHolder {

        return ActivitiesHolder(
            ItemActivityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ActivitiesHolder, position: Int) {
        holder.render(activitesList[position], context)
    }

    override fun getItemCount() = activitesList.size


    class ActivitiesHolder(val binding: ItemActivityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(activites: ActivitiesResponse, context: Context) {
            binding.tvTitleActivity.text = activites.name
            Picasso.get().load(activites.image).fit().centerCrop().into(binding.imgActivity)
            binding.tvDescriptionActivity.text = activites.description
            binding.tvDateActivity.text = "${context.getString(R.string.activites_published)} ${activites.createdAt.take(10)}"
        }
    }
}

