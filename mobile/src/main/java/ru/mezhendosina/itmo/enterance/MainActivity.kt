package ru.mezhendosina.itmo.enterance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import dagger.hilt.android.AndroidEntryPoint
import ru.mezhendosina.itmo.enterance.login.LoginFragment
import kotlin.coroutines.suspendCoroutine

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
            .add<LoginFragment>(R.id.fragment_container)
            .commit()
    }
}