package br.com.gustavodiniz.forum.repositories

import br.com.gustavodiniz.forum.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserModel, Long> {
}