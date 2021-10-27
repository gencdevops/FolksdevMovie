package com.example.movie

import com.example.movie.model.Movie
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
//@Table(name = "actor") tablo adi entity adi ile ayniysa ayrica tablename vermemize gerek yok
data class Actor @JvmOverloads constructor(
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") //Time stamp ile hashleyip uniq id uretir
    val id: String? = "",
    val name: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    val movies: Set<Movie>

) {

}
enum class Gender {
    MALE, FEMALE, UNKNOWN
}