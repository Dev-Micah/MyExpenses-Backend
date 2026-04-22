package com.man.myexpensesbackend.controller

import com.man.myexpensesbackend.dtos.ExpenseRequestDTO
import com.man.myexpensesbackend.service.ExpenseService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/expenses")
class ExpenseController(private val service: ExpenseService) {

    @GetMapping
    fun getAllExpenses() = service.getAllExpenses()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = service.findById(id)


    @GetMapping("/user/{userId}")
    fun getByUser(@PathVariable userId: Long) =
        service.getByUser(userId)

    @PostMapping
    fun create(@RequestBody dto: ExpenseRequestDTO) =
        service.createExpense(dto)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody dto: ExpenseRequestDTO
    ) = service.updateExpense(id, dto)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.deleteExpense(id)
}