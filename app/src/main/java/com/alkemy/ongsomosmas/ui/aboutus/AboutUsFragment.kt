package com.alkemy.ongsomosmas.ui.aboutus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.model.MembersResponse
import com.alkemy.ongsomosmas.databinding.FragmentAboutUsBinding
import com.alkemy.ongsomosmas.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutUsFragment :  BaseFragment(R.layout.fragment_about_us) {
    private lateinit var binding: FragmentAboutUsBinding
    private lateinit var aboutUsAdapter: AboutUsAdapter
    private val aboutUsViewModel: AboutUsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutUsBinding.inflate(inflater, container, false)
        aboutUsViewModel.getMembers()
        setUpObservers()
        return binding.root
    }

    private fun setUpObservers() {
        aboutUsViewModel.membersViewState.observe(viewLifecycleOwner) {
            when (it) {
                is AboutUsState.Success -> {
                    setDataAndShowRecycler(it.membersList)
                }
                is AboutUsState.Error -> {
                    setListenerAndShowError()
                }
                is AboutUsState.Loading-> {
                    showLoading(it.isLoading)
                }
            }
        }
    }

    private fun setDataAndShowRecycler(listMembers: List<MembersResponse>) {
        aboutUsAdapter = AboutUsAdapter(listMembers,
            onClick = {})
        binding.rvMembers.adapter = aboutUsAdapter
    }

    private fun showLoading(isLoading: Boolean) {
        binding.loading.progressBar.isVisible = isLoading
    }

    private fun setListenerAndShowError() {
        with(binding) {
            rvMembers.isVisible = false
            aboutUsFragmentError.root.isVisible = true
            aboutUsFragmentError.tvError.text = getString(R.string.about_us_error)
            aboutUsFragmentError.btnRetry.setOnClickListener {
                aboutUsViewModel.getMembers()
                aboutUsFragmentError.root.isVisible = false
            }
        }
    }
}