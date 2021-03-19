package contentdatajsonhandler.ca

data class GoalSetEditor(
    val goalAmount: GoalAmount? = null,
    val goalDurations: List<GoalDurations>? = listOf()
)
