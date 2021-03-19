package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Language(
    val btnGoalFailed: String? = "",
    val txtGoalFailedDesc: String? = "",
    val txtGoalFailedTitle: String? = "",
    val btnGoalMet: String? = "",
    val txtGoalMetTitle: String? = "",
    val txtGoalProgress: String? = "",
    val txtGoalProgressDesc: String? = "",
    val txtGoalDuration: String? = "",
    val btnGoalSet: String? = "",
    val imgGoalSet: String? = "",
    val txtGoalSetDesc: String? = "",
    val txtGoalSetTitle: String? = "",
    val imgCategory: String? = "",
    val imgCategoryGoalMet: String? = "",
    val txtCategory: String? = "",
    val txtCategoryGoalMet: String? = "",
): Parcelable
