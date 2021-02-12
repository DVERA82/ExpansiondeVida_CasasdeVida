package com.example.expansiondevida_casasdevida.ui

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expansiondevida_casasdevida.databinding.ItemCdvBinding
import com.example.expansiondevida_casasdevida.databinding.ItemInfoBinding
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida

class AdapterCDVinfo : RecyclerView.Adapter<AdapterCDVinfo.InfoViewHolder>() {

    private var listcdv = listOf<CasaDeVida>()

    private var selectedItem = MutableLiveData<CasaDeVida>()
    fun selectedItem(): LiveData<CasaDeVida> = selectedItem
    fun update(list: List<CasaDeVida>) {
        listcdv = list
        notifyDataSetChanged()
    }

    inner class InfoViewHolder(private val binding: ItemInfoBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(casaDeVida: CasaDeVida) {
            binding.imageViewFoto.toString()
            binding.tvNombreLider.text = listcdv.toString()
            binding.tvDia.text= listcdv.toString()
            binding.tvHora.text= listcdv.toString()
            binding.tvDireccion.text = listcdv.toString()
            binding.tvComuna.text= listcdv.toString()
            binding.tvCelular.text = listcdv.toString()
            binding.tvCorreo.text= listcdv.toString()
         Glide.with(binding.imageViewFoto)
             .load(casaDeVida)
             .into(binding.imageViewFoto)

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedItem.value = listcdv[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        return InfoViewHolder(ItemInfoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val cdvDataClass =  listcdv[position]
        holder.bind(cdvDataClass)
    }


    override fun getItemCount(): Int = listcdv.size



}

