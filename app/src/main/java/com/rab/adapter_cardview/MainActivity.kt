package com.rab.adapter_cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.rab.adapter_cardview.adapter.ProdukAdapter
import com.rab.adapter_cardview.models.Produk
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.daftar_produk.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    private var products : ArrayList<Produk> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vowels_list: List<String> = listOf("apple", "banana", "lemon", "strawberrie", "cherry","avocado")
        rvProduct.layoutManager = GridLayoutManager(this, 2)

        var price = 2000
        for (i in 1..20) {
            price += i * 10
            var rand = (0..5).random()
            val namaProduk = "Buah " + vowels_list.get(rand)
            val product = Produk("Nama Produk : $namaProduk","Harga Rp. $price",rand)
            products.add(product)
        }

        rvProduct.adapter = ProdukAdapter(applicationContext, products)
    }
}