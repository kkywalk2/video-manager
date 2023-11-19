package me.kkywalk2.videomanager.videos.infrastructure

import javax.persistence.*

@Entity
@Table(name = "videos")
class VideoJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val memberId: Long,

    val path: String,

    val title: String,

    val conversionComplete: Boolean,
) {

}
