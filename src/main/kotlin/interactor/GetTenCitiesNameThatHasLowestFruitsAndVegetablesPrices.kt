package interactor


import model.CityEntity
class GetTenCitiesNameThatHasLowestFruitsAndVegetablesPrices(private val dataSource :CostOfLivingDataSource,) {
    fun execute() : List<String> {
        return dataSource.getAllCitiesData().filter(::excludeNullSalariesAndLowQualityData)
            .sortedByDescending {it.averageMonthlyNetSalaryAfterTax!!/(it.fruitAndVegetablesPrices.banana1kg!!
                    +it.fruitAndVegetablesPrices.tomato1kg!!+it.fruitAndVegetablesPrices.onion1kg!!
                    +it.fruitAndVegetablesPrices.potato1kg!!+it.fruitAndVegetablesPrices.apples1kg!!
                    +it.fruitAndVegetablesPrices.lettuceOneHead!!) }.take(10)
            .map { it.cityName }
    }
    private fun excludeNullSalariesAndLowQualityData(city: CityEntity): Boolean {
        return city.averageMonthlyNetSalaryAfterTax != null
                && city.fruitAndVegetablesPrices.apples1kg !=null
                && city.fruitAndVegetablesPrices.banana1kg !=null
                && city.fruitAndVegetablesPrices.onion1kg !=null
                && city.fruitAndVegetablesPrices.potato1kg !=null
                && city.fruitAndVegetablesPrices.tomato1kg !=null
                && city.fruitAndVegetablesPrices.lettuceOneHead !=null
    }

}

