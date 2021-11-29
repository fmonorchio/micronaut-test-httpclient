package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.AutoCleanup
import spock.lang.Specification
import spock.lang.Subject

@MicronautTest(contextBuilder = EagerInitSingletonsApplicationContextBuilder)
class DemoSpec extends Specification {

    @AutoCleanup
    @Client('/')
    @Inject
    @Subject
    HttpClient client

    void 'test it works'() {

        given:
        def request = HttpRequest.GET('/demo/test')

        when:
        def response = client.toBlocking()
                .exchange(request)

        then:
        response.status() == HttpStatus.OK
    }

}
