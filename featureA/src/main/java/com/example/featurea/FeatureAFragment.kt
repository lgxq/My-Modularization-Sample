package com.example.featurea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.basebusiness.BaseFragment
import com.example.basebusiness.EXTRA_KEY_START_FRAGMENT_INPUT
import com.example.basebusiness.REQUEST_KEY_START_FRAGMENT_B
import com.example.basebusiness.data.UserDataManager
import com.example.basebusiness.severvice.FeatureServiceFactory
import com.example.featurea.databinding.FragmentFeatureABinding

/**
 * create by gaoxin.liu at 7/7/20
 * @description
 */

class FeatureAFragment : BaseFragment() {
    private lateinit var viewModel: FeatureAViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentFeatureABinding = DataBindingUtil.inflate(inflater, R.layout.fragment_feature_a, container, false)
        viewModel = ViewModelProvider(this).get(FeatureAViewModel::class.java)

        binding.fragment = this
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        //on fragment result
        parentFragmentManager.setFragmentResultListener(REQUEST_KEY_START_FRAGMENT_B, viewLifecycleOwner, FragmentResultListener { requestKey, bundle ->
            if (requestKey == REQUEST_KEY_START_FRAGMENT_B) {
                val string = bundle.getString(EXTRA_KEY_START_FRAGMENT_INPUT)
                viewModel.textViewLiveData.value = string ?: ""
            }
        })

        return binding.root
    }

    fun onStartFeatureBClick(view: View) {
        FeatureServiceFactory.getFeatureBService().startFeatureBFragment(findNavController(), viewModel.textViewLiveData.value ?: "")
    }

    fun onSaveUserIdClick(view: View) {
        UserDataManager.userId = viewModel.textUserIdLiveData.value ?: ""
        Toast.makeText(context, "Has saved", Toast.LENGTH_SHORT).show()
    }
}