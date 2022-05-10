package br.com.gustavodiniz.forum.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_ANSWERS")
data class AnsweredModel(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val message: String,

    val creationDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val author: UserModel,

    @ManyToOne
    val topic: TopicModel,

    val solution: Boolean
)
