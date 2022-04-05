package com.kotlin.testkotlinapr2022.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel: ViewModel() {

    var activityOne = 1
    var activityTwo = 2
    var activityThree = 3

    val changeActivityId = MutableLiveData<Int>()

    fun onChangeToFirstProject() {
        changeActivityId.value=activityOne
    }

    fun onChangeToTwoProject() {
        changeActivityId.value=activityTwo
    }

    fun onChangeToThirdProject() {
        changeActivityId.value=activityThree
    }
}