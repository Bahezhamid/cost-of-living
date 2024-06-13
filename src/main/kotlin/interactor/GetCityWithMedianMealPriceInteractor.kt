package interactor
import model.CityEntity
import kotlin.math.*

class GetCityWithMedianMealPriceInteractor(private val dataSource: CostOfLivingDataSource) {
    fun execute():CityEntity {
      val filteredCities=dataSource.getAllCitiesData().filter(::excludeNullValuesAndOtherCountry)
        return filteredCities.minByOrNull {
            min(
                abs(it.mealsPrices.mealInexpensiveRestaurant!!-medianPriceOfMeal(filteredCities)),
                min(abs(it.mealsPrices.mealAtMcDonaldSOrEquivalent!!-medianPriceOfMeal(filteredCities)),
                    abs((it.mealsPrices.mealFor2PeopleMidRangeRestaurant!!/2)-medianPriceOfMeal(filteredCities))
                )
            )

        }!!

    }
    private fun excludeNullValuesAndOtherCountry(city:CityEntity):Boolean{
        return city.mealsPrices.mealInexpensiveRestaurant!=null
                && city.mealsPrices.mealAtMcDonaldSOrEquivalent!=null
                && city.mealsPrices.mealFor2PeopleMidRangeRestaurant!=null
                && (city.country=="Mexico"
                || city.country=="Canada"
                || city.country=="United States")
    }
    private fun citiesCheapestMealPrice(city: CityEntity):Float{
        return min(city.mealsPrices.mealAtMcDonaldSOrEquivalent!!, min(
           city.mealsPrices.mealInexpensiveRestaurant!!
           ,city.mealsPrices.mealFor2PeopleMidRangeRestaurant!!/2.0f)
        )
    }
    private fun citiesHighestMealPrice(city: CityEntity):Float{
        return max(city.mealsPrices.mealAtMcDonaldSOrEquivalent!!, max(
            city.mealsPrices.mealInexpensiveRestaurant!!
            ,city.mealsPrices.mealFor2PeopleMidRangeRestaurant!!/2.0f)
        )
    }
    private fun medianPriceOfMeal(listOfCities: List<CityEntity>):Float{
        return ( listOfCities.sortedBy { citiesHighestMealPrice(it) }.map { citiesHighestMealPrice(it) }.last()
                + listOfCities.sortedBy { citiesCheapestMealPrice(it) }.map { citiesCheapestMealPrice(it) }.first())/2
    }
}