package com.man.myexpensesbackend.dtos

import java.time.LocalDate

data class ExpenseResponseDTO(
    val id: Long,
    val title: String,
    val amount: Double,
    val category: String,
    val date: LocalDate,
    val userId: Long,
)