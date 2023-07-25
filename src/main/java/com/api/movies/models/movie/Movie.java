package com.api.movies.models.movie;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.api.movies.models.AbstractAuditableEntity;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends AbstractAuditableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "title", columnDefinition = "varchar(255)")
    private String title;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "rating", columnDefinition = "decimal")
    private double rating;
    
    public MovieDTO toDTO(ModelMapper modelMapper){
        return modelMapper.map(this, MovieDTO.class);
    }
}
