package com.man.myexpensesbackend.mapper

import com.man.myexpensesbackend.dtos.ExpenseRequestDTO
import com.man.myexpensesbackend.dtos.ExpenseResponseDTO
import com.man.myexpensesbackend.models.Expense


object ExpenseMapper {

    fun toEntity(dto: ExpenseRequestDTO): Expense {
        return Expense(
            title = dto.title,
            amount = dto.amount,
            category = dto.category,
            date = dto.date
        )
    }

    fun toResponse(expense: Expense):  ExpenseResponseDTO {
        return ExpenseResponseDTO(
            id = expense.id,
            title = expense.title,
            amount = expense.amount,
            category = expense.category,
            date = expense.date
        )
    }
}