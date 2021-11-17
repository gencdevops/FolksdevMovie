package com.example.movie.dto

data class ActorDto @JvmOverloads constructor(
    val id: String,
    val name: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,
    @JsonInclude(JsonInclude.Include.NON_EMPTY) //movie listesi bos ise Json'da gosterme
    val movieList: List<MovieDto>? = ArrayList()
)

/*
{
"id": "ja123123",
"name" : "Furkan"
"dateOfBirthday" : "22/10/1988"
"gender": MALE,
"movieList": [{}]
}
 */
