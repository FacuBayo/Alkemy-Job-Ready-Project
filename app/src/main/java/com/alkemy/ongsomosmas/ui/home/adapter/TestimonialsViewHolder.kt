package com.alkemy.ongsomosmas.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alkemy.ongsomosmas.data.model.TestimonialResponse
import com.alkemy.ongsomosmas.databinding.ItemTestimonialsBinding
import com.squareup.picasso.Picasso

class TestimonialsViewHolder(
    private val itemView: View,
    private val listener: (position: Int) -> Unit
) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ItemTestimonialsBinding.bind(itemView)

    fun render(testimonial: TestimonialResponse) {

        Picasso.get().load(testimonial.image).into(binding.ivTestimonialsImage)
        binding.tvTestimonialName.text = testimonial.name
    }

    init {
        itemView.setOnClickListener {
            listener(adapterPosition)
        }
    }

}