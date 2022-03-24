package com.saddam.challengebinar3navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.saddam.challengebinar3navigationcomponent.databinding.FragmentPertamaBinding

class FragmentPertama : Fragment() {

    private lateinit var binding: FragmentPertamaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPertamaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScreen1.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentPertama_to_fragmentKedua)
        }
    }

}