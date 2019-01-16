package jp.cordea.roominmemoryarchitecturedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import jp.cordea.roominmemoryarchitecturedemo.dashboard.DashboardFragment
import jp.cordea.roominmemoryarchitecturedemo.databinding.ActivityMainBinding
import jp.cordea.roominmemoryarchitecturedemo.home.HomeFragment
import jp.cordea.roominmemoryarchitecturedemo.notification.NotificationFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

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
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, HomeFragment.newInstance())
            .commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}
