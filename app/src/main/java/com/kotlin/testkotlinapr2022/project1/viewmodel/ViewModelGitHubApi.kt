package com.kotlin.testkotlinapr2022.project1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.testkotlinapr2022.project1.models.AllResultsModel
import com.kotlin.testkotlinapr2022.project1.network.ApiInterface
import com.kotlin.testkotlinapr2022.project1.network.RetrofitInstance
import kotlinx.coroutines.launch

class ViewModelGitHubApi : ViewModel(){

    var allResultsModelLiveData:MutableLiveData<AllResultsModel> = MutableLiveData()

    fun getRecyclerListObserver():MutableLiveData<AllResultsModel>{
        return allResultsModelLiveData
    }

    fun makeApiCall(){

        viewModelScope.launch {

           val retrofitInstance = RetrofitInstance.getRetroInstance().create(ApiInterface::class.java)
           val response= retrofitInstance.userQuery("ka")
            allResultsModelLiveData.postValue(response)

        }

    }



}