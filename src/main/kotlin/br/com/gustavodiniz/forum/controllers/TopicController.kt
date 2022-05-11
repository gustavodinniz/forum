package br.com.gustavodiniz.forum.controllers

import br.com.gustavodiniz.forum.dtos.NewTopicForm
import br.com.gustavodiniz.forum.dtos.TopicView
import br.com.gustavodiniz.forum.dtos.UpdateTopicForm
import br.com.gustavodiniz.forum.services.TopicService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(
        @RequestParam(required = false) courseName: String?,
        @PageableDefault(size = 10, sort = ["creationDate"], direction = Sort.Direction.DESC) pageable: Pageable
    ): Page<TopicView> {
        return topicService.list(courseName, pageable)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return topicService.findById(id)
    }

    @Transactional
    @PostMapping
    fun register(
        @RequestBody @Valid newTopicForm: NewTopicForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = topicService.register(newTopicForm)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun update(@RequestBody @Valid updateTopicForm: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = topicService.update(updateTopicForm)
        return ResponseEntity.ok(topicView)
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        topicService.delete(id)
    }
}