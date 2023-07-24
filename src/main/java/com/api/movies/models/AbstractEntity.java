package com.api.movies.models;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<ID> {
    public abstract ID getId();
}