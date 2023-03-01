package com.example.hotelwallet.presentation.welcome

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hotelwallet.R
import com.example.hotelwallet.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding: FragmentViewPagerBinding get() = requireNotNull(_binding)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding.btnNext.setOnClickListener{
            if (binding.pager.currentItem == 2)
                findNavController().navigate(R.id.action_viewPagerFragment_to_scannerFragment)
            else {
                positionVerify(binding.pager.currentItem)
                binding.pager.currentItem++
            }
        }

        binding.btnBack.setOnClickListener {
            binding.pager.currentItem--

            positionVerify(binding.pager.currentItem)
        }

        binding.btnSkip.setOnClickListener  {
            findNavController().navigate(R.id.action_viewPagerFragment_to_scannerFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.fragment = this

        binding.pager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(binding.pagerIndicator, binding.pager) {_,_ ->}.attach()

        binding.pagerIndicator.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let {
                    positionVerify(it)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }

    private fun positionVerify(position: Int) {
        when(position) {
            0 -> {
                binding.btnBack.visibility = View.INVISIBLE
                binding.btnNext.text = getString(R.string.txt_next)
            }
            2 -> {
                binding.btnBack.visibility = View.VISIBLE
                binding.btnNext.text = getString(R.string.txt_go)
            }
            else ->{
                binding.btnBack.visibility = View.VISIBLE
                binding.btnNext.text = getString(R.string.txt_next)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}