package ir.ehsanet.scopednavigationstate.screens.main_nav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.ehsanet.scopednavigationstate.data.InRideNavState
import ir.ehsanet.scopednavigationstate.data.PreRideNavState
import ir.ehsanet.scopednavigationstate.data.RequestedRideNavState
import ir.ehsanet.scopednavigationstate.data.RideNavState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val rideNavState = MutableSharedFlow<RideNavState>()

    fun getNavigationEvents(): SharedFlow<RideNavState> {
        return rideNavState.asSharedFlow()
    }

    fun onNavEvents(state: RideNavState) {
        viewModelScope.launch {
            when (state) {
                is PreRideNavState -> {
                    rideNavState.emit(state)
                }
                is RequestedRideNavState -> {
                    rideNavState.emit(state)
                }
                is InRideNavState -> {
                    rideNavState.emit(state)
                }
            }
        }
    }


}
