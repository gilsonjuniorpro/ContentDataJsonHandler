package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Defaults(
    val txtCurrency: String?,
    val numGoalFailedDurationMessage: String?,
    val numGoalMetDurationMessage: String?
): Parcelable
