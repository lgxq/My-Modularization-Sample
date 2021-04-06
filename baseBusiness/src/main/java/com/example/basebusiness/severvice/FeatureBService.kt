package com.example.basebusiness.severvice

import androidx.navigation.NavController
import com.example.customerannotation.FeatureService

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */
@FeatureService
interface FeatureBService {
    fun startFeatureBFragment(navController: NavController, initString: String)
}