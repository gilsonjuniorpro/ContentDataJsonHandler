package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalSet(
    val goalSetEditor: GoalSetEditor? = null,
    val localizations: Localizations? = null
): Parcelable
