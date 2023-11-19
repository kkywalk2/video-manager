package me.kkywalk2.videomanager.videos.domains

data class Series(
    val id: Long = 0,
    val memberId: Long,
    val name: String,
    val groups: List<Group>,
) {

    fun update(updateSeries: UpdateSeries): Series {
        return this.copy(name = updateSeries.name, groups = updateSeries.groups)
    }

    companion object {
        fun create(memberId: Long, createSeries: CreateSeries): Series {
            return Series(
                memberId = memberId,
                name = createSeries.name,
                groups = listOf(Group("default-group", listOf())),
            )
        }
    }

}
