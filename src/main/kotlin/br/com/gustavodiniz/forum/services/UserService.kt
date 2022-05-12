package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.configs.UserDetailsImpl
import br.com.gustavodiniz.forum.models.UserModel
import br.com.gustavodiniz.forum.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) : UserDetailsService {

    fun findById(id: Long): UserModel {
        return userRepository.getOne(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val userModel = userRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetailsImpl(userModel)
    }
}