package com.alkemy.ongsomosmas.ui.testimonials

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.model.TestimonialResponse
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse
import com.alkemy.ongsomosmas.databinding.FragmentTestimonialsBinding
import com.alkemy.ongsomosmas.ui.BaseFragment
import com.alkemy.ongsomosmas.ui.activities.adapter.ActivitiesAdapter
import com.alkemy.ongsomosmas.ui.home.adapter.TestimonialState
import com.alkemy.ongsomosmas.ui.home.adapter.TestimonialViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestimonialsFragment : BaseFragment(R.layout.fragment_testimonials) {
    private lateinit var binding: FragmentTestimonialsBinding
    private val testimonialViewModel: TestimonialViewModel by viewModels()
    private lateinit var testimonialAdapter: AdapterTestimonial


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTestimonialsBinding.bind(view)
        setUpObservers()
        testimonialViewModel.getTestimonials()
        showProgressDialog()

    }

    private fun setUpObservers() {
        testimonialViewModel.testimonialsViewState.observe(viewLifecycleOwner) { it ->
            when (it) {
                is TestimonialState.Success -> {
                    setDataAndShowRecycler(it.listTestimonial, requireContext())
                    hideProgressDialog()
                }
                is TestimonialState.Error -> {
                    hideProgressDialog()
                }
                is TestimonialState.Loading -> {
                    hideProgressDialog()
                }
            }
        }
    }

    private fun setDataAndShowRecycler(
        listTestimonial: List<TestimonialResponse>,
        context: Context
    ) {
        testimonialAdapter = AdapterTestimonial(listTestimonial, context)
        binding.rvTestimonialFragment.adapter = testimonialAdapter
        binding.rvTestimonialFragment.addItemDecoration(
            DividerItemDecoration(
                activity,
                LinearLayoutManager.VERTICAL
            )
        )
    }

}