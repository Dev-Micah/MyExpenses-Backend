package com.man.myexpensesbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MyExpensesBackendApplication

fun main(args: Array<String>) {
    runApplication<MyExpensesBackendApplication>(*args)
}
