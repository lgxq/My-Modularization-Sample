package com.example.basebusiness.severvice

import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

/**
 * create by gaoxin.liu at 7/9/20
 * @description
 */

inline fun <reified T : Any> FeatureServiceFactory.inject(
    qualifier: Qualifier? = null,
    noinline parameters: ParametersDefinition? = null
) = lazy { org.koin.core.context.GlobalContext.get().koin.get<T>(qualifier, parameters) }