package com.fantasy1022.mykotlin

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fantasy1022.mykotlin.data.StarInfo
import com.squareup.picasso.Picasso
import android.graphics.drawable.BitmapDrawable
import android.transition.Explode
import android.transition.Slide
import android.widget.ImageView


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

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_star_grid, container, false)

        starRecycleView = view?.findViewById(R.id.starRecycleView) as RecyclerView
        setUpRecyclerView()
        postponeEnterTransition()
        return view
    }


    private fun setUpRecyclerView() {
        adapterStar = StarGridAdapter(activity, starInfos, this)
        starRecycleView.adapter = adapterStar
    }

    override fun onClick(view: ImageView, position: Int) {
        Log.d(TAG, "position:" + position)
        var imageTransitionName = ""
        var starDetailFragment = StarDetailFragment()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            reenterTransition = Explode()

            starDetailFragment.sharedElementEnterTransition = TransitionInflater.from(
                    getActivity()).inflateTransition(R.transition.change_image_trans);
//            starDetailFragment.startPostponedEnterTransition()
//            starDetailFragment.postponeEnterTransition()
            imageTransitionName = view.transitionName
        }

        val bundle = Bundle()
        bundle.putString("TRANS_NAME", imageTransitionName)
        bundle.putParcelable("IMAGE", (view.drawable as BitmapDrawable).bitmap) //TODO:Check drawable
        starDetailFragment.arguments = bundle //TODO:Use factory pattern

        activity.supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .addSharedElement(view, imageTransitionName)
                .replace(R.id.contentFrameLay, starDetailFragment)
                .commit()
    }
}