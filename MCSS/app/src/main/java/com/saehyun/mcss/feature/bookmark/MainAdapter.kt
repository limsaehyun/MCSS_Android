package com.saehyun.mcss.feature.bookmark

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.saehyun.mcss.R
import com.saehyun.mcss.feature.search.ui.SearchActivity

class MainAdapter(val context: Context, val bookMarkData: List<BookMarkData>):
    RecyclerView.Adapter<MainAdapter.Holder>() {

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvServerName = itemView?.findViewById<TextView>(R.id.tvServerName)
        val tvServeDomain = itemView?.findViewById<TextView>(R.id.tvServerDomain)
        val cl = itemView?.findViewById<ConstraintLayout>(R.id.cl)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        val data: BookMarkData = bookMarkData.get(position)

        holder.tvServerName?.text = data.serverName
        holder.tvServeDomain?.text = data.serverDomain

        holder.cl?.setOnClickListener {
            val intent = Intent(holder.itemView.context, SearchActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("server", data.serverDomain)

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return bookMarkData.size
    }
}