package com.api.movies.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;

import com.api.movies.Exceptions.BaseException;
import com.api.movies.models.AbstractEntity;
import com.api.movies.utils.ErrorsConstants;

public abstract class AbstractService<Entity extends AbstractEntity<ID>, Model, ID> {

    @Autowired
    public JpaRepository<Entity, ID> repository;

    @Autowired
    public ModelMapper modelMapper;

    private final Class<Model> modelClass;
    private final Class<Entity> entityClass;

    @SuppressWarnings("unchecked")
    public AbstractService() {
        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.modelClass = (Class<Model>) superClass.getActualTypeArguments()[1];
        this.entityClass = (Class<Entity>) superClass.getActualTypeArguments()[0];
    }

    public Model insert(Model model){
        Entity entity = convertToEntity(model);
        rulesBeforeInsert(entity);

        entity = repository.save(entity);

        return convertToModel(entity);
    }

    public List<Model> listAll(){
        List<Entity> entities = repository.findAll();

        return entities.stream().map(this::convertToModel).collect(Collectors.toList());
    }

    public Model update(Model model){
        Entity entity = convertToEntity(model);
        checkEntityBeforeUpdate(entity);
        rulesBeforeUpdate(entity);

        entity = repository.save(entity);

        return convertToModel(entity);
    }

    public void deleteById(ID id){
        checkBeforeDelete(id);
        repository.deleteById(id);
    }

    protected void rulesBeforeInsert(Entity entity) {
        // if(entity instanceof AbstractAuditableEntity<?>){
        //     ((AbstractAuditableEntity<?>) entity).setCreatedAt(LocalDateTime.now());
        // }
    }

    protected void rulesBeforeUpdate(Entity entity) {
        // if(entity instanceof AbstractAuditableEntity<?>){
        //     ((AbstractAuditableEntity<?>) entity).setUpdatedAt(new Date());
        // }
    }

    protected void checkEntityBeforeUpdate(Entity entity){
        if(entity == null)
            throw new BaseException(HttpStatus.BAD_REQUEST, ErrorsConstants.ERRO_GENERICO_UPDATE);

        if(entity.getId() == null)
            throw new BaseException(HttpStatus.BAD_REQUEST, ErrorsConstants.ERRO_ID_NULO);

        Optional<Entity> entityDB = repository.findById(entity.getId());

        if(entityDB.isEmpty())
            throw new BaseException(HttpStatus.BAD_REQUEST, ErrorsConstants.ERRO_NAO_ENCONTRADO_UPDATE); 
    }

    protected void checkBeforeDelete(ID id){
        if(id == null)
            throw new BaseException(HttpStatus.BAD_REQUEST, ErrorsConstants.ERRO_ID_NULO);
        
    }

    public Entity convertToEntity(Model model) {
        return modelMapper.map(model, entityClass);
    }

    public Model convertToModel(Entity entity){
        return modelMapper.map(entity, modelClass);
    }
}
