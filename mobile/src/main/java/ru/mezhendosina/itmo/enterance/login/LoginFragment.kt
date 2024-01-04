package ru.mezhendosina.itmo.enterance.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.wear.remote.interactions.RemoteActivityHelper
import com.google.android.gms.wearable.DataItem
import com.google.android.gms.wearable.DataItemAsset
import com.google.android.gms.wearable.PutDataRequest
import com.google.android.gms.wearable.Wearable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mezhendosina.itmo.enterance.R
import ru.mezhendosina.itmo.enterance.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private var binding: FragmentLoginBinding? = null

    private val viewModel by viewModels<LoginViewModel>()

    private val webClient = WebClient(object : WebClientInterface {
        override fun onSsoFind(sso: String) {
            binding!!.webView.visibility = View.GONE
            binding!!.statusImage.visibility = View.VISIBLE
            binding!!.statusText.visibility = View.VISIBLE
            binding!!.statusImage.setImageResource(R.drawable.ic_done)
            binding!!.statusText.text =
                "Вход выполнен :)\nПроверь часы. Теперь там должен появиться QR-код"
            val a = Uri.parse("itmoentrance://sso?sso=$sso")
            RemoteActivityHelper(requireContext()).startRemoteActivity(
                targetIntent = Intent(
                    Intent.ACTION_VIEW,
                )
                    .addCategory(Intent.CATEGORY_BROWSABLE)
                    .setData(a),
            )

        }
    })

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        with(binding!!.webView) {
            loadUrl("https://isu.ifmo.ru/")
            settings.apply {
                loadsImagesAutomatically = true
                javaScriptEnabled = true
            }
            webViewClient = webClient
        }
    }
}