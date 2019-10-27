package com.wkprojects.affcar.mapper.users;

import com.wkprojects.affcar.domain.users.Actor;
import com.wkprojects.affcar.mapper.vehicules.VehiculeMapper;
import com.wkprojects.affcar.service.dto.users.ActorDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {InterestMapper.class, VehiculeMapper.class})
public interface ActorMapper {

    ActorDto actorToActorDto(Actor actor);

    Actor actorDtoToActor(ActorDto actorDto);

    List<ActorDto> actorToActorDtoList(List<Actor> actors);
}
