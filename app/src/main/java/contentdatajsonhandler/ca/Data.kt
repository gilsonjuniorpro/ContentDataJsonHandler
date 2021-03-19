package contentdatajsonhandler.ca

import org.json.JSONArray
import org.json.JSONObject

data class Data(
    val id: String,
    val contextValues: ContextValues?,
    val defaults: Defaults?,
    val goalFailed: GoalFailed?,
    val goalMet: GoalMet?,
    val goalProgress: JSONObject?,
    val goalSet: JSONObject?,
    val goalSetCategories: JSONArray?,
    val goalSetCategoriesPagination: JSONObject?,
)
