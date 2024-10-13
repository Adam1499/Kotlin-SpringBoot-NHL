package com.adam1499.kotlin_springboot_nhl.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import com.adam1499.kotlin_springboot_nhl.service.NhlApiService
import com.adam1499.kotlin_springboot_nhl.service.Team

@RestController
class TeamController(private val nhlApiService: NhlApiService) {

    @GetMapping("/api/teams")
    fun getTeams(): Flux<Team> {
        return nhlApiService.getTeams()
            .flatMapMany { Flux.fromIterable(it.teams) }
    }
}
