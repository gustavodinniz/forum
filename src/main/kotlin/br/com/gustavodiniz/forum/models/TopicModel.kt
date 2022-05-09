package br.com.gustavodiniz.forum.models

import br.com.gustavodiniz.forum.enums.TopicStatus
import java.time.LocalDateTime

data class TopicModel(
    val id: Long? = null,
    val title: String,
    val message: String,
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val course: CourseModel,
    val author: UserModel,
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,
    val answers: List<AnsweredModel> = ArrayList()
)