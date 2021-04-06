package com.example.featurea

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.basebusiness.severvice.FeatureAService
import org.koin.dsl.module

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */
class FeatureAServiceImpl : FeatureAService {
    override fun startFeatureAMainFragment(navController: NavController) {
        val navBuilder = NavOptions.Builder()
        navController.currentDestination?.let { navBuilder.setPopUpTo(it.id, false) }
        navController.navigate(R.id.nav_root_feature_a)

        navController.navigate(R.id.featureAFragment, null, navBuilder.build())
    }
}

val featureAServiceModule = module {
    factory<FeatureAService> { FeatureAServiceImpl() }
}