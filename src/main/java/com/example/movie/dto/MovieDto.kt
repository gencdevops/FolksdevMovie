package com.example.movie.dto

data class MovieDto @JvmOverloads constructor(
    val id: String,
    val title: String,
    val description: String,
    val imdbUrl: String? = "",
    val duration: String,
    val featuredYear: Int,
    val genresTypes: List<GenresType>,
    @JsonInclude(JsonInclude.Include.NON_EMPTY) // Json ekle ama liste boşsa ekleme
    val actors: List<ActorDto>? = ArrayList(),
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val director: DirectorDto? = null,
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val publisherName: String? = ""
)
