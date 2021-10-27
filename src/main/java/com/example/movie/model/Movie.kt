package com.example.movie.model

import com.example.movie.Actor
import com.example.movie.Gender
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.*


@Entity
data class Movie @JvmOverloads constructor(
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") //Time stamp ile hashleyip uniq id uretir
    val id: String? = "",
    val name: String,
    val description: String,
    val imdbUrl: String,
    val duration: Int,
    val featuredYear: Int,

    @field:ElementCollection(fetch = FetchType.EAGER) //sabit listelerde eager kullanabilir. ONE TO MANY iliski
    val genresTypes: List<GenresType> ,//MOVIE_GENRES_TYPE

    // ONE to Many OWNER(Froign key : JoinColumn) =  CHILD(mappedBy)


    //Movie ile Actor arasinda Many to many iliskisi var
    //Many to Many iliskisinde idlerin tutuldugu bir tablo ekleniyor actor_id, movie_id diye yeni bir tablo
    @ManyToMany(fetch = FetchType.LAZY) //manytomany iliskisinde lazy yapmazsak lazyinitializion exception aliriz yoksa her iki tarafta birbirini sonsuza kadar cagirir
    @JoinTable(
        name = "actor_movies",
        joinColumns = [JoinColumn(name = "movie_id""movie_id")], //icerisinde bulundugu entityi reference vermek zorunda
        inverseJoinColumns = [JoinColumn(name = "actor_id", referencedColumnName = "actor_id")])
    val actors: Set<Actor>,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    val director: Director,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])//Cascade = hangi islemi yaparken 2sinde birden yap anlaminda
    @JoinColumn(name = "pub_id", referencedColumnName = 'publisher_id')
    val publisher : Publisher



) {

}

enum class GenresType{
    COMEDY, DRAMA, HORROR, ROMANCE, FANTASY, ACTION
}