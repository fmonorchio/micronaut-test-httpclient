package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller('/demo')
class DemoController {

    @Get(uri = '/test', produces = 'text/plain')
    String demo() {
        return 'demo'
    }

}
