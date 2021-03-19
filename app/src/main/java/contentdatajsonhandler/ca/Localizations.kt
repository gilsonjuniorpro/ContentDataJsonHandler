package contentdatajsonhandler.ca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Localizations(
    val english: Language? = null,
    val french: Language? = null
): Parcelable
