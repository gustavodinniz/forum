package br.com.gustavodiniz.forum.controllers

import br.com.gustavodiniz.forum.dtos.TopicDTO
import br.com.gustavodiniz.forum.models.TopicModel
import br.com.gustavodiniz.forum.services.TopicService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topics")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<TopicModel> {
        return topicService.list()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): TopicModel {
        return topicService.findById(id)
    }

    @PostMapping
    fun register(@RequestBody topicDTO: TopicDTO) {
        topicService.register(topicDTO)
    }
}