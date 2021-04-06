package com.example.featureb

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.basebusiness.EXTRA_KEY_INIT_INPUT_FRAGMENT_B
import com.example.basebusiness.severvice.FeatureBService
import org.koin.dsl.module

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */

class FeatureBServiceImpl : FeatureBService {
    override fun startFeatureBFragment(navController: NavController, initString: String) {
        val bundle = bundleOf(EXTRA_KEY_INIT_INPUT_FRAGMENT_B to initString)
        navController.navigate(R.id.nav_root_feature_b, bundle)
    }
}

val featureBServiceModule = module {
    factory<FeatureBService> { FeatureBServiceImpl() }
}