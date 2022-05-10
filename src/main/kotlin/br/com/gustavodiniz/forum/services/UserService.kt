package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.models.UserModel
import br.com.gustavodiniz.forum.repositories.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository) {

    fun findById(id: Long): UserModel {
        return userRepository.getOne(id)
    }
}