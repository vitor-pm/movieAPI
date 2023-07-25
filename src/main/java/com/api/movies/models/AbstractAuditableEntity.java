package com.api.movies.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractAuditableEntity<ID> extends AbstractEntity<ID> {

    @Column(updatable = false)
    @CreationTimestamp
    public Date createdAt;

    @UpdateTimestamp
    public Date updatedAt;
}
