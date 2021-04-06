package com.example.basebusiness.severvice

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */

object FeatureServiceFactory {
    private val featureAServiceImpl: FeatureAService by inject()
    private val featureBServiceImpl: FeatureBService by inject()

    fun getFeatureAService(): FeatureAService {
        return featureAServiceImpl
    }

    fun getFeatureBService(): FeatureBService {
        return featureBServiceImpl
    }
}