package me.kkywalk2.videomanager.videos.domains

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SeriesTest {

    @Test
    fun `시리즈를 생성할 수 있다`() {
        val createSeries = CreateSeries("my first series")
        val series = Series.create(1, createSeries)

        Assertions.assertEquals(series.groups.size, 1)
        Assertions.assertEquals(series.groups[0].name, "default group")
        Assertions.assertEquals(series.name, "my first series")
        Assertions.assertEquals(series.memberId, 1)
    }

    @Test
    fun `시리즈를 수정할 수 있다`() {
        val series = Series(memberId = 1, name = "my first series", groups = listOf(Group("default group", listOf())))
        val updatedSeries = series.update(UpdateSeries("updated series", listOf()))

        Assertions.assertEquals(updatedSeries.groups.size, 0)
        Assertions.assertEquals(updatedSeries.name, "updated series")
    }

}