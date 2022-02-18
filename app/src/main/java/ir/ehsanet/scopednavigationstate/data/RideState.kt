package ir.ehsanet.scopednavigationstate.data

open class RideNavState

sealed class PreRideNavState : RideNavState() {
    object DestinationPickerState : PreRideNavState()
    object VehiclePickerState : PreRideNavState()
}

sealed class RequestedRideNavState : RideNavState() {
    object RideFinderState : RequestedRideNavState()
}

sealed class InRideNavState : RideNavState() {
    object RideInfoState : InRideNavState()
}