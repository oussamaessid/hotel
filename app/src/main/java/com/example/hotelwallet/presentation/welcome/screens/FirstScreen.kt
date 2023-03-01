package com.example.hotelwallet.presentation.welcome.screens

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.hotelwallet.R
import com.example.hotelwallet.databinding.FragmentFirstScreenBinding
import com.example.hotelwallet.utility.LayoutUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreen : Fragment(R.layout.fragment_first_screen) {


    private lateinit var binding: FragmentFirstScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getInt("step")?.let {
            setViews(it)
        }
    }

    private fun setViews(step: Int) {
        val layout = layoutList()[step]

        binding.animationView.setImageResource(layout.image)
        binding.title.text = requireContext().getString(layout.title)
        binding.description.text = requireContext().getString(layout.description)
    }

    private fun layoutList(): List<LayoutUiModel> =
        listOf(
            LayoutUiModel(
                R.drawable.bacground4,
                R.string.title_onboarding_1,
                R.string.description_onboarding_1
            ),
            LayoutUiModel(
                R.drawable.bacground4,
                R.string.title_onboarding_2,
                R.string.description_onboarding_2
            ),
            LayoutUiModel(
                R.drawable.bacground4,
                R.string.title_onboarding_2,
                R.string.description_onboarding_2
            )
        )

    companion object {
        fun newInstance(step: Int) =
            FirstScreen().apply {
                arguments = Bundle().apply {
                    putInt("step", step)
                }
            }
    }
}