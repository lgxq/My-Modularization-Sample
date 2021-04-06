package com.example.featureb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.basebusiness.BaseFragment
import com.example.basebusiness.EXTRA_KEY_INIT_INPUT_FRAGMENT_B
import com.example.basebusiness.EXTRA_KEY_START_FRAGMENT_INPUT
import com.example.basebusiness.REQUEST_KEY_START_FRAGMENT_B
import com.example.basebusiness.data.UserDataManager
import com.example.basebusiness.severvice.FeatureServiceFactory
import com.example.featureb.databinding.FragmentFeatureBBinding

/**
 * create by gaoxin.liu at 7/7/20
 * @description
 */

class FeatureBFragment : BaseFragment() {
    private lateinit var viewModel: FeatureBViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentFeatureBBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_feature_b, container, false)
        viewModel = ViewModelProvider(this).get(FeatureBViewModel::class.java)

        binding.fragment = this
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        initView()

        return binding.root
    }

    private fun initView() {
        val initString = arguments?.getString(EXTRA_KEY_INIT_INPUT_FRAGMENT_B)
        viewModel.editTextLiveData.value = initString ?: ""

        val userId = UserDataManager.userId
        if (userId.isNotEmpty()) {
            viewModel.userIdLiveData.value = "User ID: $userId"
        }
    }

    fun onFinishClick(view: View) {
        parentFragmentManager.setFragmentResult(REQUEST_KEY_START_FRAGMENT_B, Bundle().apply {
            putString(EXTRA_KEY_START_FRAGMENT_INPUT, viewModel.editTextLiveData.value)
        })

        findNavController().popBackStack()
    }
}