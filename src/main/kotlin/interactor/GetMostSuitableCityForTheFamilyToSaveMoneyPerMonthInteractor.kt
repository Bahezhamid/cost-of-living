package interactor
import kotlin.math.*
import model.CityEntity

class GetMostSuitableCityForTheFamilyToSaveMoneyPerMonthInteractor(private val dataSource: CostOfLivingDataSource) {
fun execute():CityEntity {
    return dataSource.getAllCitiesData().filter(::excludeNullValues).minByOrNull {
        it.averageMonthlyNetSalaryAfterTax!! * 2
        -(it.realEstatesPrices.apartment3BedroomsInCityCentre!!
                + (it.foodPrices.localCheese1kg!!)
                + (it.foodPrices.loafOfFreshWhiteBread500g!! * 30)
                + (it.foodPrices.beefRound1kgOrEquivalentBackLegRedMeat!! * 4)
                + (it.foodPrices.chickenFillets1kg!! * 10)
                + (it.foodPrices.riceWhite1kg!! * 2)
                + 250.0f)
    }!!
}
    private fun excludeNullValues(city:CityEntity):Boolean{
        return city.averageMonthlyNetSalaryAfterTax!=null
                &&city.foodPrices.riceWhite1kg!=null
                &&city.foodPrices.beefRound1kgOrEquivalentBackLegRedMeat!=null
                &&city.foodPrices.localCheese1kg!=null
                &&city.foodPrices.chickenFillets1kg!=null
                &&city.foodPrices.loafOfFreshWhiteBread500g!=null
                &&city.realEstatesPrices.apartment3BedroomsInCityCentre!=null
                &&city.realEstatesPrices.apartment3BedroomsOutsideOfCentre!=null
    }




}