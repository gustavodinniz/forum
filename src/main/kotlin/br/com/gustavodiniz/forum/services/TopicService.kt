package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.dtos.NewTopicForm
import br.com.gustavodiniz.forum.dtos.TopicView
import br.com.gustavodiniz.forum.dtos.UpdateTopicForm
import br.com.gustavodiniz.forum.exceptions.NotFoundException
import br.com.gustavodiniz.forum.mappers.TopicFormMapper
import br.com.gustavodiniz.forum.mappers.TopicViewMapper
import br.com.gustavodiniz.forum.repositories.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicService(
    private val topicRepository: TopicRepository,
    private val courseService: CourseService,
    private val userService: UserService,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found."
) {

    fun list(courseName: String?, pageable: Pageable): Page<TopicView> {
        val topics = if (courseName == null) {
            topicRepository.findAll(pageable)
        } else {
            topicRepository.findByCourseName(courseName, pageable)
        }
        return topics.map { t ->
            topicViewMapper.map(t)
        }
    }

    fun findById(id: Long): TopicView {
        val topic = topicRepository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun register(newTopicForm: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(newTopicForm)
        topicRepository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun update(updateTopicForm: UpdateTopicForm): TopicView {
        val topic = topicRepository.findById(updateTopicForm.id)
            .stream()
            .filter { t -> t.id == updateTopicForm.id }.findFirst()
            .orElseThrow { NotFoundException(notFoundMessage) }
        topic.title = updateTopicForm.title
        topic.message = updateTopicForm.message
        return topicViewMapper.map(topic)
    }

    fun delete(id: Long) {
        topicRepository.deleteById(id)
    }
}