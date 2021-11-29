package com.example

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.AutoCleanup
import spock.lang.Specification
import jakarta.inject.Inject

@MicronautTest(contextBuilder = EagerInitSingletonsApplicationContextBuilder)
class DemoSpec extends Specification {

//    @Inject
//    EmbeddedApplication<?> application

    @AutoCleanup
    @Client('/')
    @Inject
    HttpClient client

    void 'test it works'() {
        expect:
        true
    }

}
