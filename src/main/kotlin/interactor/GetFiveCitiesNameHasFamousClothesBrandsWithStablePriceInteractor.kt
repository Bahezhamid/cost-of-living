package interactor

import model.CityEntity

class GetFiveCitiesNameHasFamousClothesBrandsWithStablePriceInteractor(private val dataSource: CostOfLivingDataSource) {
    fun execute() : List<String> {
        return dataSource.getAllCitiesData().filter (::excludeNullValues)
            .sortedBy{ it.clothesPrices.onePairOfMenLeatherBusinessShoes!!
                it.clothesPrices.onePairOfJeansLevis50oneOrSimilar!!
                it.clothesPrices.onePairOfNikeRunningShoesMidRange!!
                +it.clothesPrices.oneSummerDressInAChainStoreZaraHAndM!!
            }.take(5).map { it.cityName }

    }
    private fun excludeNullValues(city :CityEntity): Boolean{
        return city.clothesPrices.onePairOfJeansLevis50oneOrSimilar !=null &&
                city.clothesPrices.onePairOfMenLeatherBusinessShoes !=null &&
                city.clothesPrices.onePairOfNikeRunningShoesMidRange !=null &&
                city.clothesPrices.oneSummerDressInAChainStoreZaraHAndM !=null

    }


}