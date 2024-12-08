package com.app.breatheasy.ui.session

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.breatheasy.R
import com.app.breatheasy.databinding.ActivityBreathSessionBinding
import com.app.breatheasy.enums.BreathMode
import com.app.breatheasy.utils.getSerializableCompact

class BreathSessionActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val ARGS_BREATH_MODE = "arg_breath_mode"

        @JvmStatic
        fun start(context: Context, breathMode: BreathMode) {
            val starter = Intent(context, BreathSessionActivity::class.java)
            starter.putExtra(ARGS_BREATH_MODE, breathMode)
            context.startActivity(starter)
        }
    }

    private lateinit var binding: ActivityBreathSessionBinding
    private var breathMode: BreathMode = BreathMode.DIAPHRAGMATIC_BREATHING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityBreathSessionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getIntentData()
        initView()
        loadFragment()
    }


    private fun getIntentData() {
        breathMode = intent.getSerializableCompact<BreathMode>(ARGS_BREATH_MODE) ?: breathMode
    }

    private fun initView() {
        with(binding.appBar) {
            btBack.setOnClickListener(this@BreathSessionActivity)
            tvTitle.text = breathMode.getTitle()
        }
    }

    private fun BreathMode.getTitle(): String {
        return when (this) {
            BreathMode.DIAPHRAGMATIC_BREATHING -> "Diaphragmatic Breathing"
            BreathMode.BOX_BREATHING -> "Box Breathing"
            BreathMode.FOUR_7_8_BREATHING -> "4-7-8 Breathing"
            BreathMode.ALTERNATE_NOSTRIL_BREATHING -> "Alternate Nostril Breathing"
        }
    }

    private fun loadFragment() {
        var fragment = when (breathMode) {
            BreathMode.DIAPHRAGMATIC_BREATHING -> {}
            BreathMode.BOX_BREATHING -> {}
            BreathMode.FOUR_7_8_BREATHING -> {}
            BreathMode.ALTERNATE_NOSTRIL_BREATHING -> {}
        }
        // Load Fragment
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btBack -> {
                finish()
            }
        }
    }
}