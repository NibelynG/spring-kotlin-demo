package com.kulikov.test.kotlindemo.db.repositories

import com.kulikov.test.kotlindemo.db.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface MessageRepository : JpaRepository<Message, Long> {

    @Query("SELECT m from Message m where m.text = ?1")
    fun findAllByText(text: String): List<Message>

    fun findByUid(uid: String?): Message?

}