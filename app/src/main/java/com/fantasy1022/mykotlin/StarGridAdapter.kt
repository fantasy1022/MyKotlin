package com.fantasy1022.mykotlin

import android.content.Context
import android.os.Build
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
class StarGridAdapter(val context: Context, var starInfos: ArrayList<StarInfo>, var onStarClickListener: OnStarClickListener?) : RecyclerView.Adapter<StarGridAdapter.ItemViewHolder>() {

    val TAG = javaClass.simpleName


    interface OnStarClickListener {
        fun onClick(view: View, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarGridAdapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_star_grid, parent, false)
        val itemViewHolder = ItemViewHolder(view)
        return itemViewHolder
    }


    override fun onBindViewHolder(holder: StarGridAdapter.ItemViewHolder, position: Int) {
        Picasso.with(context).load(starInfos.get(position).avatorUrl).into(holder.avatorImg)
        holder.previousRankTxt.text = ("(" + starInfos.get(position).nowRanK + ")")
        holder.nameTxt.text = starInfos.get(position).chineaseName
        holder.itemView.setOnClickListener { onStarClickListener?.onClick(it, position) } //onStarClickListener?.onClick(v, position)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.avatorImg.transitionName = "trans_image" + position
            holder.nameTxt.transitionName = "trans_txt" + position
        }

    }

    override fun getItemCount(): Int {
        return starInfos.size
    }

//    fun setOnItemClickListener(listener: OnItemClickListener?) {
//        onItemClickListener? = listener
//    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var avatorImg: ImageView
        lateinit var nowRankTxt: TextView
        lateinit var previousRankTxt: TextView
        lateinit var nameTxt: TextView

        init {
            with(itemView) {
                avatorImg = findViewById(R.id.avatorImg) as ImageView
                nowRankTxt = findViewById(R.id.nowRankTxt) as TextView
                previousRankTxt = findViewById(R.id.previousRankTxt) as TextView
                nameTxt = findViewById(R.id.nameTxt) as TextView
            }
        }


    }

}