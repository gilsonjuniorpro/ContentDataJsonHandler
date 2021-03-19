package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalDurations(
    val localizations: List<Localizations>? = listOf(),
    val numGoalDuration: String? = ""
): Parcelable
