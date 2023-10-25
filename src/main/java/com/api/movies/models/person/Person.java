package com.api.movies.models.person;

import com.api.movies.enums.GenderEnum;
import com.api.movies.models.AbstractAuditableEntity;
import com.api.movies.models.occupation.Occupation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "person")
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person extends AbstractAuditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "biography")
    private String biography;

    private GenderEnum gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Column(name = "nacionality", columnDefinition = "varchar(255)")
    private String nacionality;

    @ManyToMany
    @JoinTable(
            name = "person_occupation",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "occupation_id"))
    private Set<Occupation> occupations;
    
}
