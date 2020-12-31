package com.appserba.palugada.ui.masak

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.appserba.palugada.R
import com.appserba.palugada.databinding.FragmentMasakBinding
import com.appserba.palugada.ui.home.MainActivity

class MasakFragment : Fragment() {

    private val parent: MainActivity by lazy { activity as MainActivity }
    private lateinit var binding: FragmentMasakBinding
    private val viewModel: MasakViewModel by lazy { MasakViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMasakBinding.inflate(inflater, container, false).apply {
            viewModel = this@MasakFragment.viewModel
            lifecycleOwner = this@MasakFragment
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        observe()
    }

    private fun observe() {
        viewModel.loading.observe(viewLifecycleOwner){
            binding.swipeRefresh.isRefreshing=it
        }
        viewModel.actionState.observe(viewLifecycleOwner){
            if(it.isConsumed){
                Log.i("ActionState", "isConsumed")
            }else if (!it.isSuccess){
                Toast.makeText(parent, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun init() {
        binding.recyclerView.adapter = MasakAdapter(parent)
        viewModel.listMasak()
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.listMasak()
        }
    }

}