package com.example.basebusiness.severvice

import androidx.navigation.NavController
import com.example.customerannotation.FeatureService

/**
 * create by gaoxin.liu at 7/7/20
 * @description
 */

@FeatureService
interface FeatureAService {
    fun startFeatureAMainFragment(navController: NavController)
}