package com.app.breatheasy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.breatheasy.databinding.LayoutBreathModeBinding
import com.app.breatheasy.enums.BreathMode
import com.app.breatheasy.model.BreathModeModel

class BreathModesAdapter(
    private val breathModes: List<BreathModeModel>,
    private val listener: Listener
) : RecyclerView.Adapter<BreathModesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutBreathModeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = breathModes[position]
        with(holder.binding) {
            tvTitle.text = item.name
            tvDescription.text = item.description
            ivBackground.setImageResource(item.imageRes)
            root.setOnClickListener {
                listener.onModeClick(item.type)
            }
            ivInfo.setOnClickListener {
                listener.onInfoClick(item.type)
            }
        }
    }


    override fun getItemCount(): Int {
        return breathModes.size
    }

    class ViewHolder(val binding: LayoutBreathModeBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.clipToOutline = true
        }
    }

    interface Listener {
        fun onModeClick(type: BreathMode)
        fun onInfoClick(type: BreathMode)
    }
}