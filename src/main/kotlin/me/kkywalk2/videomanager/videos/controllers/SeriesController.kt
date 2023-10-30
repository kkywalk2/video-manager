package me.kkywalk2.videomanager.videos.controllers

import me.kkywalk2.videomanager.members.services.MemberDetails
import me.kkywalk2.videomanager.videos.domains.CreateSeries
import me.kkywalk2.videomanager.videos.domains.Series
import me.kkywalk2.videomanager.videos.domains.UpdateSeries
import me.kkywalk2.videomanager.videos.services.SeriesService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/series")
class SeriesController(
    private val seriesService: SeriesService,
) {

    @PostMapping
    fun create(
        @AuthenticationPrincipal memberDetails: MemberDetails,
        @RequestBody createSeries: CreateSeries,
    ): Series {
        return seriesService.create(memberDetails.id, createSeries)
    }

    @PutMapping("/{seriesId}")
    fun update(
        @AuthenticationPrincipal memberDetails: MemberDetails,
        @PathVariable seriesId: Long,
        @RequestBody updateSeries: UpdateSeries,
    ): Series {
        return seriesService.update(memberDetails.id, seriesId, updateSeries)
    }

}