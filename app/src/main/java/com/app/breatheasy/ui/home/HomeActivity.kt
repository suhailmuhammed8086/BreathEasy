package com.app.breatheasy.ui.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.breatheasy.R
import com.app.breatheasy.adapter.BreathModesAdapter
import com.app.breatheasy.databinding.ActivityMainBinding
import com.app.breatheasy.enums.BreathMode
import com.app.breatheasy.model.BreathModeModel
import com.app.breatheasy.ui.session.BreathSessionActivity
import com.app.breatheasy.utils.base.BaseActivity

class HomeActivity : BaseActivity(), BreathModesAdapter.Listener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var breathModeAdapter: BreathModesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
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
            BreathSessionActivity.start(this, type)
        }
    }

    override fun onInfoClick(type: BreathMode) {

    }

    private fun getBreathModes(): List<BreathModeModel> {
        return listOf(
            BreathModeModel(
                BreathMode.DIAPHRAGMATIC_BREATHING,
                "Diaphragmatic Breathing",
                "Reduces stress and promotes relaxation.",
                R.drawable.img_one
            ),
            BreathModeModel(
                BreathMode.BOX_BREATHING,
                "Box Breathing",
                "Enhances focus and calms the mind.",
                R.drawable.img_four
            ),
            BreathModeModel(
                BreathMode.FOUR_7_8_BREATHING,
                "4-7-8 Breathing",
                "Improves sleep and lowers anxiety.",
                R.drawable.img_five
            ),
            BreathModeModel(
                BreathMode.ALTERNATE_NOSTRIL_BREATHING,
                "Alternate Nostril Breathing",
                "Balances the mind and relieves tension",
                R.drawable.img_two
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