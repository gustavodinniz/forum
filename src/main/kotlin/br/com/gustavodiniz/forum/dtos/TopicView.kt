package br.com.gustavodiniz.forum.dtos

import br.com.gustavodiniz.forum.enums.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val creationDate: LocalDateTime
)
