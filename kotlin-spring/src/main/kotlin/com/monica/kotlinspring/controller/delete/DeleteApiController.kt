package com.monica.kotlinspring.controller.delete

import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deletemapping(
        @RequestParam(value = "name") _name : String,

        @NotNull(message  = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age는 20보다 커야 합니다.")
        @RequestParam(value = "age") _age : Int
    ): String{
        println(_name)
        println(_age)
        return "$_name $_age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMapping(@PathVariable(value = "name")
                      @Size(min = 2, max = 5, message = "name의 길이는 2-5")
                      @NotNull
                      _name:String,

                      @NotNull(message  = "age 값이 누락되었습니다.")
                      @Min(value = 20, message = "age는 20보다 커야 합니다.")
                      @PathVariable(name = "age") _age:Int): String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }
}