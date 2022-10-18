package com.example.comparadordefigurinhas

import android.util.Log

object GetInputFigures {

    fun fillList(values: String): List<String> {

        val lines = getLines(values)
        Log.e("hello lines", lines.toString())

        val resultList = mutableListOf<String>()

        lines.forEach {
            val line = processLine(it)
            resultList.addAll(line)
        }

        Log.e("hello result", resultList.toString())

        return resultList
    }

    private fun processLine(it: String, splitPattern: String = " "): List<String> {
        val array = it.split(splitPattern)
        val teamCode = array[0]
        val teamNumbers = array.subList(1, array.size)
        return teamNumbers.map { teamCode + it }
    }

    private fun getLines(values: String): List<String> {
        Log.e("hello values", values)
        return values.split("\n")
    }

    fun processGuestLine(it: String, splitPattern: String = " "): List<String> {
        Log.e("hello user guest", it)

        var list = it.split(splitPattern)

        val tratatedList = mutableListOf<String>()

        list.forEach { m ->
            if(m.contains("(")) {
                tratatedList.add(m.replaceRange(m.indexOf("("), m.indexOf(")") +1, ""))
            }
            else {
                tratatedList.add(m)
            }
        }
        return tratatedList
    }
}