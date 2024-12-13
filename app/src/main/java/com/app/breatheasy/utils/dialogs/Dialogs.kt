package com.app.breatheasy.utils.dialogs

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.breatheasy.R
import com.app.breatheasy.adapter.BenefitsAdapter
import com.app.breatheasy.databinding.DialogInfoDetailsBinding
import com.app.breatheasy.enums.BreathMode

object Dialogs {

    fun showBreathModeInfoDialog(
        context: Context,
        breathType: BreathMode,
        onStartSessionClick: (v: View) -> Unit,
        onShow: () -> Unit,
        onDismiss: () -> Unit
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        val binding = DialogInfoDetailsBinding.inflate(dialog.layoutInflater)
        dialog.setView(binding.root)
        dialog.window?.setWindowAnimations(R.style.DialogBounceAnimation)
        with(breathType) {
            binding.bgImageView.setImageResource(getImageRes())
            binding.tvName.text = getTitle()
            binding.tvDescription.text = getDescription()
            binding.rvBenefits.layoutManager = LinearLayoutManager(context)
            binding.rvBenefits.adapter = BenefitsAdapter(getBenefits())
        }

        dialog.setCancelable(true)
        binding.btStartSession.setOnClickListener(onStartSessionClick)
        binding.btClose.setOnClickListener { dialog.dismiss() }
        dialog.setOnShowListener {
            onShow()
        }
        dialog.setOnDismissListener {
            onDismiss()
        }
        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

    private fun AlertDialog.showAsFullScreen() {
        show()
        window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        window?.setGravity(Gravity.CENTER)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}