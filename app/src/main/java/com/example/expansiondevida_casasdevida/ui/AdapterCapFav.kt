package com.example.expansiondevida_casasdevida.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expansiondevida_casasdevida.databinding.ItemCapfavBinding
import com.example.expansiondevida_casasdevida.databinding.ItemInfoBinding
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida

class AdapterCapFav :RecyclerView.Adapter<AdapterCapFav.CapViewHolder>() {

    private var listcdv = listOf<CasaDeVida>()

    private var selectedItem = MutableLiveData<CasaDeVida>()
    fun selectedItem() = selectedItem

    fun update(list: List<CasaDeVida>) {
        listcdv = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CapViewHolder {
        return CapViewHolder(ItemCapfavBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AdapterCapFav.CapViewHolder, position: Int) {
        val cdvDataClass = listcdv[position]
        holder.bind(cdvDataClass)
    }


    override fun getItemCount(): Int = listcdv.size


    inner class CapViewHolder(private val binding: ItemCapfavBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(casaDeVida: CasaDeVida) {
            if (casaDeVida.favourite) {
                binding.tvNombreLider2.text = casaDeVida.nombre_lider
                binding.tvIdCdv2.text = casaDeVida.id
                Glide.with(binding.imageViewFoto2)
                    .load(casaDeVida.foto)
                    .into(binding.imageViewFoto2)
            }
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            selectedItem.value = listcdv[adapterPosition]


        }


    }

}