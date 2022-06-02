package nl.rabobank.online

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["nl.rabobank.*"])
class NonBlockingCakeServiceApplication

fun main() {
    runApplication<NonBlockingCakeServiceApplication>()
}