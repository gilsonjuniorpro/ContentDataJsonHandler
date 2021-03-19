package contentdatajsonhandler.ca

data class Data(
    val id: String,
    val contextValues: ContextValues? = null,
    val defaults: Defaults? = null,
    val goalFailed: GoalFailed? = null,
    val goalMet: GoalMet? = null,
    val goalProgress: GoalProgress? = null,
    val goalSet: GoalSet? = null,
    val goalSetCategories: List<GoalSetCategories>? = listOf(),
    val goalSetCategoriesPagination: GoalSetCategoriesPagination? = null
)
