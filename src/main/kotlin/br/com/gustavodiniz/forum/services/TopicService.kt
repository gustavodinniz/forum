package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.dtos.NewTopicForm
import br.com.gustavodiniz.forum.dtos.TopicView
import br.com.gustavodiniz.forum.dtos.UpdateTopicForm
import br.com.gustavodiniz.forum.exceptions.NotFoundException
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
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found."
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic =
            topics.stream().filter { t -> t.id == id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun register(newTopicForm: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(newTopicForm)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { t -> t.id == updateTopicForm.id }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }
        val updateTopic = TopicModel(
            id = updateTopicForm.id,
            title = updateTopicForm.title,
            message = updateTopicForm.message,
            author = topic.author,
            course = topic.course,
            answers = topic.answers,
            status = topic.status,
            creationDate = topic.creationDate
        )
        topics = topics.minus(topic).plus(updateTopic)
        return topicViewMapper.map(updateTopic)
    }

    fun delete(id: Long) {
        val topic =
            topics.stream().filter { t -> t.id == id }.findFirst()
                .orElseThrow { NotFoundException(notFoundMessage) }
        topics = topics.minus(topic)
    }
}