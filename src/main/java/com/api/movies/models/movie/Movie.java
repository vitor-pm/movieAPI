package com.api.movies.models.movie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;

    @NotNull
    @Column(name = "releaseDate", columnDefinition = "date")
    private LocalDate releaseDate;

    @Column(name = "rating", columnDefinition = "int")
    private double rating;
}
