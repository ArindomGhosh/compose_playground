package com.composeplayground.tutor.domain.entities

data class UiError(
    val header: String,
    val message:String,
    val isActionRequired:Boolean = false
)

inline fun Throwable.toUiError():UiError{
    return UiError(
        header = "Technical Issue",
        message = "Something went wrong, try again",
        isActionRequired = true
    )
}