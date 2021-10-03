package com.monica.kotlinspring.model.http

import com.monica.kotlinspring.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

data class UserRequest(
    // 코틀린에서는 data클래스에서는 field후에 어노테이션 이렇게 붙임
    @field:NotEmpty
    @field:Size(min = 2, max = 8)
    var name:String?=null,

    @field:PositiveOrZero
    var age:Int?=null,

    @field:Email
    var email:String?=null,

    @field:NotBlank
    var address:String?=null,

    @field:Pattern(regexp = "^\\d{2,3}-\\{3,4}-\\d{4}\$")
    var phoneNumber:String?=null, // phone_number

    @StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt:String?=null // yyyy-MM-dd HH:mm:ss
)
