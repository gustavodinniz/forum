package br.com.gustavodiniz.forum.repositories

import br.com.gustavodiniz.forum.models.TopicModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<TopicModel, Long> {

    fun findByCourseName(courseName: String, pageable: Pageable): Page<TopicModel>
}