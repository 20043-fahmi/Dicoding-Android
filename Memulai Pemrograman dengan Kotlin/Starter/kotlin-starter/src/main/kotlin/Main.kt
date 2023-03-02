import kotlinx.coroutines.*
//import kotlin.system.measureTimeMillis
//
//suspend fun getCapital (): Int {
//    delay(10000L)
//    return 50000
//}
//
//suspend fun getIncome (): Int {
//    delay (10000L)
//    return 75000
//}
//
//fun main () = runBlocking {
//    val timeOne = measureTimeMillis {
//        val capital = getCapital()
//        val income = getIncome()
//        println("Your profit is ${income - capital}")
//    }
//
//    val timeTwo = measureTimeMillis {
//        val capital = async {getCapital()}
//        val income = async {getIncome()}
//        println("Your profit is ${ income.await()  -  capital.await() }")
//    }
//
//    println("Complited in $timeOne & $timeTwo ms")
//}

@InternalCoroutinesApi
fun main () = runBlocking {
    val job = launch {
        delay(5000L)
        println("Start new job!")
    }

    delay(2000L)
    job.cancel(cause = CancellationException("time is up!"))
    println("Cancelling job...")
    if (job.isCancelled){
        println("Job is cancelled because ${job.getCancellationException().message}")
    }
}