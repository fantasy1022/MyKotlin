package com.fantasy1022.mykotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.graphics.Bitmap
import android.os.Build


/**
 * Created by fantasy_apple on 2017/5/30.
 */
class StarDetailFragment : Fragment() {
    val TAG = javaClass.simpleName
    var transitionName: String? = null
    var imageBitmap: Bitmap? = null
    lateinit var avatorImg: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = arguments
        with(bundle) {
            transitionName = bundle?.getString("TRANS_NAME")
            imageBitmap = bundle?.getParcelable("IMAGE")
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_star_detail, container, false)
        avatorImg = view?.findViewById(R.id.avatorImg) as ImageView

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            avatorImg.transitionName = transitionName
        }
        avatorImg.setImageBitmap(imageBitmap)

        return view
    }
}