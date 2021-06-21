package com.example.abas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.abas.fragment.EmAltaFragment
import com.example.abas.fragment.HomeFragment
import com.example.abas.fragment.InscricoesFragment
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems


class MainActivity : AppCompatActivity() {
    lateinit var smartTabLayout: SmartTabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smartTabLayout = findViewById(R.id.viewPagerTab)
        viewPager = findViewById(R.id.viewPager)

        //Recuperando a instancia do ActionBar e setando um elevation
        supportActionBar?.elevation = 0.0F

        //Configurando adapater para as abas
        val adapter = FragmentPagerItemAdapter(
                supportFragmentManager,
                FragmentPagerItems.with(this)
                        .add("Home", HomeFragment::class.java)
                        .add("Inscrições", InscricoesFragment::class.java)
                        .add("Em Alta", EmAltaFragment::class.java)
                        .create()

        )

        //Setando o adapter para o viewpager
        viewPager.adapter = adapter

        //Setando o viewPager para as Abas
        smartTabLayout.setViewPager(viewPager)
    }
}