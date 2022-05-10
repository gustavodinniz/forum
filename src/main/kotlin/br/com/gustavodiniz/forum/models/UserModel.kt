package br.com.gustavodiniz.forum.models

import javax.persistence.*

@Entity
@Table(name = "TB_USERS")
data class UserModel(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val email: String
)
