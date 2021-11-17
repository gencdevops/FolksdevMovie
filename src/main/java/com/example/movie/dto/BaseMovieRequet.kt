package com.example.movie.dto

open class BaseMovieRequest @JvmOverloads constructor(
    @field:NotBlank
    val description: String? = "",
    val imdbUrl: String? = "",
    @field:Positive
    val duration: Int? = 0,
    @field:Min(1900)
    val featuredYear: Int? = 0,
    @field:NotEmpty
    val genresType: List<GenresType>? = ArrayList(),
    @field:NotEmpty
    val actorIds: List<String>? = ArrayList(),
    @field:NotBlank(message = "publisher id bos olamaz")
    val publisherId: String? = "",
    @field:NotBlank
    val directorId: String? = ""
)