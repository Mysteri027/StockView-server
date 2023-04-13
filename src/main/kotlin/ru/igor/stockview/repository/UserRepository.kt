package ru.igor.stockview.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.igor.stockview.entity.UserEntity

interface UserRepository: JpaRepository<UserEntity, Int> {
    fun findByEmail(email: String): UserEntity?
}