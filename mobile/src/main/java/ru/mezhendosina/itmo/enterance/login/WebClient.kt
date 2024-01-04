package ru.mezhendosina.itmo.enterance.login

import android.os.Message
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

class WebClient(
    private val webClientInterface: WebClientInterface
) : WebViewClient() {
    override fun onLoadResource(view: WebView?, url: String?) {
        super.onLoadResource(view, url)
        val cookies = CookieManager.getInstance().getCookie(url)
        if (cookies != null && cookies.contains("REMEMBER_SSO")) {
            val listCookies = cookies.split("; ")
            val findSsoCookie = listCookies.find { it.contains("REMEMBER_SSO") }
            if (findSsoCookie != null) {
                println(findSsoCookie.replace("REMEMBER_SSO=", ""))
                webClientInterface.onSsoFind(findSsoCookie.replace("REMEMBER_SSO=", ""))
            }
        }
    }
}