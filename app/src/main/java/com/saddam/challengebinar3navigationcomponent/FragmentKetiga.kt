package com.saddam.challengebinar3navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.saddam.challengebinar3navigationcomponent.databinding.FragmentKetigaBinding

class FragmentKetiga : Fragment() {

    private lateinit var binding: FragmentKetigaBinding

    val args: FragmentKetigaArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKetigaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userName = args.name
        binding.tvName.text = "Halo, $userName"

        binding.btnScreen3.setOnClickListener {
            val name = FragmentKetigaDirections.actionFragmentKetigaToFragmentKeempat(userName)
            it.findNavController().navigate(name)
        }

        with(binding) {
            val nilai = args.pengeluaran

            if (nilai != null) {
                val gaji = nilai.gaji.toString().toInt()
                val iuranBulanan = nilai.iuranBulanan.toString().toInt()
                val belanja = nilai.belanja.toString().toInt()

                val pengeluaran = iuranBulanan + belanja
                val sisaGaji = gaji - iuranBulanan - belanja

                binding.tvGaji.text = "Gaji Anda : $gaji"
                binding.tvIuranBulanan.text = "Iuran Bulanan anda sebesar : $iuranBulanan"
                binding.tvBelanja.text = "Jumlah Belanjaan anda adalah : $belanja"
                binding.tvPengeluaran.text = "Pengeluaran anda adalah sebesar: $pengeluaran"
                binding.tvSisaGaji.text = "Sisa gaji anda adalah sebesar: $sisaGaji"
                binding.btnScreen3.visibility = View.GONE
                binding.tvGaji.visibility = View.VISIBLE
                binding.tvIuranBulanan.visibility = View.VISIBLE
                binding.tvBelanja.visibility = View.VISIBLE
                binding.tvPengeluaran.visibility = View.VISIBLE
                binding.tvSisaGaji.visibility = View.VISIBLE

            } else {
                binding.tvGaji.visibility = View.GONE
                binding.tvIuranBulanan.visibility = View.GONE
                binding.tvBelanja.visibility = View.GONE
                binding.tvPengeluaran.visibility = View.GONE
            }
        }

    }

}