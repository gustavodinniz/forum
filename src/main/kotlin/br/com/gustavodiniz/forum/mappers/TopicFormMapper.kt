package br.com.gustavodiniz.forum.mappers

import br.com.gustavodiniz.forum.dtos.NewTopicForm
import br.com.gustavodiniz.forum.models.TopicModel
import br.com.gustavodiniz.forum.services.CourseService
import br.com.gustavodiniz.forum.services.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
) : Mapper<NewTopicForm, TopicModel> {
    override fun map(t: NewTopicForm): TopicModel {
        return TopicModel(
            title = t.title,
            message = t.message,
            course = courseService.findById(t.idCourse),
            author = userService.findById(t.idAuthor)
        )
    }

}
