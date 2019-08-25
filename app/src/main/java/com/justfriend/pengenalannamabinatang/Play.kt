package com.justfriend.pengenalannamabinatang

import android.app.Activity
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView

class Play : AppCompatActivity() {
    lateinit var pager:ViewPager
    internal var nama= arrayOf("Singa","Monyet","Gajah")
    internal var gambar= intArrayOf(R.drawable.singa,R.drawable.monyet,R.drawable.gajah)
    internal var suara= intArrayOf(R.raw.suara_singa,R.raw.suara_simpanse,R.raw.suara_gajah)
    lateinit var adapter: PagerAdapter
    internal var mp:MediaPlayer?=null
    var onPage:
            ViewPager.OnPageChangeListener= object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {
            if(mp!=null){
                mp!!.reset()
                mp!!.release()
            }
            mp= MediaPlayer.create(this@Play,suara[position])
            mp!!.start()
        }

        override fun onPageScrollStateChanged(state: Int) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_play)
        pager=findViewById(R.id.viewPager)
        adapter=GambarAdapter(this,gambar,nama)
        pager.adapter=adapter
        pager.setOnPageChangeListener(onPage)
    }

    private inner class GambarAdapter(play: Play, internal var gambar:IntArray, internal var nama:Array<String>):PagerAdapter(){
        lateinit var inflater:LayoutInflater
        internal var activity: Activity
        init {
            this.activity=play
        }
        override fun getCount(): Int {
            return gambar.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view===`object` as ScrollView }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            inflater = activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val tampil=inflater.inflate(R.layout.item_view_pager, container,false)
            val img=tampil.findViewById(R.id.imgBinatang) as ImageView
            val text=tampil.findViewById(R.id.textBinatang) as TextView
            img.setImageResource(gambar[position])
            text.text=nama[position]
            (container as ViewPager).addView(tampil)
            return tampil
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            (container as ViewPager).removeView(`object` as ScrollView)
        }
    }
}