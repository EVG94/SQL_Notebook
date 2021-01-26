package com.example.bloknotsql.utils

import android.net.Uri
import java.net.URL

open class NetworkUtils {

   fun generateURL(userID:String): URL {

       var buildUri:Uri = Uri.parse(baseURLAPI + usersGET )
           .buildUpon()
           .appendQueryParameter(usersID, userID)
           .appendQueryParameter(paramVersion, "5.8")
           .build()


        var newURL: URL? = null
        newURL = URL(buildUri.toString())
        return newURL

   }

    companion object {
        const val baseURLAPI = "https://api.vk.com/"
        const val usersGET = "/method/users.get"
        const val usersID = "user_ids"
        const val paramVersion = "v"
    }
}