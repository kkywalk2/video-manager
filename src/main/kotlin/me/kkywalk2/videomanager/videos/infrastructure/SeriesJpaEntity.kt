package me.kkywalk2.videomanager.videos.infrastructure

import javax.persistence.*

@Entity
@Table(name = "series")
class SeriesJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,

    val name: String,

    val memberId: Long,

    @Convert(converter = GroupsConverter::class)
    @Column(name = "group_metadata", columnDefinition = "TEXT")
    val groups: List<GroupAttribute>,
) {

}