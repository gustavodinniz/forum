package br.com.gustavodiniz.forum.services

import br.com.gustavodiniz.forum.models.CourseModel
import br.com.gustavodiniz.forum.repositories.CourseRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(private val courseRepository: CourseRepository) {

    fun findById(id: Long): CourseModel {
        return courseRepository.getOne(id)
    }

}
