import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class Practice {
}

/** Extension Function */

fun main1() {
    val num1 = 7
    val num2 = 10
    println("$num1 is prime: ${num1.isPrime()}") // Output: true
    println("$num2 is prime: ${num2.isPrime()}") // Output: false
    val numbers = listOf(1, 2, 3, 4, 5)
    println(numbers.sumtheNum()) // Output: 15
}

fun Int.isPrime(): Boolean {
    if (this <= 1) return false
    for (i in 2 until this) {
        if (this % i == 0) {
            return false
        }
    }
    return true
}

fun List<Int>.sumtheNum():Int{
    var sum = 0
    for (i in this){
        sum += i
    }
    return sum
}
    /**--------------------------------------------*/

    /** Asynchronous task with kotlin Coroutine */


    fun main() {
        // Start a coroutine
        GlobalScope.launch {
            println("Coroutine started")

            // Perform asynchronous tasks
            val result1 = async { fetchData1() }
            val result2 = async { fetchData2() }

            // Wait for the results of both tasks
            val data1 = result1.await()
            val data2 = result2.await()

            // Process the results
            println("Data received: $data1, $data2")

            // Coroutine completed
            println("Coroutine completed")
        }
        // Keep the main thread alive
        Thread.sleep(2000L) // Wait for 2 seconds to allow coroutines to complete
    }

        // Simulated asynchronous tasks
suspend fun fetchData1(): String {
    delay(3000L) // Simulate some asynchronous operation
    return "Data from source 1"
}

suspend fun fetchData2(): String {
    delay(3000L) // Simulate some asynchronous operation
    return "Data from source 2"
}

/**----------------------------------*/

/*
class pAdapter : RecyclerView.Adapter<pAdapter.ViewHolder>(){


    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }
}
*/



