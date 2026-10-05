// 1. 189609 Amuto Jim Onyango
// 2 . 191351 Gatiti Estelle Nyawira
// 3 . 167298 Moye Jemima Thadeus
//4 . 168381 Wambui Nicholas Njue

fun main (){
 println("-----------------------------------------------------------------------------------------")

 println ("welcome to tenant management system")

 //1.1 and 2.1
 val TenantID : Int = 1001
 val Name : String = "Jane Wanjiku"
 val phone : String = "0712345678" //stored as string because 1.most phone numbers have a plus sign 2. there is no mathematical operations done on phone numbers
 val houseNumber : String = "A-204"
 val monthlyRent : Int = 25000
 var amountPaid : Int = 15000 // is var because the client can pay different amounts
 //2.2
 val Block : Char = 'A'
 var isActive : Boolean = true
 //2.3
 val rentAsDouble: Double = monthlyRent.toDouble() // Kotlin: Initializer type mismatch: expected 'Double', actual 'Int'
 //why typecasting

 // To make the developer's intention explicit and clear in the code.
 //To prevent accidental loss of precision or unintended type changes, making the code more predictable and safer.
 println("-----------------------------------------------------------------------------------------")

 // 1.2
 println("amount paid before $amountPaid")
 amountPaid += 5000
 println("amount paid after $amountPaid")

 println("-----------------------------------------------------------------------------------------")

 //1.3
 //TenantID= 1002
//the error is showing Kotlin: 'val' cannot be reassigned.
 //the compiler refuses because TenantId is immmutable
 // changing from "val" to "var" would make it compile

 //2.4
 val registrationNumber : Long = 999_999_999L

 //3.1
 println(Name + " lives in house " + houseNumber)
 //string template
 println("$Name lives in house $houseNumber") //this one is easier to read

 println("-----------------------------------------------------------------------------------------")

// 3.3
 val leaseMonths = 6
 println("Total rent for 6 months: ${monthlyRent * leaseMonths}")

 println("-----------------------------------------------------------------------------------------")

 //3.4
 val receipt = """
        Tenant: $Name
        House: $houseNumber
        Paid: KES $amountPaid
    """.trimIndent() //strips indents at the beginning of each line of your code
 println(receipt)
 println("-----------------------------------------------------------------------------------------")

 //3.5
 var greeting = "Dear Tenant" //strings are immutable so you have to change it to var to change it
 greeting = greeting.uppercase()
 println(greeting)
 println("-----------------------------------------------------------------------------------------")

// 4
 //4.1
 var Balance = monthlyRent-amountPaid
 println("Balance: $Balance")

 //4.2
 // val percentPaid = (amountPaid / monthlyRent) * 100
 //  println("Paid: $percentPaid%")
 // incorrect
 // kotlin gave that answer because Kotlin uses strict integer division when both numbers on either side of the / operator are integers.

 // 1. convert to double

 //val percentPaid = (amountPaid.toDouble()/monthlyRent) * 100
 //println("Percent: ${percentPaid.toInt()}")

 //2.
 val percentPaid = (amountPaid * 100) / monthlyRent
 println("-----------------------------------------------------------------------------------------")

 println("Paid: $percentPaid%")

 println("-----------------------------------------------------------------------------------------")
 //4.3
 val installments : Int = 6000
 println("Full installments:${monthlyRent/installments}")
 println("Remaining amount:${monthlyRent% installments}")


 //4.4
 val totalRent = monthlyRent.times(6)

 println("-----------------------------------------------------------------------------------------")
 // 4.5
 var isRentPaid: Boolean= amountPaid>= monthlyRent
 println ("Is the rent paid:${isRentPaid}")

 println("-----------------------------------------------------------------------------------------")

 // 4.6
 val rentOutstanding : Boolean = true
 var monthsInArrears = 2
 val needsReminder = rentOutstanding && monthsInArrears > 1
 println("Needs reminder: $needsReminder") // is true because both conditions were fulfilled

 println("-----------------------------------------------------------------------------------------")
//5.1
 //if(amountPaid >= monthlyRent){
 //   println("fully paid")

//    }else{
 //       println("Rent is outstanding")
 //  }

 //5.2
 if (Balance<=0){
  println("Rent is fully paid")
 }else if(Balance<10000){
  println("Small outstanding balance")
 }else{
  println("Large outstanding balance")
 }

 //5.3
 when{
  Balance<=0 -> println("Rent is fully paid")
  Balance<10000 -> println("Small outstanding balance")
  else -> println("Large outstanding balance")
 }

 println("-----------------------------------------------------------------------------------------")
 //5.4
 when (monthsInArrears){
  0-> println("Rent is up to date")
  in 1..2 -> println("Early arrears")
  in 3..5 -> println("Serious arrears")
  in 6..12 -> println("Critical arrears")
  else-> println("Serious arrears")
 }

 println("-----------------------------------------------------------------------------------------")
 //5.5
 val tenantStatus: String = "ACTIVE"
 when (tenantStatus){
  "ACTIVE" -> println("Tenant is currently occupying the property")
  "VACATED" -> println("Tenant has moved out")
  "PENDING" -> println("Tenant registration is pending")
  else -> println("Unknown tenant status")
 }

 println("-----------------------------------------------------------------------------------------")
 //6.1
 for (month in 1..12){
  println("month:$month")
 }
 println("-----------------------------------------------------------------------------------------")
 //6.2
 for (month in 1..12 step 2) {
  println("Checking payment history for month $month")
 }
 println("-----------------------------------------------------------------------------------------")
 //6.3
 for (month in 5 downTo 1) {
  println(month)
 }
 println("-----------------------------------------------------------------------------------------")
 //6.4
 val Tenants = arrayOf( "Jane", "Brian", "Mary", "David")
 for ((index, tenant) in Tenants.withIndex()) {
  println("${index + 1}. $tenant")
 }
 //its index plus one because the array starts at 0
 println("-----------------------------------------------------------------------------------------")
//6.5
 var vacantHouses=0
 while (vacantHouses > 0) { println("Checking vacant houses...") }
 do { println("Checking vacant houses...") } while (vacantHouses > 0)
 //the first one runs provided the condition is met and second one runs before the condition is met at first
 println("-----------------------------------------------------------------------------------------")

//6.6
 repeat(3) {
  print("\nPlease pay your rent\n")
 }
 println("-----------------------------------------------------------------------------------------")

// 7.1
 val tenants = mutableListOf(
  "Jane Wanjiku", "Brian Otieno", "Mary Achieng", "John Kamau"
 )
 println(tenants.first())
 println(tenants.last())
 //7.2
 //error gotten Kotlin: Unresolved reference 'add'
 //tenants.add("David Mwangi")
 //we need to make it a mutable list
 tenants.add("David Mwangi")
 tenants.remove("Brian Otieno")
 println("Tenants: $tenants , size ${tenants.size}")
 println("-----------------------------------------------------------------------------------------")

 //7.3
 val houseNumbers = arrayOf(
  "A-101",
  "A-102",
  "A-103",
  "A-104"
 )

 println(houseNumbers[1])
 println("-----------------------------------------------------------------------------------------")
 houseNumbers[0] = "A-201"
 println(houseNumbers.joinToString())
 // 7.4
 // 1.Now Print with util
 // 2.using join.to.String

 println("-----------------------------------------------------------------------------------------")
 //7.5
 val blockA = intArrayOf(1, 2, 3)
 val blockB = intArrayOf(4, 5, 6)
 //val combined = blockA + blockB
 val combined = blockB + blockA
 println(combined.joinToString())
 // Rule Explanation:
 // The '+' operator performs array concatenation, which merges arrays from left to right.
 // The left array forms the start of the new array, and the right array is appended to the end.
 // Swapping to 'blockB + blockA' outputs [4, 5, 6, 1, 2, 3] because blockB elements are placed first.
 println("-----------------------------------------------------------------------------------------")
 //7.6
 // you can add or remove elements in a mutable list but in an array it has a fixed size
 // you can update elements at specific positions but in a a read only list you cannot since its immutable:w

//8.1
 //val tenantEmail: String = null
 //error given Kotlin: Null cannot be a value of a non-null type 'String'.
 //you add question mark after the string

 //8.2
 var tenantEmail: String? = null
 println("Tenant email : $tenantEmail")
 // so we dont show null because its technical to property manager
 println("-----------------------------------------------------------------------------------------")

 //8.3
 tenantEmail = "jane@example.com"
 var email = tenantEmail ?: "Email not provided"
 println("Tenant email is :$email")

 println("-----------------------------------------------------------------------------------------")

 //8.4
 tenantEmail = null
 println(tenantEmail?.length)
 println(tenantEmail?.length ?: 0)
 //println(tenantEmail!!.length)
 // 1.Uses the non-null asserted (!!) operator: forces a nullable type
 // to non-null, throwing a NullPointerException if the value is null
 // 2.Justified only when external guarantees ensure the value is never
 // null
 println("-----------------------------------------------------------------------------------------")
 //val nextOfKin: String ? = null
 val nextOfKin: String ? = "Estelle Gatiti"
 println(nextOfKin?.uppercase()?:"No next of kin to record")
 println("-----------------------------------------------------------------------------------------")



}