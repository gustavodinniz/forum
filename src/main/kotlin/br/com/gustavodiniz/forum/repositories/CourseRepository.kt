package br.com.gustavodiniz.forum.repositories

import br.com.gustavodiniz.forum.models.CourseModel
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<CourseModel, Long> {
}