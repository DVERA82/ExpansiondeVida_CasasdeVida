package com.example.expansiondevida_casasdevida.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.expansiondevida_casasdevida.R
import com.example.expansiondevida_casasdevida.databinding.FragmentSecondBinding
import com.example.expansiondevida_casasdevida.viewmodel.ViewModelCdv
import java.util.*


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel: ViewModelCdv by activityViewModels()
    var idCDV: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idCDV = it.getString("LISTA", "")
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = AdapterCDVinfo()
        binding.rvCdv2.adapter = adapter
        binding.rvCdv2.layoutManager = GridLayoutManager(context, 1)

        viewModel.getListCasaDeVida(idCDV).observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let {
                adapter.update(it)
            }
        })
        binding.favouriteCap.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_capFavouriteBlank)
        }

        adapter.selectedItem().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let {
                if (it.favourite) {
                    it.favourite = false
                    viewModel.updateFavouritefoto(it)
                    Toast.makeText(context, "ya no es favorito", Toast.LENGTH_LONG).show()
                } else {

                    it.favourite = true
                    viewModel.updateFavouritefoto(it)
                    Toast.makeText(context, "añadido a fav", Toast.LENGTH_LONG).show()

                }
            }


        })

    }

}
