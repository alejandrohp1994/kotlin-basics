import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

@Serializable
data class Character(

    var _id: String ,
    var characterName: String,
    var description: String,
    var imageBigBinary: String,
    var imageSmallBinary: String
) {}

data class AllCharactersResponse(val results: List<Character>)

interface MongoDBDataAPI {
    @POST("endpoint/data/v1/action/find")
    fun getAllCharacters(
        @Header("api-key") apiKey: String,
        @Body request: Map<String, Any>
    ): Call<AllCharactersResponse>
}

fun main() {
    val apiKey = "64347861bdb170624383d5f2"
    val request = mapOf(
                "dataSource" to "MarioBrosCluster",
                "database" to "MarioBros",
                "collection" to "CharactersV2",
                "filter" to "{}"
            )

    val retrofit = Retrofit.Builder()
        .baseUrl("https://us-east-1.aws.data.mongodb-api.com/app/data-ggcfb/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val mongoDBDataAPI = retrofit.create(MongoDBDataAPI::class.java)
    val call = mongoDBDataAPI.getAllCharacters(apiKey, request)

    val response = call.execute()
    if (response.isSuccessful) {
        val allCharactersResponse = response.body()
        val characters = allCharactersResponse?.results ?: emptyList()
        characters.forEach {
            println("${it._id}: ${it.characterName}")
        }
    } else {
        println("Error: ${response.code()} - ${response.message()}")
    }
}