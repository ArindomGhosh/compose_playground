package com.composeplayground.tutor.domain

import com.composeplayground.tutor.domain.entities.UiError
import com.composeplayground.tutor.domain.entities.toUiError
import com.composeplayground.tutor.domain.mappers.IDomainMapper
import com.composeplayground.tutor.domain.repos.CourseResponse

sealed class DomainWrapper<DomainModel> {
    data class Success<DomainModel>(val data: DomainModel) : DomainWrapper<DomainModel>()
    data class Error<DomainModel>(val uiError: UiError) : DomainWrapper<DomainModel>()
}

fun <ResponseModel, DomainModel> CourseResponse<ResponseModel>.mapToDomainWrapper(
    domainMapper: IDomainMapper<ResponseModel, DomainModel>
): DomainWrapper<DomainModel> {
    return when (this) {
        is CourseResponse.Error -> DomainWrapper.Error(this.throwable.toUiError())
        is CourseResponse.Success -> DomainWrapper.Success(domainMapper.mapToDomainModel(this.data))
    }
}

fun <R, DomainModel> DomainWrapper<DomainModel>.map(block: (DomainWrapper<DomainModel>) -> R): R {
    return block(this)
}