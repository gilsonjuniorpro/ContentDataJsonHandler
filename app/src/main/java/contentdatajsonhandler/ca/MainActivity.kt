package contentdatajsonhandler.ca

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.json.JSONObject
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stringTemplate = readAsset(baseContext)
        val mJSONObject = JSONObject(stringTemplate)

        val listData = parseJsonResult(mJSONObject)

        println(listData.toString())
    }


    companion object {
        fun parseJsonResult(jsonResult: JSONObject): ArrayList<Data> {
            val data = jsonResult.getJSONArray("data")

            val listData = ArrayList<Data>()

            for (i in 0 until data.length()) {
                val jsonObject = data.getJSONObject(i)
                val id = jsonObject.getString("_id")

                val contextValuesJsonObject = jsonObject.getJSONObject("contextValues")
                //val contextValues = mappingContextValues(contextValuesJsonObject)
                val contextValues = ContextValues(
                    contextValuesJsonObject.getString("cvGoalCurrentAmount"),
                    contextValuesJsonObject.getString("cvGoalEndDate"),
                    contextValuesJsonObject.getString("cvGoalEnteredAmount"),
                    contextValuesJsonObject.getString("cvGoalEnteredCategory"),
                    contextValuesJsonObject.getString("cvGoalStartDate"),
                    contextValuesJsonObject.getString("cvIsGoalSet")
                )

                val defaultsJsonObject = jsonObject.getJSONObject("defaults")
                val defaults = Defaults(
                    defaultsJsonObject.getString("txtCurrency"),
                    defaultsJsonObject.getString("numGoalFailedDurationMessage"),
                    defaultsJsonObject.getString("numGoalMetDurationMessage")
                )

                val goalFailedJsonObject = jsonObject.getJSONObject("goalFailed")
                val localizationsGoalFailedJsonObject = goalFailedJsonObject.getJSONObject("localizations")
                val englishGoalFailedJsonObject = localizationsGoalFailedJsonObject.getJSONObject("en")
                val languageEnGoalFailed = LanguageGoalFailed(
                    btnGoalFailed = englishGoalFailedJsonObject.getString("btnGoalFailed"),
                    txtGoalFailedDesc = englishGoalFailedJsonObject.getString("txtGoalFailedDesc"),
                    txtGoalFailedTitle = englishGoalFailedJsonObject.getString("txtGoalFailedTitle")
                )
                val goalFailed = GoalFailed(
                    Localizations(
                        english = languageEnGoalFailed
                    )
                )

                val goalMetJsonObject = jsonObject.getJSONObject("goalMet")
                val localizationsGoalMetJsonObject = goalMetJsonObject.getJSONObject("localizations")
                val englishGoalMetJsonObject = localizationsGoalMetJsonObject.getJSONObject("en")
                val languageMet = LanguageGoalMet(
                    btnGoalMet = englishGoalMetJsonObject.getString("btnGoalMet"),
                    txtGoalMetTitle = englishGoalMetJsonObject.getString("txtGoalMetTitle")
                )
                val goalMet = GoalMet(
                    Localizations(
                        english = languageMet
                    )
                )

                val goalProgressJsonObject = jsonObject.getJSONObject("goalProgress")
                val localizationsGoalProgressJsonObject = goalProgressJsonObject.getJSONObject("localizations")
                val englishGoalProgressJsonObject = localizationsGoalProgressJsonObject.getJSONObject("en")
                val languageGoalProgress = LanguageGoalProgress(
                    txtGoalProgress = englishGoalProgressJsonObject.getString("txtGoalProgress"),
                    txtGoalProgressDesc = englishGoalProgressJsonObject.getString("txtGoalProgressDesc")
                )
                val goalProgress = GoalProgress(
                    Localizations(
                        english = languageGoalProgress
                    )
                )

                val goalSetJsonObject = jsonObject.getJSONObject("goalSet")
                val goalSetEditorJsonObject = goalSetJsonObject.getJSONObject("goalSetEditor")
                val goalAmountJsonObject = goalSetEditorJsonObject.getJSONObject("goalAmount")
                val goalAmount = GoalAmount(
                    numGoalAmountDefault = goalAmountJsonObject.getString("numGoalAmountDefault"),
                    numGoalAmountIncrement = goalAmountJsonObject.getString("numGoalAmountIncrement"),
                )

                val listGoalDurations = mutableListOf<GoalDurations>()
                val listGoalDurationsJsonObject = goalSetEditorJsonObject.getJSONArray("goalDurations")
                for (a in 0 until listGoalDurationsJsonObject.length()) {
                    val listEnglishGoalDurations = listGoalDurationsJsonObject.getJSONObject(a)
                    val localizationsGoalDurationsJsonObject = listEnglishGoalDurations.getJSONObject("localizations")
                    val englishGoalDurationsJsonObject = localizationsGoalDurationsJsonObject.getJSONObject("en")
                    val languageGoalDuration = LanguageGoalDuration(
                        txtGoalDuration = englishGoalDurationsJsonObject.getString("txtGoalDuration")
                    )
                    val localizations = Localizations(
                        english = languageGoalDuration
                    )
                    val numGoalDuration = listEnglishGoalDurations.getString("numGoalDuration")

                    val goalDurations = GoalDurations(
                        localizations,
                        numGoalDuration
                    )
                    listGoalDurations.add(goalDurations)
                }

                val localizationsGoalSetJsonObject = goalSetJsonObject.getJSONObject("localizations")
                val englishGoalSetJsonObject = localizationsGoalSetJsonObject.getJSONObject("en")
                val languageGoalSet = LanguageGoalSet(
                    btnGoalSet = englishGoalSetJsonObject.getString("btnGoalSet"),
                    imgGoalSet = englishGoalSetJsonObject.getString("imgGoalSet"),
                    txtGoalSetDesc = englishGoalSetJsonObject.getString("txtGoalSetDesc"),
                    txtGoalSetTitle = englishGoalSetJsonObject.getString("txtGoalSetTitle")
                )

                val goalSetEditor = GoalSetEditor(
                    goalAmount,
                    listGoalDurations,
                )

                val goalSet = GoalSet(
                    goalSetEditor,
                    Localizations(
                        english = languageGoalSet
                    )
                )

                val listGoalSetCategories = mutableListOf<GoalSetCategories>()
                val goalSetCategoriesJsonObject = jsonObject.getJSONArray("goalSetCategories")
                for (b in 0 until goalSetCategoriesJsonObject.length()) {
                    val listGoalSetCategoriesJsonObject = goalSetCategoriesJsonObject.getJSONObject(b)
                    val localizationsGoalSetCategoriesJsonObject = listGoalSetCategoriesJsonObject.getJSONObject("localizations")
                    val englishGoalSetCategoriesJsonObject = localizationsGoalSetCategoriesJsonObject.getJSONObject("en")
                    val languageGoalSetCategories = LanguageCategory(
                        imgCategory = englishGoalSetCategoriesJsonObject.getString("imgCategory"),
                        imgCategoryGoalMet = englishGoalSetCategoriesJsonObject.getString("imgCategoryGoalMet"),
                        txtCategory = englishGoalSetCategoriesJsonObject.getString("txtCategory"),
                        txtCategoryGoalMet = englishGoalSetCategoriesJsonObject.getString("txtCategoryGoalMet")
                    )
                    val localizations = Localizations(
                        english = languageGoalSetCategories
                    )

                    val txtCategoryID = listGoalSetCategoriesJsonObject.getString("txtCategoryID")

                    listGoalSetCategories.add(
                        GoalSetCategories(
                            localizations,
                            txtCategoryID
                        )
                    )
                }

                val goalSetCategoriesPaginationJsonObject = jsonObject.getJSONObject("goalSetCategories.pagination")
                val goalSetCategoriesPagination = GoalSetCategoriesPagination(
                    limit =   goalSetCategoriesPaginationJsonObject.getString("limit"),
                    offset =   goalSetCategoriesPaginationJsonObject.getString("offset"),
                    totalRecords =   goalSetCategoriesPaginationJsonObject.getString("totalRecords"),
                )

                listData.add(
                    Data(
                        id,
                        contextValues,
                        defaults,
                        goalFailed,
                        goalMet,
                        goalProgress,
                        goalSet,
                        listGoalSetCategories,
                        goalSetCategoriesPagination
                    )
                )
            }

            return listData
        }

        //in case we want to separate
        fun mappingContextValues(contextValuesJsonObject: JSONObject): ContextValues {
            return ContextValues(
                contextValuesJsonObject.getString("cvGoalCurrentAmount"),
                contextValuesJsonObject.getString("cvGoalEndDate"),
                contextValuesJsonObject.getString("cvGoalEnteredAmount"),
                contextValuesJsonObject.getString("cvGoalEnteredCategory"),
                contextValuesJsonObject.getString("cvGoalStartDate"),
                contextValuesJsonObject.getString("cvIsGoalSet")
            )
        }
    }
}

fun readAsset(context: Context): String {
    return context.assets
            .open("ContentData.json")
            .bufferedReader()
            .use(BufferedReader::readText)
}