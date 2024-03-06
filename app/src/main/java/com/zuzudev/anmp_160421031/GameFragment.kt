package com.zuzudev.anmp_160421031

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.zuzudev.anmp_160421031.databinding.FragmentGameBinding
import com.zuzudev.anmp_160421031.databinding.FragmentMainBinding


class GameFragment : Fragment() {
   private lateinit var binding:FragmentGameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var num1 = (1..10).random()
        var num2 = (1..10).random()
        var correct = num1+num2
        var score = 0
        binding.txtAngka.text = "$num1 + $num2 ="
        if(arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            binding.txtTurn.text = "$playerName's Turn"
        }

        binding.btnNext.setOnClickListener {
            val ans = Integer.parseInt(binding.txtInput.text.toString())
            if (ans == correct){
                num1 = (1..10).random()
                num2 = (1..10).random()
                correct =num1+num2
                binding.txtAngka.text = "$num1 + $num2 ="
                score++
            }
            else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
                this.onDestroyView()
            }
        }

        binding.btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }



}