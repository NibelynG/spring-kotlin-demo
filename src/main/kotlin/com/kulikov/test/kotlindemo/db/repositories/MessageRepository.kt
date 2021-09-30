package com.kulikov.test.kotlindemo.db.repositories

import com.kulikov.test.kotlindemo.db.models.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query


interface MessageRepository : JpaRepository<Message, Long> {

//    @Query("select message from Messages message")
//    fun findAll(): List<Message>

    @Query("select m from Messages m where text = #{text}")
    fun findAllByText(text: String): List<Message>

    fun findByUid(uid: String?): Message?

//    fun <T, ID> CrudRepository<T, ID>.findByIdOrNull(id: ID): T? = findById(id).orElse(null)


}