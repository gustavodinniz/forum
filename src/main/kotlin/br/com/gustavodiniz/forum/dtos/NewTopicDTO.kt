package br.com.gustavodiniz.forum.dtos

data class NewTopicDTO(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long,

)