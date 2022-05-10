package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.dtos.NewTopicForm
import br.com.gustavodiniz.forum.dtos.TopicView
import br.com.gustavodiniz.forum.models.TopicModel
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<TopicModel> = ArrayList(),
    private val courseService: CourseService,
    private val userService: UserService
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            TopicView(
                id = t.id,
                title = t.title,
                message = t.message,
                creationDate = t.creationDate,
                status = t.status
            )
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicView {
        val topic = topics.stream().filter { t -> t.id == id }.findFirst().get()
        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            creationDate = topic.creationDate,
            status = topic.status
        )
    }

    fun register(newTopicForm: NewTopicForm) {
        topics = topics.plus(
            TopicModel(
                id = topics.size.toLong() + 1,
                title = newTopicForm.title,
                message = newTopicForm.message,
                course = courseService.findById(newTopicForm.idCourse),
                author = userService.findById(newTopicForm.idAuthor)
            )
        )
    }
}