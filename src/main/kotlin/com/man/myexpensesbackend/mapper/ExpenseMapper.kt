package com.man.myexpensesbackend.mapper

import com.man.myexpensesbackend.dtos.ExpenseRequestDTO
import com.man.myexpensesbackend.dtos.ExpenseResponseDTO
import com.man.myexpensesbackend.models.Expense
import com.man.myexpensesbackend.models.User


object ExpenseMapper {

    fun toEntity(dto: ExpenseRequestDTO, user: User): Expense {
        return Expense(
            title = dto.title,
            amount = dto.amount,
            category = dto.category,
            date = dto.date,
            user = user
        )
    }

    fun toResponse(expense: Expense):  ExpenseResponseDTO {
        return ExpenseResponseDTO(
            id = expense.id,
            title = expense.title,
            amount = expense.amount,
            category = expense.category,
            date = expense.date,
            userId = expense.user.id
        )
    }
}