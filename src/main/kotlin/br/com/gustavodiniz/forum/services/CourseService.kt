package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.models.CourseModel
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(var courses: List<CourseModel>) {

    init {
        val courseModel = CourseModel(
            id = 1,
            name = "Kotlin",
            category = "Programacao"
        )
        courses = Arrays.asList(courseModel)
    }

    fun findById(id: Long): CourseModel {
        return courses.stream().filter({ c -> c.id == id }).findFirst().get()
    }

}
