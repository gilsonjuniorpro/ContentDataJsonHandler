package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalAmount(
    val numGoalAmountDefault: String? = "",
    val numGoalAmountIncrement: String? = "",
): Parcelable
