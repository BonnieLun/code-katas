package com.byinal

import java.util.*
import kotlin.test.assertFalse


// For a given array of numbers and a 'targetProduct',
// find two numbers 'a' and 'b' from the input array so that:
// 		a * b = targetProduct
//
// Example:
// input: [1, 3, 5, 5, 10], targetProduct: 50 , result: true (5, 10)
// input: [1, 3, 4, 11], targetProduct: 15, result: false
class TargetProduct {


    fun canFindTargetProduct(numbers: Array<Int>, targetProduct: Int): Boolean {
        numbers.forEach {
            if (targetProduct.rem(it) == 0)
                if (numbers.asList().contains(targetProduct.div(it))) return true
        }
        return false
    }

}

fun main(args: Array<String>) {
    var example: TargetProduct = TargetProduct()
    val numbersFor50 = arrayOf(1, 3, 5, 5, 10)
    val numbersFor15 = arrayOf(1, 3, 4, 11)
    assert(example.canFindTargetProduct(numbersFor50, 50))
    assertFalse { example.canFindTargetProduct(numbersFor15, 15) }
}