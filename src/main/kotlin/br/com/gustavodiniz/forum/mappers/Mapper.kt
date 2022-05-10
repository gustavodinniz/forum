package br.com.gustavodiniz.forum.mappers

interface Mapper<T, U> {

    fun map(t: T): U
}
