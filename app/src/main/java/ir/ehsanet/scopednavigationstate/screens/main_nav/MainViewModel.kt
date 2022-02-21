package ir.ehsanet.scopednavigationstate.screens.main_nav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.ehsanet.scopednavigationstate.data.RideNavState
import ir.ehsanet.scopednavigationstate.data.repository.GlobalRideRepository
import ir.ehsanet.scopednavigationstate.data.repository.RideRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val globalRideRepository: RideRepository,
) : ViewModel() {

    private val rideNavState = MutableSharedFlow<RideNavState>()

    private fun updateRideNavState(state: RideNavState) {
        viewModelScope.launch {
            rideNavState.emit(state)
        }
    }

    fun getNavigationEvents(): SharedFlow<RideNavState> {
        return rideNavState.asSharedFlow()
    }

    fun start() {
        val rideNavState = globalRideRepository.getRideNavState()
        updateRideNavState(rideNavState)
    }


}
