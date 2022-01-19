package com.alkemy.ongsomosmas.ui.aboutus


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.databinding.FragmentAboutUsDetailsBinding
import com.squareup.picasso.Picasso


class AboutUsDetailsFragment : Fragment(R.layout.fragment_about_us_details) {

    val args: AboutUsDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentAboutUsDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutUsDetailsBinding.bind(view)

        setLayout()

        binding.aboutUsDetailsTextviewNetworkFacebook.setOnClickListener {
            openLink(binding.aboutUsDetailsTextviewNetworkFacebook.text.toString())
        }

        binding.aboutUsDetailsTextviewNetworkLinkeding.setOnClickListener {
            openLink(binding.aboutUsDetailsTextviewNetworkLinkeding.text.toString())
        }

    }

    fun openLink(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    fun setLayout(){
        Picasso.get().load(args.imgUrl).fit().centerCrop().into(binding.aboutUsDetailsImageView)
        binding.aboutUsDetailsTextviewName.text = args.name
        binding.aboutUsDetailsTextviewJob.text = args.job
        binding.aboutUsDetailsTextviewAdmissionDate.text = args.admissionDate.take(10)
        binding.aboutUsDetailsTextviewNetworkFacebook.text = args.facebookUrl
        binding.aboutUsDetailsTextviewNetworkLinkeding.text = args.linkedinUrl
    }
}