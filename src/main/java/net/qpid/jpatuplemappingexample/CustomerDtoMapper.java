package net.qpid.jpatuplemappingexample;

import java.util.List;

import javax.persistence.Tuple;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerDtoMapper {

	@Mapping(target = "id", expression = "java(t.get(\"id\",long.class))")
	@Mapping(target = "name", expression = "java(t.get(\"name\",String.class))")
	public CustomerDto fromTuple(Tuple t);

	public List<CustomerDto> fromTuples(List<Tuple> t);
}
