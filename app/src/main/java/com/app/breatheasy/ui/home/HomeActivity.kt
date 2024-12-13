package com.app.breatheasy.ui.home

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.breatheasy.R
import com.app.breatheasy.adapter.BreathModesAdapter
import com.app.breatheasy.databinding.ActivityMainBinding
import com.app.breatheasy.enums.BreathMode
import com.app.breatheasy.model.BreathModeModel
import com.app.breatheasy.ui.session.BreathSessionActivity
import com.app.breatheasy.utils.base.BaseActivity
import com.app.breatheasy.utils.dialogs.Dialogs
import com.app.breatheasy.utils.getBlurredImageOfActivity

class HomeActivity : BaseActivity(), BreathModesAdapter.Listener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var breathModeAdapter: BreathModesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.topGuideLine.updateLayoutParams<ConstraintLayout.LayoutParams> {
                guideBegin = systemBars.top
            }
            insets
        }
        initView()
    }

    private fun initView() {
        breathModeAdapter = BreathModesAdapter(getBreathModes(), this)
        binding.rvModes.apply {
            adapter = breathModeAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
        }
    }

    override fun onModeClick(type: BreathMode) {
        avoidMultipleClick {
            if (preference.isModeInfoShown(type)) {
                BreathSessionActivity.start(this, type)
            } else {
                onInfoClick(type)
                preference.setIsModeInfoShown(type)
            }
        }
    }

    override fun onInfoClick(type: BreathMode) {
        avoidMultipleClick {
            Dialogs.showBreathModeInfoDialog(
                this,
                type,
                onStartSessionClick = { onModeClick(type) },
                onShow = {
                    binding.root.foreground = BitmapDrawable(resources, getBlurredImageOfActivity(binding.root))
                }, onDismiss = {
                    binding.root.foreground = null
                })
        }
    }

    private fun getBreathModes(): List<BreathModeModel> {
        return listOf(
            BreathModeModel(
                BreathMode.DIAPHRAGMATIC_BREATHING,
                description = "Reduces stress and promotes relaxation."
            ),
            BreathModeModel(
                BreathMode.BOX_BREATHING,
                description = "Enhances focus and calms the mind."
            ),
            BreathModeModel(
                BreathMode.FOUR_7_8_BREATHING,
                description = "Improves sleep and lowers anxiety."
            ),
            BreathModeModel(
                BreathMode.ALTERNATE_NOSTRIL_BREATHING,
                description = "Balances the mind and relieves tension"
            ),
        )
    }

    /*
* 1. Diaphragmatic Breathing
Reduces stress and promotes relaxation.


2. Box Breathing
Enhances focus and calms the mind.


3. 4-7-8 Breathing
Improves sleep and lowers anxiety.


4. Alternate Nostril Breathing
Balances the mind and relieves tension.*/
}