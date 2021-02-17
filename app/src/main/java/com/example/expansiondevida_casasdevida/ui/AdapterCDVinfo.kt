
package com.example.expansiondevida_casasdevida.ui


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.expansiondevida_casasdevida.databinding.ItemInfoBinding
import com.example.expansiondevida_casasdevida.pojo.CasaDeVida

class AdapterCDVinfo : RecyclerView.Adapter<AdapterCDVinfo.InfoViewHolder>() {

    private var listcdv = listOf<CasaDeVida>()

    private var selectedItem = MutableLiveData<CasaDeVida>()
    fun selectedItem() = selectedItem

    fun update(list: List<CasaDeVida>) {
        listcdv = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        return InfoViewHolder(ItemInfoBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val cdvDataClass = listcdv[position]
        holder.bind(cdvDataClass)
    }


    override fun getItemCount(): Int = listcdv.size


    inner class InfoViewHolder(private val binding: ItemInfoBinding) :
            RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(casaDeVida: CasaDeVida) {

            binding.tvNombreLider.text = casaDeVida.nombre_lider
            binding.tvDia.text = casaDeVida.dia
            binding.tvHora.text = casaDeVida.hora
            binding.tvDireccion.text = casaDeVida.direccion
            binding.tvComuna.text = casaDeVida.comuna
            binding.tvCelular.text = casaDeVida.celular
            binding.tvCorreo.text = casaDeVida.correo
            Glide.with(binding.imageViewFoto)
                    .load(casaDeVida.foto)
                    .into(binding.imageViewFoto)

            if (casaDeVida.favourite) {
                binding.ivFav.setColorFilter(Color.RED)
            } else {
                binding.ivFav.setColorFilter(Color.BLACK)
            }
            itemView.setOnClickListener(this)
        }



        override fun onClick(v: View?) {
            selectedItem.value = listcdv[adapterPosition]


        }


    }

}