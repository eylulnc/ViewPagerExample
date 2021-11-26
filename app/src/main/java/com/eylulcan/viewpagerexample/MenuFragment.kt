package com.eylulcan.viewpagerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.eylulcan.viewpagerexample.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private val discoverFragment = DiscoverFragment()
    private val genresFragment = GenresFragment()
    private val artistsFragment = ArtistsFragment()
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMenuBinding.bind(view)
        currentFragment(discoverFragment)
        setupBottomNavFragments()
    }

    private fun currentFragment(fragment: Fragment) {
        fragmentManager?.beginTransaction()?.apply {
            replace(R.id.frameLayout,fragment)
            commit()
        }
    }

    private fun setupBottomNavFragments()  {
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.genres -> currentFragment(genresFragment)
                R.id.artists -> currentFragment(artistsFragment)
                R.id.discover -> currentFragment(discoverFragment)
            }
            true
        }
    }
}