package com.example.hotelwallet.presentation.welcome

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hotelwallet.R
import com.example.hotelwallet.databinding.FragmentWelcomeBinding
import com.example.hotelwallet.domain.model.LayoutUiModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding get() = requireNotNull(_binding)
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        setViewPage()
        binding.viewPager.adapter = viewPagerAdapter


        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()

        binding.btnEnglish.setOnClickListener {

            binding.btnEnglish.visibility = View.INVISIBLE
            binding.btnArabe.visibility = View.INVISIBLE

            binding.btnSkip.visibility = View.VISIBLE
            binding.btnNext.visibility = View.VISIBLE
            binding.viewPager.visibility = View.VISIBLE
            binding.tabLayout.visibility = View.VISIBLE

            binding.btnNext.setOnClickListener {
                if (binding.viewPager.currentItem == 2)
                    findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
                else {
                    positionVerify(binding.viewPager.currentItem)
                    binding.viewPager.currentItem++
                }
            }

            binding.btnSkip.setOnClickListener {
                findNavController().navigate(R.id.action_welcomeFragment_to_scannerFragment)
            }
        }
        return binding.root
    }

    private fun positionVerify(position: Int) {
        when (position) {
            0 -> {
                binding.btnSkip.visibility = View.VISIBLE
                binding.btnNext.text = getString(R.string.txt_next)
            }
            2 -> {
                binding.btnSkip.visibility = View.VISIBLE
                binding.btnNext.text = getString(R.string.txt_go)
            }
            else -> {
                binding.btnSkip.visibility = View.VISIBLE
                binding.btnNext.text = getString(R.string.txt_next)
            }
        }
    }

    fun setViewPage() {
        viewPagerAdapter = ViewPagerAdapter()
        val data = layoutList()
        viewPagerAdapter.setViewPageAdapter(data)
    }


    private fun layoutList(): ArrayList<LayoutUiModel> {
        val list = ArrayList<LayoutUiModel>()
        list.add(
            LayoutUiModel(
                R.drawable.bacground4,
                "Work at Home",
                "Work at home to more comfort. Make a great projects with this app"
            )
        )
        list.add(
            LayoutUiModel(
                R.drawable.bacground4,
                "Analyse Your Project",
                "Smart details for analysis. Do more with this app"
            )
        )
        list.add(
            LayoutUiModel(
                R.drawable.bacground4,
                "Achieve Your Goals",
                "Achieve your goals more easily. This app will help with that"
            )
        )
        return list
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}