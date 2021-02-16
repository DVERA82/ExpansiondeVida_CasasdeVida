package com.example.expansiondevida_casasdevida.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.expansiondevida_casasdevida.R
import com.example.expansiondevida_casasdevida.databinding.FragmentFirstBinding
import com.example.expansiondevida_casasdevida.viewmodel.ViewModelCdv

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding:FragmentFirstBinding
    private val viewModel: ViewModelCdv by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = AdapterCDV()
        binding.rvListId.adapter = adapter
        binding.rvListId.layoutManager = GridLayoutManager(context,1)

        viewModel.liveDataFromCdv.observe(viewLifecycleOwner,Observer{
          it?.let{
              Log.d("LISTADO", it.toString())
              adapter.update(it)
          }
        })
        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
           it?.let{
               Log.d("lista casa de vida","it.id")
               val bundle= Bundle()
               bundle.putString("LISTA",it.id)
               viewModel.getCdvWhithCoroutines(it.id)
               findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,bundle)
           }

        })

    }
}