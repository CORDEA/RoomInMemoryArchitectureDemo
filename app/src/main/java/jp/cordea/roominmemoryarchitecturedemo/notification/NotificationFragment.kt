package jp.cordea.roominmemoryarchitecturedemo.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jp.cordea.roominmemoryarchitecturedemo.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    companion object {
        fun newInstance() = NotificationFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }
}
