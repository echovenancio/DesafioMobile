package br.edu.fatecpg.desafiomobile.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.desafiomobile.R
import br.edu.fatecpg.desafiomobile.model.Produto
import java.util.concurrent.Executors

class ProdutoAdapter(private val lista_produto: List<Produto>):
    RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txv_produto_nome = itemView.findViewById<TextView>(R.id.txv_produto_nome)
        val txv_produto_valor = itemView.findViewById<TextView>(R.id.txv_produto_valor)
        val img_produto = itemView.findViewById<ImageView>(R.id.imgv_produto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_produto, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista_produto.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = lista_produto[position]
        holder.txv_produto_nome.text = produto.nome
        holder.txv_produto_valor.text = produto.valor.toString()
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap? = null
        executor.execute {
            val url = produto.imagem_path
            try {
                val `in` = java.net.URL(url).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    holder.img_produto.setImageBitmap(image)
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}