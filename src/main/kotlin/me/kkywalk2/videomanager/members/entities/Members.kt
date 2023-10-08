package me.kkywalk2.videomanager.members.entities

import javax.persistence.*

@Entity
@Table(name = "members")
class Members(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val email: String,

    val nickName: String,

    val password: String,
)