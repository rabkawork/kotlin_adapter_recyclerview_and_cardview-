package com.rab.adapter_cardview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rab.adapter_cardview.R
import com.rab.adapter_cardview.models.Produk
import kotlinx.android.synthetic.main.daftar_produk.view.*

class ProdukAdapter(private val context: Context?, val products: ArrayList<Produk>) : RecyclerView.Adapter<ProdukAdapter.ViewHolder>() {
    override fun getItemCount(): Int = products.size



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(
            R.layout.daftar_produk,
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(products.get(position))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var view : View = itemView
        private lateinit var dataProduk : Produk

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View) {
            Toast.makeText(view.context, "${dataProduk.nama} Diklik", Toast.LENGTH_SHORT).show()
        }

        fun bindData(product: Produk) {

            var flags = intArrayOf(
                R.drawable.apple,
                R.drawable.banana,
                R.drawable.lemon,
                R.drawable.cherry,
                R.drawable.strawberrie,
                R.drawable.avocado
            )
            this.dataProduk = product
            view.productImage.setImageResource(flags.get(product.gambar))
            view.productName.setText(product.nama)
            view.productPrice.setText(product.harga.toString())
        }
    }
}