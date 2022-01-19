package com.alkemy.ongsomosmas.ui.activities

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.model.TestimonialResponse
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse
import com.alkemy.ongsomosmas.databinding.FragmentActivitiesBinding
import com.alkemy.ongsomosmas.databinding.FragmentHomeBinding
import com.alkemy.ongsomosmas.ui.BaseFragment
import com.alkemy.ongsomosmas.ui.activities.adapter.ActivitiesAdapter
import com.alkemy.ongsomosmas.ui.home.adapter.TestimonialAdapter
import com.alkemy.ongsomosmas.ui.home.adapter.TestimonialState
import com.alkemy.ongsomosmas.ui.home.adapter.TestimonialViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivitiesFragment : BaseFragment(R.layout.fragment_activities) {

    private lateinit var binding: FragmentActivitiesBinding
    private lateinit var activitiesAdapter: ActivitiesAdapter

    private val activitiesViewModel: ActivitiesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentActivitiesBinding.bind(view)

        setUpObserver()
        activitiesViewModel.getActivities()


    }

    private fun setUpObserver() {
        showProgressDialog()
        activitiesViewModel.activitiesViewState.observe(viewLifecycleOwner) {
            when (it) {
                is ActivitiesState.ShowActivitiesList -> {
                    setDataAndShowRecycler(it.listActivities, requireContext())
                    hideProgressDialog()
                }
                is ActivitiesState.ShowError -> {
                }
                is ActivitiesState.ShowLoading -> {


                }
            }
        }
    }


    private fun setDataAndShowRecycler(listActivities: List<ActivitiesResponse>, context: Context) {
        activitiesAdapter = ActivitiesAdapter(listActivities, context)
        binding.rvActivities.adapter = activitiesAdapter
        binding.rvActivities.addItemDecoration(
            DividerItemDecoration(
                activity,
                LinearLayoutManager.VERTICAL
            )
        )
    }


}