package umc.study.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.service.missionService.MissionCommandService;
import umc.study.service.missionService.MissionQueryService;
import umc.study.validation.annotation.NotChallenging;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotChallengingValidator implements ConstraintValidator<NotChallenging, Long> {

    private final MemberMissionRepository memberMissionRepository;
    @Override
    public void initialize(NotChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(value == null) {
            return false;
        }
        Optional<MemberMission> memberMission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(1L, value);
        //만약 취소기능 있다면 이게 아니라 이넘에 값 하나 추가해야할듯??
        return !memberMission.isPresent();
    }
}
