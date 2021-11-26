package com.eylulcan.viewpagerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.eylulcan.viewpagerexample.databinding.FragmentOnboardingBinding

class OnboardingFragment(private val imageId: Int) : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)
        binding = FragmentOnboardingBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.onboardBackgroundImage.setImageResource(imageId)
        binding.onboardButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_menuFragment,
                null,
                NavOptions.Builder().setPopUpTo(R.id.mainFragment, true).build()
            )
        }
    }
}