package br.edu.fatecpg.desafiomobile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.desafiomobile.adapter.ProdutoAdapter
import br.edu.fatecpg.desafiomobile.dao.DaoProduto

class activity_lista_produtos : AppCompatActivity(R.layout.activity_lista_produtos) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dao = DaoProduto()
        val produtos = dao.get_produtos()
        val rv_produto = findViewById<RecyclerView>(R.id.rv_produtos)
        rv_produto.layoutManager = LinearLayoutManager(this)
        rv_produto.adapter = ProdutoAdapter(produtos)
    }
}