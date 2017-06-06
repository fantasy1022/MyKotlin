package com.fantasy1022.mykotlin.fcm

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.iid.FirebaseInstanceId



/**
 * Created by fantasyfang on 2017/6/5.
 */
class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {
    val TAG = javaClass.simpleName

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */


     override fun onTokenRefresh(){
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token: " + refreshedToken)
    }


}