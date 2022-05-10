package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.dtos.NewTopicForm
import br.com.gustavodiniz.forum.dtos.TopicView
import br.com.gustavodiniz.forum.dtos.UpdateTopicForm
import br.com.gustavodiniz.forum.mappers.TopicFormMapper
import br.com.gustavodiniz.forum.mappers.TopicViewMapper
import br.com.gustavodiniz.forum.models.TopicModel
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<TopicModel> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        return topicViewMapper.map(topic)
    }

    fun register(newTopicForm: NewTopicForm) {
        val topic = topicFormMapper.map(newTopicForm)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm) {
        val topic = topics.stream().filter { t -> t.id == updateTopicForm.id }.findFirst().get()
        topics = topics.minus(topic).plus(
            TopicModel(
                id = updateTopicForm.id,
                title = updateTopicForm.title,
                message = updateTopicForm.message,
                author = topic.author,
                course = topic.course,
                answers = topic.answers,
                status = topic.status,
                creationDate = topic.creationDate
            )
        )
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        topics = topics.minus(topic)
    }
}