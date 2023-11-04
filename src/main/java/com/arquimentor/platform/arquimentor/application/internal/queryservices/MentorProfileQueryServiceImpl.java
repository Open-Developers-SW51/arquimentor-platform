package com.arquimentor.platform.arquimentor.application.internal.queryservices;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetMentorProfileByMentorIdQuery;
import com.arquimentor.platform.arquimentor.domain.model.queries.GetStudentProfileByStudentIdQuery;
import com.arquimentor.platform.arquimentor.domain.services.MentorProfileQueryService;
import com.arquimentor.platform.arquimentor.domain.services.StudentProfileQueryService;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.MentorProfileRepository;
import com.arquimentor.platform.arquimentor.infrastructure.persistence.jpa.repositories.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MentorProfileQueryServiceImpl implements MentorProfileQueryService {

    private final MentorProfileRepository mentorProfileRepository;

    public MentorProfileQueryServiceImpl(MentorProfileRepository mentorProfileRepository) {
        this.mentorProfileRepository = mentorProfileRepository;
    }

    @Override
    public Optional<MentorProfile> handle(GetMentorProfileByMentorIdQuery query) {

        List<MentorProfile> profiles = mentorProfileRepository.findByMentorId(query.MentorId());
        return profiles.isEmpty() ? Optional.empty() : Optional.of(profiles.get(0));
    }
    public List<MentorProfile> findAll(){
        return mentorProfileRepository.findAll();
    }


   // @Override
   // public Optional<StudentProfile> handle(GetStudentProfileByPhoneNumberQuery query) {
     //   return studentProfileRepository.findStudentProfilesByPhoneNumber(query.phoneNumber());
  //  }
 }
