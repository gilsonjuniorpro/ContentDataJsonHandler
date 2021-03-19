package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalSetCategoriesPagination(
    val limit: String? = "",
    val offset: String? = "",
    val totalRecords: String? = "",
): Parcelable
