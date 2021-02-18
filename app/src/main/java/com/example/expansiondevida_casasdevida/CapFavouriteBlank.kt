package com.example.expansiondevida_casasdevida

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expansiondevida_casasdevida.databinding.FragmentCapFavouriteBlankBinding
import com.example.expansiondevida_casasdevida.databinding.FragmentSecondBinding
import com.example.expansiondevida_casasdevida.ui.AdapterCDVinfo
import com.example.expansiondevida_casasdevida.ui.AdapterCapFav
import com.example.expansiondevida_casasdevida.viewmodel.ViewModelCdv

//ss
class CapFavouriteBlank : Fragment() {

    private lateinit var binding: FragmentCapFavouriteBlankBinding
    private val viewModel: ViewModelCdv by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCapFavouriteBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       var adapter = AdapterCapFav()

        binding.rvCapFav.adapter= adapter
        binding.rvCapFav.layoutManager = GridLayoutManager(context,1)
        viewModel.getAllFavouriteFoto().observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

}