package com.example.nantawiltawijaya_3tib.Message

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nantawiltawijaya_3tib.R
import com.example.nantawiltawijaya_3tib.databinding.ActivityMessageBinding
import kotlin.math.acos

class MessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMessageBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var nama = intent.getStringExtra("SENDER")
        var pesan = intent.getStringExtra("PESAN")

        binding.txtNama.text = nama
        binding.txtPesan.text = pesan
    }
}