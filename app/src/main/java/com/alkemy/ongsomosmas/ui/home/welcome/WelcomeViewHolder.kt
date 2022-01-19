package com.alkemy.ongsomosmas.ui.home.welcome

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.alkemy.ongsomosmas.data.model.WelcomeResponse
import com.alkemy.ongsomosmas.databinding.ItemWelcomeBinding
import com.squareup.picasso.Picasso

class WelcomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemWelcomeBinding.bind(view)
    val itemImage: ImageView = binding.ivSlides
    val itemTitle: TextView = binding.tvSlidesName
    val itemDescription: TextView = binding.tvSlidesDescription


    fun bind(welcomeList: WelcomeResponse) {
        Picasso.get()
            .load(welcomeList.image)
            .into(itemImage)

        itemTitle.text = welcomeList.name
        itemDescription.text =
            HtmlCompat.fromHtml(welcomeList.content ?: "", HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}