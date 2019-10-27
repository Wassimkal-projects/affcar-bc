package com.wkprojects.affcar.mapper.users;

import com.wkprojects.affcar.domain.users.Interest;
import com.wkprojects.affcar.service.dto.users.InterestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface InterestMapper {

    InterestDto interestToInterestDto(Interest interest);

    Interest interestDtoToInterest(InterestDto interestDto);

    List<InterestDto> interestToInterestDtoList(List<Interest> interests);
}
