package me.kkywalk2.videomanager.videos.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ExploreController {

    @GetMapping("/series")
    fun getSeries() {

    }

    @GetMapping("/series/{seriesId}/groups")
    fun getGroups(@PathVariable seriesId: String) {

    }

    @GetMapping("/groups/{groupId}/videos")
    fun getVideos(@PathVariable groupId: String) {

    }

}