package interactor
import model.CityEntity
import kotlin.math.*
class GetHighestDifferentRentFromInsideCityAndOutsideCityInteractor(private val dataSource: CostOfLivingDataSource) {
    fun execute():CityEntity {
        return dataSource.getAllCitiesData().filter(::excludeNullValueAdnLowQualityData)
            .sortedBy {
                abs(it.realEstatesPrices.apartment3BedroomsInCityCentre!!-it.realEstatesPrices.apartment3BedroomsOutsideOfCentre!!)
                + abs(it.realEstatesPrices.apartmentOneBedroomInCityCentre!!-it.realEstatesPrices.apartmentOneBedroomOutsideOfCentre!!)
            }.last()
    }
    private fun excludeNullValueAdnLowQualityData(city: CityEntity): Boolean {
        return  city.dataQuality && city.realEstatesPrices.apartment3BedroomsInCityCentre !=null
                &&  city.realEstatesPrices.apartment3BedroomsOutsideOfCentre !=null
                && city.realEstatesPrices.apartmentOneBedroomInCityCentre !=null
                && city.realEstatesPrices.apartmentOneBedroomOutsideOfCentre !=null


    }
}