package com.muhammadalifridwanhanafi.recyclerview

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtPosisiPemain)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahirPemain)
                    val tanggallahir = this.findViewById<TextView>(R.id.txtTanggalLahirPemain)
                    val btn = this.findViewById<TextView>(R.id.btnclose)


                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener{
                        this.dismiss()
                    }
                }.show()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode : Int) {
        when (selectedMode) {
            R.id.MyProfile -> {
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
            }
        }
    }
}