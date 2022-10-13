package com.bela.hyperchicks.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bela.hyperchicks.AdapterProduk
import com.bela.hyperchicks.R
import com.bela.hyperchicks.model.Produk
import com.inyongtisto.tutorial.adapter.AdapterSlider

class HomeFragment : Fragment() {

    lateinit var vpslider: ViewPager
    lateinit var rvProduk: RecyclerView
    lateinit var rvProdukDiskon: RecyclerView
    lateinit var rvProdukTerlaris: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpslider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvProdukDiskon = view.findViewById(R.id.rv_produkDiskon)
        rvProdukTerlaris = view.findViewById(R.id.rv_produkTerlaris)

        val  arrslider = ArrayList<Int>()
        arrslider.add(R.drawable.slider1)
        arrslider.add(R.drawable.slider2)
        arrslider.add(R.drawable.slider3)
        arrslider.add(R.drawable.slider4)

        val adapterSlider = AdapterSlider(arrslider, activity)
        vpslider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        rvProdukDiskon.adapter = AdapterProduk(arrProdukDiskon)
        rvProdukDiskon.layoutManager = layoutManager2

        rvProdukTerlaris.adapter = AdapterProduk(arrProdukTerlaris)
        rvProdukTerlaris.layoutManager = layoutManager3

        return view
    }

    val arrProduk: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Chicken Nugget + Sosis Sauce Mayo"
        p1.harga = "Rp.25.000"
        p1.gambar = R.drawable.chicken_nugget

        val p2 = Produk()
        p2.nama = "Thai Cill Chicken Wings"
        p2.harga = "Rp.25.000"
        p2.gambar = R.drawable.chickenwings

        val p3 = Produk()
        p3.nama = "Chicken D'krezz"
        p3.harga = "Rp.25.000"
        p3.gambar = R.drawable.img

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)

        return arr
    }


   val arrProdukDiskon: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Chicken Nugget + Sosis Sauce Mayo"
        p1.harga = "Rp.25.000"
        p1.gambar = R.drawable.chicken_nugget

        val p2 = Produk()
        p2.nama = "Thai Cill Chicken Wings"
        p2.harga = "Rp.25.000"
        p2.gambar = R.drawable.chickenwings

        val p3 = Produk()
        p3.nama = "Chicken D'krezz"
        p3.harga = "Rp.25.000"
        p3.gambar = R.drawable.img

        arr.add(p2)
        arr.add(p1)
        arr.add(p3)

        return arr
    }


    val arrProdukTerlaris: ArrayList<Produk>get(){
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Chicken Nugget + Sosis Sauce Mayo"
        p1.harga = "Rp.25.000"
        p1.gambar = R.drawable.chicken_nugget

        val p2 = Produk()
        p2.nama = "Thai Cill Chicken Wings"
        p2.harga = "Rp.25.000"
        p2.gambar = R.drawable.chickenwings

        val p3 = Produk()
        p3.nama = "Chicken D'krezz"
        p3.harga = "Rp.25.000"
        p3.gambar = R.drawable.img

        arr.add(p3)
        arr.add(p1)
        arr.add(p2)

        return arr
    }


}