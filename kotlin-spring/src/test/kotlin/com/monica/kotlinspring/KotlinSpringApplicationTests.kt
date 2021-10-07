package com.monica.kotlinspring

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*

@WebMvcTest
@SpringBootTest
class KotlinSpringApplicationTests {

	@Autowired
	lateinit var mockMvc : MockMvc

	@Test
	fun helloTest() {
			mockMvc.perform(
				get("/api/exception/hello")
			).andExpect {
				status().isOk
			}.andExpect(
				content().string("hello")
			).andDo(print())
		}
	}

}
