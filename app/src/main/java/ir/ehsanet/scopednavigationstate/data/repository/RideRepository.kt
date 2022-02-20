package ir.ehsanet.scopednavigationstate.data.repository

import ir.ehsanet.scopednavigationstate.data.RideNavState

interface RideRepository {
    fun saveRideNavState(state: RideNavState)
    fun getRideNavState(): RideNavState
}
