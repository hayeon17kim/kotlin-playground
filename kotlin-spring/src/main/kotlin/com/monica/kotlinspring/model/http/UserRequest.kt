package com.monica.kotlinspring.model.http

data class UserRequest(
    var name:String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,
    var phoneNumber:String?=null // phone_number
)