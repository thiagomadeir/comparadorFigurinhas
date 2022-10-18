package com.example.comparadordefigurinhas

object CompareFigures {
    fun compare(missing: List<String>, repeat: List<String>): List<String> {

        val result = mutableListOf<String>()

        missing.forEach { m ->
            val contain = repeat.contains(m)

            if (contain) {
                result.add(m)
            }
        }

        return result
    }
}
