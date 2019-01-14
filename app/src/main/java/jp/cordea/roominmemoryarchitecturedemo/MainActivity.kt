package jp.cordea.roominmemoryarchitecturedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import jp.cordea.roominmemoryarchitecturedemo.dashboard.DashboardFragment
import jp.cordea.roominmemoryarchitecturedemo.home.HomeFragment
import jp.cordea.roominmemoryarchitecturedemo.notification.NotificationFragment

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment = when (item.itemId) {
            R.id.navigation_home -> HomeFragment.newInstance()
            R.id.navigation_dashboard -> DashboardFragment.newInstance()
            R.id.navigation_notifications -> NotificationFragment.newInstance()
            else -> throw IllegalStateException()
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HomeFragment.newInstance())
            .commit()
    }
}
