package com.kulikov.test.kotlindemo.db.services

import com.kulikov.test.kotlindemo.db.models.Message
import com.kulikov.test.kotlindemo.db.repositories.MessageRepository
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class MessageService(val db: MessageRepository) {

    fun findMessages(): List<Message> = db.findAll()

    fun save(message: Message): Message = db.save(message)

    fun findById(id: Long?): Message? = db.findByIdOrNull(id)

    fun findByUid(uid: String?): Message? = db.findByUid(uid)

    fun findMessagesWithText(text: String): List<Message> = db.findAllByText(text)

    companion object {
        private val log = LoggerFactory.getLogger(MessageService::class.java)
    }

}
