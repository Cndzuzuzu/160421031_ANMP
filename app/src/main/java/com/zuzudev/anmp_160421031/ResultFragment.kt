package com.zuzudev.anmp_160421031

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.zuzudev.anmp_160421031.databinding.FragmentGameBinding
import com.zuzudev.anmp_160421031.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            val playerScore = ResultFragmentArgs.fromBundle(requireArguments()).playerScore
            binding.txtScore.text = "Your Score is $playerScore"
        }

        binding.btnBackHome.setOnClickListener {
            val action = ResultFragmentDirections.actionResMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}