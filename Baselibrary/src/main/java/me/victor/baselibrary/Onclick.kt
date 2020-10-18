package me.victor.baselibrary

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Onclick(val list: IntArray)