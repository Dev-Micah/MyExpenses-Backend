package com.man.myexpensesbackend.controller


import com.man.myexpensesbackend.models.User
import com.man.myexpensesbackend.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val repository:UserRepository) {

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        return repository.save(user)
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return repository.findAll()
    }
}