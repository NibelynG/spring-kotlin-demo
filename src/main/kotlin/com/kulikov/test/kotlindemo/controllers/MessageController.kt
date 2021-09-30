package com.kulikov.test.kotlindemo.controllers

import com.kulikov.test.kotlindemo.db.models.Message
import com.kulikov.test.kotlindemo.db.services.MessageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/messages")
class MessageController(val dbService: MessageService) {

    @GetMapping
    fun findAll(): List<Message> = dbService.findMessages()

    @PostMapping
    fun create(@RequestBody newMessage: Message): Message = dbService.save(newMessage)

}