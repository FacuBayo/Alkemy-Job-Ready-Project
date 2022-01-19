package com.alkemy.ongsomosmas.ui.testimonials

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alkemy.ongsomosmas.data.model.TestimonialResponse
import com.alkemy.ongsomosmas.databinding.ItemTestimonialFragmentBinding
import com.squareup.picasso.Picasso



class AdapterTestimonial(val listTestimonials: List<TestimonialResponse>, val context: Context) :
    RecyclerView.Adapter<AdapterTestimonial.TestimonialHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestimonialHolder {

        return TestimonialHolder(
            ItemTestimonialFragmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TestimonialHolder, position: Int) {
        holder.render(listTestimonials[position], context)
    }

    override fun getItemCount() = listTestimonials.size


    class TestimonialHolder(val binding: ItemTestimonialFragmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(testimonial: TestimonialResponse, context: Context) {
            Picasso.get().load(testimonial.image).fit().centerCrop().into(binding.imgTestimonialFragment)
            binding.tvDescriptionTestimonialFragment.text = testimonial.description
            binding.textViewNameTestimonialFragment.text = testimonial.name

        }
    }
}