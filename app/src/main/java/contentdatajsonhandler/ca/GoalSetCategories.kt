package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GoalSetCategories(
    val localizations: Localizations? = null,
    val txtCategoryID: String? = ""
): Parcelable
