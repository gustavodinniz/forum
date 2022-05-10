package br.com.gustavodiniz.forum.models

import javax.persistence.*

@Entity
@Table(name = "TB_COURSES")
data class CourseModel(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val category: String
)
