package com.example.modulelization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.basebusiness.BaseFragment
import com.example.basebusiness.severvice.FeatureServiceFactory
import com.example.modulelization.databinding.FragmentMainBinding

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */

class MainFragment : BaseFragment() {
    val observableArrayList = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observableArrayList.observe(this, Observer {  })

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.fragment = this
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    fun onStartClick(view: View) {
        FeatureServiceFactory.getFeatureAService().startFeatureAMainFragment(findNavController())
    }
}