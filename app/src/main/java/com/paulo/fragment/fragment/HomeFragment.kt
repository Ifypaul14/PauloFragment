package com.paulo.fragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.paulo.fragment.R
import com.paulo.fragment.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        manager = requireActivity().supportFragmentManager
        binding.apply {
            nextButton.setOnClickListener {
                openNextFragment()
            }
        }


        return binding.root

    }

    private fun openNextFragment() {
        manager.commit {
            replace<NewFragment>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("")
        }

    }

    private fun openNextFragment() {
        manager.beginTransaction()
            .replace(R.id.fragmentContainerView, NewFragment::class.java, null)
            .setReorderingAllowed(true)
            .addToBackStack("")
    }

}