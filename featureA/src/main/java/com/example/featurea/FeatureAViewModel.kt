package com.example.featurea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */
class FeatureAViewModel : ViewModel() {
    val textViewLiveData = MutableLiveData("Init Message")
    val textUserIdLiveData = MutableLiveData("")
}