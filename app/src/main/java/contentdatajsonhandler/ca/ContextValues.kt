package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContextValues(
    val cvGoalCurrentAmount: String?,
    val cvGoalEndDate: String?,
    val cvGoalEnteredAmount: String?,
    val cvGoalEnteredCategory: String?,
    val cvGoalStartDate: String?,
    val cvIsGoalSet: String?,
): Parcelable
