package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.dtos.TopicDTO
import br.com.gustavodiniz.forum.models.TopicModel
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topics: List<TopicModel> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<TopicModel> {
        return topics
    }

    fun findById(id: Long): TopicModel {
        return topics.stream().filter({ t -> t.id == id }).findFirst().get()
    }

    fun register(topicDTO: TopicDTO) {
        topics.plus(
            TopicModel(
                id = topics.size.toLong() + 1,
                title = topicDTO.title,
                message = topicDTO.message,
                course = courseService.findById(topicDTO.idCourse),
                author = userService.findById(topicDTO.idAuthor)
            )
        )
    }
}