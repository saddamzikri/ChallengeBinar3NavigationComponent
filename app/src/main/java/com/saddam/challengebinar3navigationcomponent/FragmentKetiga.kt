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

                val pengeluaran = gaji - iuranBulanan - belanja

                tvGaji.text = "Gaji Anda : $gaji"
                tvIuranBulanan.text = "Iuran Bulanan anda sebesar : $iuranBulanan"
                tvBelanja.text = "Jumlah Belanjaan anda adalah : $belanja"
                tvPengeluaran.text = "Pengeluaran anda adalah sebesar: $pengeluaran"
                btnScreen3.visibility = View.GONE
                tvGaji.visibility = View.VISIBLE
                tvIuranBulanan.visibility = View.VISIBLE
                tvBelanja.visibility = View.VISIBLE
                tvPengeluaran.visibility = View.VISIBLE

            } else {
                tvGaji.visibility = View.GONE
                tvIuranBulanan.visibility = View.GONE
                tvBelanja.visibility = View.GONE
                tvPengeluaran.visibility = View.GONE
            }
        }

    }

}