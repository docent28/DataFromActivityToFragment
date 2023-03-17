package com.example.datafromactivitytofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.datafromactivitytofragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(OneFragment.newInstance(), R.id.OneFrame)
        openFrag(TwoFragment.newInstance(), R.id.TwoFrame)

        binding.btnSendMessageOneFragment.setOnClickListener {
            dataModel.messageForOneFragment.value =
                arrayOf(
                    "Казаки-разбойники",
                    "Городки",
                    "Жмурки",
                    "Чижик",
                    "Лапта",
                    "Фанты",
                    "Горелки"
                ).random()
        }
        binding.btnSendMessageTwoFragment.setOnClickListener {
            dataModel.messageForTwoFragment.value =
                arrayOf(
                    "Battletoads",
                    "Comix Zone",
                    "Counter-Strike",
                    "DotA",
                    "Crash Bandicoot",
                    "Spyro The Dragon",
                    "Diablo 2",
                ).random()
        }

        binding.btnSendMessageTwoFragment.setOnClickListener {
            dataModel.messageForTwoFragment.value = arrayOf("", "", "", "", "", "", "").random()
        }
    }

    private fun openFrag(f: Fragment, idHolder: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}