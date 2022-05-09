package br.com.gustavodiniz.forum.models

import java.time.LocalDateTime

data class AnsweredModel(
    val id: Long? = null,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val author: UserModel,
    val topic: TopicModel,
    val solution: Boolean
)
