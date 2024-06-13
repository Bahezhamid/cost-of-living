package interactor
import kotlin.math.*

import model.CityEntity

class GetCityHasCheapestInternetConnectionInteractor(
    private val dataSource: CostOfLivingDataSource,
) {

    fun execute(): CityEntity{
            return dataSource.getAllCitiesData().filter(::excludeNullSalariesAndLowQualityData)
                .sortedBy{ it.averageMonthlyNetSalaryAfterTax!!/it.servicesPrices.internet60MbpsOrMoreUnlimitedDataCableAdsl!! }.last()
    }
    private fun excludeNullSalariesAndLowQualityData(city: CityEntity): Boolean {
        return city.averageMonthlyNetSalaryAfterTax != null
                && city.servicesPrices.internet60MbpsOrMoreUnlimitedDataCableAdsl !=null
                && city.dataQuality
    }


}