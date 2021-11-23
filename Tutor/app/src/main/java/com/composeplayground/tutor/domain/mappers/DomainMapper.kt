package com.composeplayground.tutor.domain.mappers

interface DomainMapper<SourceModel, DomainModel> {

    fun mapToDomainModel(sourceModel: SourceModel):DomainModel

    fun mapFromDomainModel(domainModel: DomainModel):SourceModel
}