package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val id: String,
    val contextValues: ContextValues? = null,
    val defaults: Defaults? = null,
    val goalFailed: GoalFailed? = null,
    val goalMet: GoalMet? = null,
    val goalProgress: GoalProgress? = null,
    val goalSet: GoalSet? = null,
    val goalSetCategories: GoalSetCategories? = null,
    val goalSetCategoriesPagination: GoalSetCategoriesPagination? = null
): Parcelable
