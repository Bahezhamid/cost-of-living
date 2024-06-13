package interactor

import model.CityEntity

class GetTenCitiesNameHasLowestYearNeededToBuyApartmentsInteractor (private val dataSource: CostOfLivingDataSource) {
    fun execute() : List<Pair<String,Double>> {
        return dataSource.getAllCitiesData().filter(::excludeNullValuesAndDataQuality)
            .sortedBy{getYearNeededForBayApartmentOutSideOfCityCenter(it).second}
            .map(::getYearNeededForBayApartmentOutSideOfCityCenter).take(10)
    }
    private fun excludeNullValuesAndDataQuality(city:CityEntity):Boolean{
        return city.averageMonthlyNetSalaryAfterTax !=null &&
        city.realEstatesPrices.pricePerSquareMeterToBuyApartmentOutsideOfCentre!=null &&
                city.dataQuality
    }
    private fun getYearNeededForBayApartmentOutSideOfCityCenter(city: CityEntity) :Pair<String,Double>{
        var priceOf100meters= city.realEstatesPrices.pricePerSquareMeterToBuyApartmentOutsideOfCentre?.times(100)
        var monthCounter=0
        var yearCounter=0.0
        while(priceOf100meters!!>=city.averageMonthlyNetSalaryAfterTax!!){
            priceOf100meters-=city.averageMonthlyNetSalaryAfterTax
            monthCounter++
        }
        while(monthCounter>=12){
            monthCounter-=12
            yearCounter++
        }
        val remaingMonth="0.${monthCounter.toString()}"
        yearCounter+=remaingMonth.toDouble()
        return city.cityName to yearCounter
    }

}