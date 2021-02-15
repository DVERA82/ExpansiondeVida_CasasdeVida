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
import com.example.expansiondevida_casasdevida.R
import com.example.expansiondevida_casasdevida.databinding.FragmentSecondBinding
import com.example.expansiondevida_casasdevida.viewmodel.ViewModelCdv
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
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
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var adapter = AdapterCDVinfo()
        binding.rvCdv2.adapter = adapter
        binding.rvCdv2.layoutManager= GridLayoutManager(context,1)

       /* viewModel.getCdvWhithCoroutines().observer(viewLifecycleOwner, Observer (
            it?.let{
                Log.d("LISTADO ", it.toString())
                adapter.update(it)

            }
        })*/
        /*  adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.favority) {
                    it.favority = false
                    viewModel.updateFavorityImages(it)
                    Toast.makeText(context, "ya no es favorito", Toast.LENGTH_LONG).show()
                } else {
                    it.favority = true
                    viewModel.updateFavorityImages(it)
                    Toast.makeText(context, "añadido a fav", Toast.LENGTH_LONG).show()
                }


            }
        })*/
    }

}

