package com.example.movie.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.cglib.proxy.Mixin
import javax.persistence.*


@Entity
data class Director @JvmOverloads constructor(
    @Id
    @Column(name = "director_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val name: String,
    val lastName: String,

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY)
    val movies: Set<Movie>? = HashSet()



)
