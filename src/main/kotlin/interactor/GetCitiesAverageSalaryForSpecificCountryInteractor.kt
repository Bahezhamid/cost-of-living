package interactor
import model.CityEntity
class GetCitiesAverageSalaryForSpecificCountryInteractor(private val dataSource: CostOfLivingDataSource) {
    fun execute(countryName: String): List<Pair<String, Float>> {
        return dataSource.getAllCitiesData().filter { it.country.equals(countryName , ignoreCase = true) }
            .filter(::excludeNullSalariesAndLowQualityData).takeIf { it.isNotEmpty()}
            ?.map { it.cityName to it.averageMonthlyNetSalaryAfterTax!! } ?: throw Exception("Please Enter Country Name")
    }

    private fun excludeNullSalariesAndLowQualityData(city: CityEntity): Boolean {
        return city.averageMonthlyNetSalaryAfterTax != null && city.dataQuality
    }
}