package com.example.modulelization

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * create by gaoxin.liu at 7/8/20
 * @description
 */
class MainViewModel : ViewModel() {
    val buttonText = MutableLiveData("Start Feature A")
}