package ir.ehsanet.scopednavigationstate.data.repository

import android.content.SharedPreferences
import ir.ehsanet.scopednavigationstate.data.InRideNavState
import ir.ehsanet.scopednavigationstate.data.PreRideNavState
import ir.ehsanet.scopednavigationstate.data.RequestedRideNavState
import ir.ehsanet.scopednavigationstate.data.RideNavState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GlobalRideRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : RideRepository {

    private val RIDE_NAV_STATE_KEY: String = "RIDE_NAV_STATE_KEY"

    private val DestinationPickerState = 1
    private val VehiclePickerState = 2
    private val RideFinderState = 3
    private val RideInfoState = 4

    override fun saveRideNavState(state: RideNavState) {
        sharedPreferences.edit().putInt(RIDE_NAV_STATE_KEY, mapRideNavState(state)).commit()
    }

    override fun getRideNavState(): RideNavState {
        return mapRideNavState(
            sharedPreferences.getInt(
                RIDE_NAV_STATE_KEY,
                DestinationPickerState
            )
        )
    }

    private fun mapRideNavState(rideNavState: RideNavState): Int {
        return when (rideNavState) {
            PreRideNavState.DestinationPickerState -> DestinationPickerState
            PreRideNavState.VehiclePickerState -> VehiclePickerState
            RequestedRideNavState.RideFinderState -> RideFinderState
            InRideNavState.RideInfoState -> RideInfoState
            else -> DestinationPickerState
        }
    }

    private fun mapRideNavState(rideNavState: Int): RideNavState {
        return when (rideNavState) {
            DestinationPickerState -> PreRideNavState.DestinationPickerState
            VehiclePickerState -> PreRideNavState.VehiclePickerState
            RideFinderState -> RequestedRideNavState.RideFinderState
            RideInfoState -> InRideNavState.RideInfoState
            else -> PreRideNavState.DestinationPickerState
        }
    }
}