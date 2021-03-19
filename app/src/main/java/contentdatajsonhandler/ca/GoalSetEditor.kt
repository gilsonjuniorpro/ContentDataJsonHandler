package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalSetEditor(
    val goalAmount: GoalAmount? = null,
    val goalDurations: List<GoalDurations>? = listOf()
): Parcelable
