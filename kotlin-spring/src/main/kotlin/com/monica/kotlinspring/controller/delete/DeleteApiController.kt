package com.monica.kotlinspring.controller.delete

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping(path = ["/delete-mapping"])
    fun deletemapping(
        @RequestParam(value = "name") _name : String,
        @RequestParam(value = "age") _age : Int
    ): String{
        println(_name)
        println(_age)
        return "$_name $_age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMapping(@PathVariable(value = "name") _name:String, @PathVariable(name = "age") _age:Int): String {
        println(_name)
        println(_age)
        return "$_name $_age"
    }
}