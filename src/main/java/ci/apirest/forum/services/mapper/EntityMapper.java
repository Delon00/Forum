package ci.apirest.forum.services.mapper;

public interface EntityMapper<D , E> {
    D toDto(E entity);
    E toEntity(D dto);

}