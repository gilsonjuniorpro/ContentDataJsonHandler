package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalMet(
    val localizations: Localizations?
): Parcelable
