package com.man.myexpensesbackend.repository

import com.man.myexpensesbackend.models.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository : JpaRepository<Expense, Any> {
    fun findByUserId(userId: Long): List<Expense>
}