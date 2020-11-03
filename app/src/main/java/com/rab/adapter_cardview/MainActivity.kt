package com.rab.adapter_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.rab.adapter_cardview.adapter.ProdukAdapter
import com.rab.adapter_cardview.models.Produk
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.daftar_produk.*

class MainActivity : AppCompatActivity() {

    private var products : ArrayList<Produk> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProduct.layoutManager = GridLayoutManager(this, 2)

        var price = 2000
        for (i in 1..10) {
            price += i * 10
            val product = Produk("Nama Produk $i","Harga Rp. $price")
            products.add(product)
        }

        rvProduct.adapter = ProdukAdapter(products)
    }
}