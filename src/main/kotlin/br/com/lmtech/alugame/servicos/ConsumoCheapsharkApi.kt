package br.com.lmtech.alugame.servicos

import com.google.gson.Gson
import org.games.br.com.lmtech.alugame.modelos.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoCheapsharkApi {

    fun buscarJogo(id: String): InfoJogo {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()
        val response =  client.send(request, BodyHandlers.ofString())
        val responseBody = response.body()
        println(responseBody)

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(responseBody, InfoJogo::class.java)

        return meuInfoJogo
    }
}