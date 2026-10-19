package com.example.nantawiltawijaya_3tib.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.nantawiltawijaya_3tib.DetailActivity
import com.example.nantawiltawijaya_3tib.Home.pertemuan_5.LimaActivity
import com.example.nantawiltawijaya_3tib.Home.pertemuan_6.SixthActivity
import com.example.nantawiltawijaya_3tib.LoginActivity
import com.example.nantawiltawijaya_3tib.R
import com.example.nantawiltawijaya_3tib.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = requireActivity().intent.getStringExtra("username")
        val pass = requireActivity().intent.getStringExtra("password")
        val umur = requireActivity().intent.getIntExtra("umur", 0)

        Log.e("Hasil", "umur $umur")


        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Item dihapus",
                Snackbar.LENGTH_LONG
            )
                .setAction("BATAL") {

                }
                .show()
        }

        binding.btnAlert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus data")
                .setMessage("Apakah Anda yakin ingin LogOut?")
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .setPositiveButton("Ya") { dialog, _ ->
                    // Pindah ke halaman Login dan hapus riwayat activity
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setCancelable(false)
                .show()
        }

        binding.btnKembali.setOnClickListener {
//            val intent = Intent(this, LoginActivity :: class.java)
//            startActivity(intent) gak perlu dibikin kalau mau langsung keluar.

            requireActivity().finish()
        }

        binding.btnToLima.setOnClickListener {
            startActivity(Intent(requireContext(), LimaActivity::class.java))
        }

        binding.btnToEnam.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }

        binding.btnLogOut.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

}