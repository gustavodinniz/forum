package br.com.gustavodiniz.forum.controllers

import br.com.gustavodiniz.forum.dtos.NewTopicForm
import br.com.gustavodiniz.forum.dtos.TopicView
import br.com.gustavodiniz.forum.dtos.UpdateTopicForm
import br.com.gustavodiniz.forum.services.TopicService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicView {
        return topicService.findById(id)
    }

    @PostMapping
    fun register(@RequestBody @Valid newTopicForm: NewTopicForm) {
        topicService.register(newTopicForm)
    }

    @PutMapping()
    fun update(@RequestBody @Valid updateTopicForm: UpdateTopicForm){
        topicService.update(updateTopicForm)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long){
        topicService.delete(id)
    }
}