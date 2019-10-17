package bonch.dev.school.controllers

class CounterBtn(initialCount: Int = 0) {

    var currentCount = initialCount
        private set

    fun increment(amount: Int = 1){
        currentCount += amount
    }
}