package br.edu.fatecpg.desafiomobile
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.desafiomobile.dao.DaoProduto
import br.edu.fatecpg.desafiomobile.model.Produto

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txv_nome = findViewById<EditText>(R.id.txt_nome)
        val txv_valor = findViewById<EditText>(R.id.txt_valor)
        val txv_link = findViewById<EditText>(R.id.txt_link)
        val txt_lista = findViewById<TextView>(R.id.txt_lista)
        val button = findViewById<Button>(R.id.btn_cadastrar)
        val dao = DaoProduto()

        button.setOnClickListener {
            val nome = txv_nome.text.toString()
            val valor = txv_valor.text.toString().toDouble()
            val link = txv_link.text.toString()
            val produto = Produto(nome, link, valor)
            dao.add_produto(produto)
        }

        txt_lista.setOnClickListener {
            val intent = Intent(this, activity_lista_produtos::class.java)
            startActivity(intent)
        }
    }
}
