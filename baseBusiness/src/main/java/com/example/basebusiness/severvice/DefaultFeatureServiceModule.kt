package com.example.basebusiness.severvice

import org.koin.dsl.module

/**
 * create by gaoxin.liu at 7/13/20
 * @description
 */

val defaultFeatureBServiceModule = module {
    factory<FeatureBService> { DefaultFeatureBServiceImpl() }
}

val defaultFeatureAServiceModule = module {
    factory<FeatureAService> { DefaultFeatureAServiceImpl() }
}