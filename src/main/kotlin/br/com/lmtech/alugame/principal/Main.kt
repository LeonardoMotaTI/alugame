package org.games.br.com.lmtech.alugame.principal

import br.com.lmtech.alugame.servicos.ConsumoCheapsharkApi
import org.games.br.com.lmtech.alugame.modelos.Jogo
import java.util.*


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val entrada = Scanner(System.`in`)
    println("Infome o ID do jogo para buscar:")
    val input = entrada.nextLine()
    val consumoCheapsharkApi = ConsumoCheapsharkApi()
    val meuInfoJogo = consumoCheapsharkApi.buscarJogo(input)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb
        )
    }

    resultado.onSuccess {
        println("Deseja informar uma descrição personalizada para o jogo? S/N")
        val opcao = entrada.nextLine()

        if(opcao.equals("S", true)) {
            println("Informe a descrição personalizada para o jogo:")
            val descricaoPersonalizada = entrada.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }

    resultado.onFailure {
        println("Jogo não encontrado. Favor informar outro ID")
    }

    resultado.onSuccess { println("Busca finalizada com sucesso!") }
}