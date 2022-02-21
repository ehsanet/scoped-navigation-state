package ir.ehsanet.scopednavigationstate.screens.main_nav

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ir.ehsanet.scopednavigationstate.R
import ir.ehsanet.scopednavigationstate.data.PreRideNavState
import ir.ehsanet.scopednavigationstate.data.RideNavState
import ir.ehsanet.scopednavigationstate.screens.base.BaseScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainScreen : BaseScreen() {

    private val viewModel by viewModels<MainViewModel>()

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNavigationEvents()
            .flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.CREATED)
            .onEach { onRideNavStateChanged(it) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onStart() {
        super.onStart()
        viewModel.start()
    }

    private fun onRideNavStateChanged(it: RideNavState) {
        when (it) {
            is PreRideNavState.DestinationPickerState -> {

            }
        }
    }
}