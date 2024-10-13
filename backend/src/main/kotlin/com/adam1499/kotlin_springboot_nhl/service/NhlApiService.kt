package com.adam1499.kotlin_springboot_nhl.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class NhlApiService {

    private val webClient = WebClient.create("https://statsapi.web.nhl.com")

    // Metoda pro načtení týmů
    fun getTeams(): Mono<TeamsResponse> {
        return webClient.get()
            .uri("/api/v1/teams")
            .retrieve()
            .bodyToMono(TeamsResponse::class.java)
    }
}

// Třídy pro deserializaci JSON odpovědi z NHL API
data class Team(val id: Int, val name: String)

data class TeamsResponse(val teams: List<Team>)