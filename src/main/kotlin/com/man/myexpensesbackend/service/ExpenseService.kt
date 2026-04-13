package com.man.myexpensesbackend.service

import com.man.myexpensesbackend.config.NotFoundException
import com.man.myexpensesbackend.dtos.ExpenseRequestDTO
import com.man.myexpensesbackend.dtos.ExpenseResponseDTO
import com.man.myexpensesbackend.mapper.ExpenseMapper
import com.man.myexpensesbackend.repository.ExpenseRepository
import org.springframework.stereotype.Service

@Service
class ExpenseService(private val repository: ExpenseRepository) {
    fun getAllExpenses(): List<ExpenseResponseDTO> = repository.findAll().map {
        ExpenseMapper.toResponse(it)
    }

    fun findById(id: Long): ExpenseResponseDTO{
        val expense = repository.findById(id)
            .orElseThrow{ NotFoundException("Expense not found") }

        return ExpenseMapper.toResponse(expense)
    }

    fun createExpense(dto: ExpenseRequestDTO): ExpenseResponseDTO {
        val expense = ExpenseMapper.toEntity(dto)
        return ExpenseMapper.toResponse(repository.save(expense))
    }

    fun updateExpense(id: Long, dto: ExpenseRequestDTO): ExpenseResponseDTO {
        val existing = repository.findById(id)
            .orElseThrow { NotFoundException("Expense not found") }

        val updated = existing.copy(
            title = existing.title,
            amount = existing.amount,
            category = existing.category,
            date = existing.date,
        )

        return ExpenseMapper.toResponse(repository.save(updated))
    }

    fun deleteExpense(id: Long) {
        if (!repository.existsById(id))
            throw NotFoundException("Expense not found")
        repository.deleteById(id)
    }

}