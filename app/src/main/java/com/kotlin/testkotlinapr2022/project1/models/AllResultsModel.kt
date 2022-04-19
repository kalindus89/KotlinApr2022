package com.kotlin.testkotlinapr2022.project1.models

data class AllResultsModel (val items:ArrayList<BasicDataModel>)

data class BasicDataModel (val name:String, val description:String, val owner:Owner)

data class Owner (val avatar_url:String)

