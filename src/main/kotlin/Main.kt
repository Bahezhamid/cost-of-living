import dataSource.CsvDataSource
import dataSource.utils.CsvParser
import interactor.*

fun main() {
    val csvParser = CsvParser()
    val dataSource: CostOfLivingDataSource = CsvDataSource(csvParser)

    val getHighestSalaryAverageCities = GetHighestSalaryAverageCititesNamesInteractor(dataSource)
    println(getHighestSalaryAverageCities.execute(limit = 10))
    printSeparationLine()
    val getCityHasCheapestInternetConnection= GetCityHasCheapestInternetConnectionInteractor(dataSource)
    println(getCityHasCheapestInternetConnection.execute())
    printSeparationLine()
    val getTenCitiesNameThatHasLowestFruitsAndVegetablesPrices= GetTenCitiesNameThatHasLowestFruitsAndVegetablesPrices(dataSource)
    println(getTenCitiesNameThatHasLowestFruitsAndVegetablesPrices.execute())
    printSeparationLine()
    print("Please Enter Country Name:")
    val countryName:String= readlnOrNull().toString()
    val getCitiesAverageSalaryForSpecificCountry=GetCitiesAverageSalaryForSpecificCountryInteractor(dataSource)
    println(getCitiesAverageSalaryForSpecificCountry.execute(countryName))
    printSeparationLine()
   val getHighestDifferentRentFromInsideCityAndOutsideCity=
       GetHighestDifferentRentFromInsideCityAndOutsideCityInteractor(dataSource)
    println(getHighestDifferentRentFromInsideCityAndOutsideCity.execute())
    printSeparationLine()
    val getFiveCitiesNameHasFamousClothesBrandsWithStablePrice=
        GetFiveCitiesNameHasFamousClothesBrandsWithStablePriceInteractor(dataSource)
    println(getFiveCitiesNameHasFamousClothesBrandsWithStablePrice.execute())
    printSeparationLine()
    val getTenCitiesNameHasLowestYearNeededToBuyApartments=GetTenCitiesNameHasLowestYearNeededToBuyApartmentsInteractor(dataSource)
    println(getTenCitiesNameHasLowestYearNeededToBuyApartments.execute())
    printSeparationLine()
    val SortCitiesWithCheapestBananaPrice=SortCitiesWithCheapestBananaPriceInteractor(dataSource)
    println("Enter City Names Seperated By (,)")
    var cityNames= readLine()?.split(",")?.map { it.trim() }?.toTypedArray()
    print(cityNames?.let { SortCitiesWithCheapestBananaPrice.execute(*it) })
    printSeparationLine()
   val getCityWithMedianMealPrice=GetCityWithMedianMealPriceInteractor(dataSource)
    println(getCityWithMedianMealPrice.execute())
    printSeparationLine()
    val getTenCountriesThatEnforceHighTaxOnCarbonatedDrinks=GetTenCountriesThatEnforceHighTaxOnCarbonatedDrinksInteractor(dataSource)
    println(getTenCountriesThatEnforceHighTaxOnCarbonatedDrinks.execute())
    printSeparationLine()
    val getMostSuitableCityForTheFamilyToSaveMoneyPerMonth=GetMostSuitableCityForTheFamilyToSaveMoneyPerMonthInteractor(dataSource)
    println(getMostSuitableCityForTheFamilyToSaveMoneyPerMonth.execute())


}
private fun printSeparationLine(){
    print("\n_______________________________\n")
}

