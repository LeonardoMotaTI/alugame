package org.games.br.com.lmtech.alugame.modelos

data class InfoJogo(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}