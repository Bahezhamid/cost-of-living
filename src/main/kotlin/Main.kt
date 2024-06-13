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
    println("City With Cheapest Internet Connection ")
    println(getCityHasCheapestInternetConnection.execute())
    printSeparationLine()
    val getTenCitiesNameThatHasLowestFruitsAndVegetablesPrices= GetTenCitiesNameThatHasLowestFruitsAndVegetablesPrices(dataSource)
    println("10 City Name With Lowest Fruits And Vegetables Prices ")
    println(getTenCitiesNameThatHasLowestFruitsAndVegetablesPrices.execute())
    printSeparationLine()
    print("Please Enter Country Name:")
    val countryName:String= readlnOrNull().toString()
    val getCitiesAverageSalaryForSpecificCountry=GetCitiesAverageSalaryForSpecificCountryInteractor(dataSource)
    println("City Average Salary For Specific Country : $countryName")
    println(getCitiesAverageSalaryForSpecificCountry.execute(countryName))
    printSeparationLine()
   val getHighestDifferentRentFromInsideCityAndOutsideCity=
       GetHighestDifferentRentFromInsideCityAndOutsideCityInteractor(dataSource)
    println("City With Highest Different Rent From Inside And Outside City")
    println(getHighestDifferentRentFromInsideCityAndOutsideCity.execute())
    printSeparationLine()
    val getFiveCitiesNameHasFamousClothesBrandsWithStablePrice=
        GetFiveCitiesNameHasFamousClothesBrandsWithStablePriceInteractor(dataSource)
    println("5 Cities With Famous Clothes Brands With Stable Price ")
    println(getFiveCitiesNameHasFamousClothesBrandsWithStablePrice.execute())
    printSeparationLine()
    val getTenCitiesNameHasLowestYearNeededToBuyApartments=GetTenCitiesNameHasLowestYearNeededToBuyApartmentsInteractor(dataSource)
    println("10 Cities Name With Lowest Year Needed For Buying Apartments")
    println(getTenCitiesNameHasLowestYearNeededToBuyApartments.execute())
    printSeparationLine()
    val citiesWithCheapestBananaPrice=SortCitiesWithCheapestBananaPriceInteractor(dataSource)
    println("Enter City Names Seperated By (,)")
    var cityNames= readLine()?.split(",")?.map { it.trim() }?.toTypedArray()
    println("Sorted Cities With Cheapest Banana Price")
    print(cityNames?.let { citiesWithCheapestBananaPrice.execute(*it) })
    printSeparationLine()
   val getCityWithMedianMealPrice=GetCityWithMedianMealPriceInteractor(dataSource)
   println("City With Median Meal Price")
    println(getCityWithMedianMealPrice.execute())
    printSeparationLine()
    val getTenCountriesThatEnforceHighTaxOnCarbonatedDrinks=GetTenCountriesThatEnforceHighTaxOnCarbonatedDrinksInteractor(dataSource)
    println("10 Country Name That Enforce High Tax On Carbonated Drinks")
    println(getTenCountriesThatEnforceHighTaxOnCarbonatedDrinks.execute())
    printSeparationLine()
    val getMostSuitableCityForTheFamilyToSaveMoneyPerMonth=GetMostSuitableCityForTheFamilyToSaveMoneyPerMonthInteractor(dataSource)
    println("Most Suitable City For TheFamily To Save Money Per Month")
    println(getMostSuitableCityForTheFamilyToSaveMoneyPerMonth.execute())


}
private fun printSeparationLine(){
    print("\n_______________________________\n")
}

