package com.credit.intelligencia.util

sealed class Environment(val url: String) {
    object Main : Environment("http://192.168.43.101:5001/")
}