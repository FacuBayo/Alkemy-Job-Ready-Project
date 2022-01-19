package com.alkemy.ongsomosmas.ui.home.welcome

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.model.WelcomeResponse
import com.alkemy.ongsomosmas.ui.home.welcome.WelcomeViewHolder

class WelcomeAdapter(private var welcomeList: List<WelcomeResponse>) :
    RecyclerView.Adapter<WelcomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_welcome, parent, false)
        return WelcomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: WelcomeViewHolder, position: Int) {
        val slides = welcomeList[position]
        holder.bind(slides)
    }

    override fun getItemCount(): Int = welcomeList.size

}