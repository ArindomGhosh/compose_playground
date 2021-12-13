package com.composeplayground.tutor.domain.mappers

interface IDomainMapper<SourceModel, DomainModel> {

    fun mapToDomainModel(sourceModel: SourceModel):DomainModel

    fun mapFromDomainModel(domainModel: DomainModel):SourceModel
}