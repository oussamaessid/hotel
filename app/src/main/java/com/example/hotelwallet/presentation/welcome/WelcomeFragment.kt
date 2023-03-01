package com.example.hotelwallet.presentation.welcome

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.example.hotelwallet.R
import com.example.hotelwallet.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding get() = requireNotNull(_binding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)


        binding.btnEnglish.setOnClickListener {
//            if(onBoardingFinished()){
                findNavController().navigate(R.id.action_welcomeFragment_to_viewPagerFragment)
//            }else{
//                findNavController().navigate(R.id.action_welcomeFragment_to_scannerFragment)
//            }
        }

        return binding.root
    }

    private fun onBoardingFinished(): Boolean{
        return requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
         .getBoolean("Finished", false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}