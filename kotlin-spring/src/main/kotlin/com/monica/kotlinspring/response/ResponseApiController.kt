package com.monica.kotlinspring.response

import com.monica.kotlinspring.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    // GET http://localhost:8080/api/response?age=18
    @GetMapping("")
    fun getMapping(@RequestParam age : Int?): ResponseEntity<String> {

        // 엘비스 연산자
        return age?.let {
            // age not null
            if (it < 20) {
                return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
            }
            ResponseEntity.ok("OK")
        }?: kotlin.run {
            // age is null
            return ResponseEntity.status(400).body("age 값이 누락되었습니다.")
        }

        /*
        // 1. age == null -> 400 error
        if (age == null) {
            return ResponseEntity.status(400).body("age의 값이 누락되었습니다.")
        }
        // 2. age < 20 -> 400 error
        if (age < 20) {
            return ResponseEntity.status(400).body("age의 값은 20보다 커야 합니다.")
        }
        return ResponseEntity.ok("OK")
         */
    }

    // 2. post 200
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(200).body(userRequest)
    }

    // 3. put 201
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 1. 기존 데이터가 없어서 새로 생성했다.
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Int): ResponseEntity<Nothing> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}