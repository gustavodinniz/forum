package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.models.UserModel
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(var users: List<UserModel>) {

    init {
        val userModel = UserModel(
            id = 1,
            name = "Gustavo",
            email = "gustavodinniz@hotmail.com"
        )
        users = Arrays.asList(userModel)
    }

    fun findById(id: Long): UserModel {
        return users.stream().filter({ u -> u.id == id }).findFirst().get()
    }
}