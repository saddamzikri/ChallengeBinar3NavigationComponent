package com.saddam.challengebinar3navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.challengechapter3.DataMain
import com.saddam.challengebinar3navigationcomponent.databinding.FragmentKeempatBinding

class FragmentKeempat : Fragment() {

    private lateinit var binding: FragmentKeempatBinding

    val args: FragmentKeempatArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKeempatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnScreen4.setOnClickListener {
            if (binding.edtGaji.text.isNullOrEmpty() || binding.edtIuranBulanan.text.isNullOrEmpty() || binding.edtBelanja.text.isNullOrEmpty()){
                Toast.makeText(requireContext(), "Masih ada kolom yang kosong !", Toast.LENGTH_SHORT).show()
            }
            else {
                val data = DataMain (
                    binding.edtGaji.text.toString().toInt(),
                    binding.edtIuranBulanan.text.toString().toInt(),
                    binding.edtBelanja.text.toString().toInt()
                )
                val hasil = FragmentKeempatDirections.actionFragmentKeempatToFragmentKetiga(data, args.name)
                it.findNavController().navigate(hasil)
            }
        }

    }

}