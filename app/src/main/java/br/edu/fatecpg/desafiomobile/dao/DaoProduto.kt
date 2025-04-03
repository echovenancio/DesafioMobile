package br.edu.fatecpg.desafiomobile.dao

import br.edu.fatecpg.desafiomobile.model.Produto

class DaoProduto {
    companion object {
        val lista_produtos = mutableListOf<Produto>()
    }

    fun add_produto(produto: Produto) {
        lista_produtos.add(produto)
    }

    fun get_produtos(): List<Produto> {
        return lista_produtos
    }
}