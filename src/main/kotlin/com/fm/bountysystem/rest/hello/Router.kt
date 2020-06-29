package com.fm.bountysystem.rest.hello

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.*


@Configuration
class Router{

    @Bean
    fun route(helloHandler: HelloHandler) = router {
        GET("/hello", helloHandler::hello)
        POST("/hello")
    }
}


