package com.ssu.portfolio.fooddeliveryapp.common

 sealed class ResultState <out T>{
     data class  Success<T> (val  data:T): ResultState<T>()
     data class  Error<T> (val message: String): ResultState<T>()
     object  Loading: ResultState<Nothing>()
 }