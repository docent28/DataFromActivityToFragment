package com.example.datafromactivitytofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.datafromactivitytofragment.databinding.FragmentTwoBinding

// TODO: Rename parameter arguments, choose names that match
class TwoFragment : Fragment() {

    lateinit var binding: FragmentTwoBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForTwoFragment.observe(activity as LifecycleOwner) {
            binding.txtViewTwo.text = it
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = TwoFragment()
    }
}