package com.example.expansiondevida_casasdevida.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.expansiondevida_casasdevida.databinding.ItemCdvBinding
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida

class AdapterCDV : RecyclerView.Adapter<AdapterCDV.CdvViewHolder>() {

    private var listcdv = listOf<CasaDeVida>()

    private var selectedItem = MutableLiveData<CasaDeVida>()
    fun selectedItem(): LiveData<CasaDeVida> = selectedItem
    fun update(list: List<CasaDeVida>) {
        listcdv = list
        notifyDataSetChanged()
    }

    inner class CdvViewHolder(private val binding: ItemCdvBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(casaDeVida: CasaDeVida) {
            binding.textView.text = casaDeVida.id
            Log.d("lista casa de vida","${casaDeVida.id}")

            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            selectedItem.value = listcdv[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : AdapterCDV.CdvViewHolder {
      return CdvViewHolder(ItemCdvBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AdapterCDV.CdvViewHolder, position: Int) {
     val cdvDataClass =  listcdv[position]
        holder.bind(cdvDataClass)

    }

    override fun getItemCount(): Int = listcdv.size

    }



