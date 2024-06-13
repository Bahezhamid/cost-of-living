package interactor

import model.CityEntity

class GetTenCountriesThatEnforceHighTaxOnCarbonatedDrinksInteractor(private val dataSource: CostOfLivingDataSource) {
fun execute(): List<Pair<String,Float>> {
    return findTaxOnCokeForCities(dataSource.getAllCitiesData().filter (::excludeNullValuesAndDataQuality))
        .map {it.first to it.second/it.third.toFloat()  }.sortedByDescending { it.second }.take(10)
}
    private fun excludeNullValuesAndDataQuality(city: CityEntity):Boolean{
        return city.drinksPrices.cokePepsiAThirdOfLiterBottleInRestaurants!=null
                && city.dataQuality

    }
    private fun findTaxOnCokeForCities(listOfCity:List<CityEntity>):MutableList<Triple<String,Float,Int>>{
        val listOfCountry=mutableListOf<Triple<String,Float,Int>>()
        listOfCity.forEach {city->
            if(listOfCountry.none{it.first==city.country}){
                listOfCountry.add(Triple(city.country,0.0f,0))
            }
            val existingCountry = listOfCountry.find { it.first == city.country }
            if(existingCountry!=null){
                listOfCountry.remove(existingCountry)
                listOfCountry.add(Triple(city.country,
                    existingCountry.second+city.drinksPrices.cokePepsiAThirdOfLiterBottleInRestaurants!!,
                    existingCountry.third+1))
            }
        }

        return listOfCountry
    }
}

