package com.saddam.challengebinar3navigationcomponent

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challengechapter3.DataMain
import com.saddam.challengebinar3navigationcomponent.databinding.FragmentKeduaBinding

class FragmentKedua : Fragment() {

    private lateinit var binding: FragmentKeduaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKeduaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScreen2.setOnClickListener {
            if (binding.edtName.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Kolom Nama Masih Kosong !", Toast.LENGTH_SHORT).show()
            }
            else {
                val action = FragmentKeduaDirections.actionFragmentKeduaToFragmentKetiga(null, binding.edtName.text.toString())
                it.findNavController().navigate(action)
            }
        }
    }

}

