package br.com.gustavodiniz.forum.models

import br.com.gustavodiniz.forum.enums.TopicStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TB_TOPICS")
data class TopicModel(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var title: String,

    var message: String,

    val creationDate: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val course: CourseModel,

    @ManyToOne
    val author: UserModel,

    @Enumerated(value = EnumType.STRING)
    val status: TopicStatus = TopicStatus.NOT_ANSWERED,

    @OneToMany(mappedBy = "topic")
    val answers: List<AnsweredModel> = ArrayList()
)