package br.com.gustavodiniz.forum.mappers

import br.com.gustavodiniz.forum.dtos.TopicView
import br.com.gustavodiniz.forum.models.TopicModel
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<TopicModel, TopicView> {

    override fun map(t: TopicModel): TopicView {
        return TopicView(
            id = t.id,
            title = t.title,
            message = t.message,
            creationDate = t.creationDate,
            status = t.status
        )
    }
}