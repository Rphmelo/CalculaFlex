package br.com.rphmelo.calculaflex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)