package com.fm.bountysystem.rest.hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


@Component
class HelloHandler {

     fun hello(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().body(BodyInserters.fromValue(serviceHello()))
    }

}


