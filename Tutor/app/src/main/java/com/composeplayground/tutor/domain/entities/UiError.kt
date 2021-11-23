package com.composeplayground.tutor.domain.entities

data class UiError(
    val header: String,
    val message:String,
    val isActionRequired:Boolean = false
)