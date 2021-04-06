package com.example.featureb

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */
class FeatureBViewModel : ViewModel() {
    val editTextLiveData = MutableLiveData("")
    val userIdLiveData = MutableLiveData("")
}