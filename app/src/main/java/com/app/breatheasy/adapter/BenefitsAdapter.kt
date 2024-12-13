/*
 * Copyright (C) 2024 FUJIFILM Corporation. All rights reserved.
 *
 * Created on : 13-12-2024
 * Author     : Suhail.CP
 *
 * com.app.breatheasy.adapter
 *
 * This file contains the implementation of BenefitsAdapter.kt class.
 */
package com.app.breatheasy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.breatheasy.databinding.ItemBenefitsBinding


class BenefitsAdapter(
    private val benefits: List<String>
) : RecyclerView.Adapter<BenefitsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemBenefitsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvBenefits.text = benefits[position]
    }


    override fun getItemCount(): Int {
        return benefits.size
    }

    class ViewHolder(val binding: ItemBenefitsBinding) : RecyclerView.ViewHolder(binding.root)
}