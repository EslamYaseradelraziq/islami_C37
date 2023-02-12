package com.example.islamic37fri

class HouseBuilder(builder: Builder) {
    var pramm1: String? = null
    var pramm2: Int? = null
    var pramm3: Boolean? = null


    class Builder {
        private var pramm1: String? = null
        private var pramm2: Int? = null
        private var pramm3: Boolean? = null


        fun setPramm1(pram1: String) {
            this.pramm1 = pram1
        }

    }

}

class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val fish: String?
) {

    class Hamurger(
        var cheese: String,
        var onien: String,
        var beef: String
    )

    class Builder {
        var cheese: String? = null
        var onien: String? = null
        var beef: String? = null

        fun cheese(cheese: String) = apply { this.cheese = cheese }
        fun onien(onien: String) = apply { this.onien = onien }
        fun beef(beef: String) = apply { this.beef = beef }

        init {
            fun build() = Hamurger(cheese!!, onien!!, beef!!)
        }

    }

}


//Factory Pattern

