package com.justfriend.pengenalannamabinatang

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_play->{
                val pindah=Intent(this@MainActivity,Play::class.java)
                startActivity(pindah)
            }
            R.id.btn_about->{
                AlertDialog.Builder(this)
                    .setTitle("Tentang Aplikasi")
                    .setMessage("Pengenalan Binatang Versi 1.0\nCreated by Erwin Aji Nugroho\njustfriend-dev.com")
                    .setPositiveButton("Tutup", null)
                    .show()
            }
            R.id.btn_close->{
                AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Keluar Dari Aplikasi")
                    .setMessage("Apakah Anda Ingin Keluar Dari Aplikasi?")
                    .setPositiveButton("Ya", { dialog, which -> finish() })
                    .setNegativeButton("Tidak", null)
                    .show()
            }
        }
    }

    lateinit var a:Button
    lateinit var b:Button
    lateinit var c:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a=findViewById(R.id.btn_play)
        b=findViewById(R.id.btn_about)
        c=findViewById(R.id.btn_close)

        a.setOnClickListener(this)
        b.setOnClickListener(this)
        c.setOnClickListener(this)
    }
}
