package com.cansa.distri.model

data class User(
    val id: String,
    val email: String,
    val password: String
) {

    fun maperUser(): MutableMap<User>{

    }

}