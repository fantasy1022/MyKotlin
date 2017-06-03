package com.fantasy1022.mykotlin

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fantasy1022.mykotlin.data.StarInfo
import com.squareup.picasso.Picasso


/**
 * Created by fantasy_apple on 2017/5/29.
 */

class StarGridFragment : Fragment(), StarGridAdapter.OnStarClickListener {

    val TAG = javaClass.simpleName
    val starInfos: ArrayList<StarInfo> = ArrayList()
    lateinit var adapterStar: StarGridAdapter
    lateinit var picasso: Picasso
    lateinit var starRecycleView: RecyclerView


    init {
        for (i in 1..10) starInfos.add(StarInfo(1, "馬龍", "http://dr.ittf.com/stories/pictures/ma_long_07_07_16.jpg"))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        picasso = Picasso.Builder(activity)
                .build()
        val d = StarInfo()
        val d2 = d.copy()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_star_grid, container, false)

        starRecycleView = view?.findViewById(R.id.starRecycleView) as RecyclerView
        setUpRecyclerView()
        return view
    }


    private fun setUpRecyclerView() {
        adapterStar = StarGridAdapter(activity, starInfos, this)
        starRecycleView.adapter = adapterStar
    }

    override fun onClick(view: View, position: Int) {
        Log.d(TAG, "position:" + position)
        //TODO: add click transittion

        var fragment = StarGridFragment()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.enterTransition = Fade()
            fragment.sharedElementEnterTransition = Fade()
        }



        activity.supportFragmentManager
                .beginTransaction()
//                .addSharedElement(fragment, "ds")
                .replace(R.id.contentFrameLay, fragment)
                .commit()
    }
}