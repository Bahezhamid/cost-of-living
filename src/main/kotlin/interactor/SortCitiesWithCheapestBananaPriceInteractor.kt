package interactor

import model.CityEntity

class SortCitiesWithCheapestBananaPriceInteractor(private val dataSource: CostOfLivingDataSource) {
    fun execute(vararg cityNames: String): List<String> {
        return dataSource.getAllCitiesData().filter { cityNames.contains(it.cityName) }
            .filter{it.fruitAndVegetablesPrices.banana1kg!=null}
            .sortedBy { it.fruitAndVegetablesPrices.banana1kg }.map { it.cityName }
    }
}



