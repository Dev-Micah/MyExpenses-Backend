package com.man.myexpensesbackend.dtos


import java.time.LocalDate

data class ExpenseRequestDTO(
    val title: String,
    val amount: Double,
    val category: String,
    val date: LocalDate
)