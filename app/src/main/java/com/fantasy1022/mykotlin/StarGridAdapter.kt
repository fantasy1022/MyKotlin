package com.fantasy1022.mykotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fantasy1022.mykotlin.data.StarInfo
import com.squareup.picasso.Picasso


/**
 * Created by fantasy_apple on 2017/5/29.
 */
class StarGridAdapter(val context: Context, var starInfos: ArrayList<StarInfo>?) : RecyclerView.Adapter<StarGridAdapter.ItemViewHolder>() {

    val TAG = javaClass.simpleName
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StarGridAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent?.getContext()).inflate(R.layout.item_star_grid, parent, false)
        val itemViewHolder = ItemViewHolder(view)
        return itemViewHolder
    }


    override fun onBindViewHolder(holder: StarGridAdapter.ItemViewHolder, position: Int) {
        Log.d(TAG, "holder.avatorImg:" + holder.avatorImg)
        Picasso.with(context).load(starInfos?.get(position)?.avatorUrl).into(holder.avatorImg)
        holder.previousRankTxt?.text = ("(" + starInfos?.get(position)?.nowRanK + ")")
        holder.nameTxt?.text = starInfos?.get(position)?.chineaseName
        //  holder.avatorImg.setOnClickListener(View.OnClickListener { })
    }

    override fun getItemCount(): Int {
        return starInfos?.size ?: 0
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var avatorImg: ImageView? = null
        var nowRankTxt: TextView? = null
        var previousRankTxt: TextView? = null
        var nameTxt: TextView? = null

        init {
            avatorImg = itemView.findViewById(R.id.avatorImg) as ImageView
            nowRankTxt = itemView.findViewById(R.id.nowRankTxt) as TextView
            previousRankTxt = itemView.findViewById(R.id.previousRankTxt) as TextView
            nameTxt = itemView.findViewById(R.id.nameTxt) as TextView
        }

    }

}