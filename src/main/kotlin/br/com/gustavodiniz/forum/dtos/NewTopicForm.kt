package br.com.gustavodiniz.forum.dtos

data class NewTopicForm(
    val title: String,
    val message: String,
    val idCourse: Long,
    val idAuthor: Long,

)