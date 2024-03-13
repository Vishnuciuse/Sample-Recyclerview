package com.example.myapplication.UI

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dataclass.product_item
import com.squareup.picasso.Picasso
import kotlin.random.Random

class ProductAdapter(
    val context: Context,
    private var list: ArrayList<product_item>,
    private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconIV: ImageView = view.findViewById(R.id.iconIV)
        val titleTV: TextView = view.findViewById(R.id.titleTV)
        val subtitleTV: TextView = view.findViewById(R.id.subtitleTV)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(pList: ArrayList<product_item>) {
        this.list = pList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTV.text = list[position].title
        Picasso.get().load(list[position].images[0]).into(holder.iconIV)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(position)
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }


}