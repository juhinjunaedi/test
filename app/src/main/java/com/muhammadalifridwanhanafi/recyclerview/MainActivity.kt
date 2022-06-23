package com.muhammadalifridwanhanafi.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammadalifridwanhanafi.recyclerview.adapter.AdapterTeamBola
import com.muhammadalifridwanhanafi.recyclerview.databinding.ActivityMainBinding
import com.muhammadalifridwanhanafi.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listpemain = ArrayList<Pemain>()
        listpemain.add(Pemain("Albert",R.drawable.albert, "Jungler", "Bali", "8 Januari 2004",))
        listpemain.add(Pemain("Lemon",R.drawable.llemon, "All Role", "Banda Aceh", "30 Desember 1998"))
        listpemain.add(Pemain("Psyco",R.drawable.psyco, "Midlaner", "Pontianak", "5 Februari 2000"))
        listpemain.add(Pemain("R7",R.drawable.r7, "EXPlaner + Captain", "Bandung", "6 Oktober 1998"))
        listpemain.add(Pemain("VYN",R.drawable.vyn, "Roamer", "Jakarta", "3 September 2000"))
        listpemain.add(Pemain("XIN",R.drawable.xin, "Assassin/Marksman", "Manado", "2 Desember 1998"))

        binding.list.adapter = AdapterTeamBola(this, listpemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
                TODO("Not yet implemented")
            }

        })
    }
}