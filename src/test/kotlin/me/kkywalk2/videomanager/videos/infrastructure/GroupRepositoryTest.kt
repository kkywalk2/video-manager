package me.kkywalk2.videomanager.videos.infrastructure

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase
class GroupRepositoryTest {

    @Autowired
    lateinit var seriesJpaRepository: SeriesJpaRepository

    // 중형테스트 이지만 정상적으로 Group의 List가 Text로 잘변환되는지 확인하기 위함
    @Test
    fun `Series 엔티티를 통해 정상적으로 Group을 저장할 수 있다`() {
        seriesJpaRepository.save(SeriesJpaEntity(name = "my first series", groups = listOf(GroupAttribute("default group", listOf(1, 2, 3)))))

        val seriesJpaEntity = seriesJpaRepository.findByName("my first series")

        Assertions.assertTrue(seriesJpaEntity.isPresent)
        Assertions.assertEquals(seriesJpaEntity.get().name, "my first series")
        Assertions.assertEquals(seriesJpaEntity.get().groups.size, 1)
        Assertions.assertEquals(seriesJpaEntity.get().groups[0].name, "default group")
        Assertions.assertIterableEquals(seriesJpaEntity.get().groups[0].videoIds, listOf<Long>(1, 2, 3))
    }

}