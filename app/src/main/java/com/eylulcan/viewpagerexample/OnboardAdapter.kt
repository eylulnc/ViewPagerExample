package com.eylulcan.viewpagerexample

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

private const val FRAGMENT_COUNT = 3

class OnboardAdapter(activity: MainFragment) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return FRAGMENT_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment(R.drawable.onboard1)
            1 -> OnboardingFragment(R.drawable.onboard2)
            2 -> OnboardingFragment(R.drawable.onboard3)
            else -> OnboardingFragment(R.drawable.onboard1)
        }
    }
}