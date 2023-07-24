package com.api.movies.models.movie;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.api.movies.models.AbstractEntity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends AbstractEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "title", columnDefinition = "varchar(255)")
    private String title;

    @NotNull
    @Column(name = "releaseDate", columnDefinition = "date")
    private LocalDate releaseDate;

    @Column(name = "rating", columnDefinition = "int")
    private double rating;

    @Column(name = "teste")
    private List<String> teste;
    
    public MovieDTO pojoToDto(ModelMapper modelMapper){
        return modelMapper.map(this, MovieDTO.class);
    }
}
