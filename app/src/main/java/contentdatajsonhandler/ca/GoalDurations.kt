package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalDurations(
    val localizations: Localizations? = null,
    val numGoalDuration: String? = ""
): Parcelable
