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
                val localizationsFailedJsonObject = goalFailedJsonObject.getJSONObject("localizations")
                val englishFailedJsonObject = localizationsFailedJsonObject.getJSONObject("en")
                val languageEnFailed = Language(
                    btnGoalFailed = englishFailedJsonObject.getString("btnGoalFailed"),
                    txtGoalFailedDesc = englishFailedJsonObject.getString("txtGoalFailedDesc"),
                    txtGoalFailedTitle = englishFailedJsonObject.getString("txtGoalFailedTitle")
                )
                val goalFailed = GoalFailed(
                    Localizations(
                       english = languageEnFailed
                    )
                )

                val goalMetJsonObject = jsonObject.getJSONObject("goalMet")
                val localizationsMetJsonObject = goalMetJsonObject.getJSONObject("localizations")
                val englishMetJsonObject = localizationsMetJsonObject.getJSONObject("en")
                val languageMet = Language(
                        btnGoalMet = englishMetJsonObject.getString("btnGoalMet"),
                        txtGoalMetTitle = englishMetJsonObject.getString("txtGoalMetTitle")
                )
                val goalMet = GoalMet(
                    Localizations(
                        english = languageMet
                    )
                )


                val goalProgressJsonObject = jsonObject.getJSONObject("goalProgress")
                val goalSetJsonObject = jsonObject.getJSONObject("goalSet")
                val goalSetCategoriesJsonObject = jsonObject.getJSONArray("goalSetCategories")
                val goalSetCategoriesPaginationJsonObject = jsonObject.getJSONObject("goalSetCategories.pagination")

                listData.add(
                    Data(
                        id,
                        contextValues,
                        defaults,
                        goalFailed,
                        goalMet,
                        goalProgressJsonObject,
                        goalSetJsonObject,
                        goalSetCategoriesJsonObject,
                        goalSetCategoriesPaginationJsonObject
                    )
                )
            }

            return listData
        }
    }
}

fun readAsset(context: Context): String {
    return context.assets
            .open("ContentData.json")
            .bufferedReader()
            .use(BufferedReader::readText)
}