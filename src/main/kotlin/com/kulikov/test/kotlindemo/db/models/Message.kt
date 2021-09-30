package com.kulikov.test.kotlindemo.db.models

import java.util.*
import javax.persistence.*


@Entity
@Table(name = "Messages")
class Message(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var uid: String? = null,
    var text: String
) {
    @PrePersist
    fun prePersist() {
        uid = UUID.randomUUID().toString();
    }
}

