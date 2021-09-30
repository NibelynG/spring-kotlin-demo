package com.kulikov.test.kotlindemo.db.services

import com.kulikov.test.kotlindemo.KotlinDemoApplication
import com.kulikov.test.kotlindemo.db.models.Message
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest(classes = [KotlinDemoApplication::class])
@AutoConfigureCache
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
class MessageDbServiceTest {

    @Autowired
    lateinit var dbService: MessageService

    @Test
    fun test() {
        val message = dbService.save(Message(text = "Test message"))
        Assertions.assertNotNull(dbService.findById(message.id))
        Assertions.assertNotNull(dbService.findByUid(message.uid))
        Assertions.assertNull(dbService.findByUid("random-uid"))
        Assertions.assertNull(dbService.findByUid(null))
    }

    @Test
    fun test2() {
        val text = "test"
        dbService.save(Message(text = text))
        Assertions.assertEquals(1, dbService.findMessagesWithText(text).size)
        dbService.save(Message(text = text))
        Assertions.assertEquals(2, dbService.findMessagesWithText(text).size)
        dbService.save(Message(text = text))
        Assertions.assertEquals(3, dbService.findMessagesWithText(text).size)
        dbService.save(Message(text = "another text"))
        Assertions.assertEquals(3, dbService.findMessagesWithText(text).size)
    }


}