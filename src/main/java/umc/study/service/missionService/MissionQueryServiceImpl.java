package umc.study.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MissionRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements  MissionQueryService {

    private final MemberMissionRepository memberMissionRepository;
    @Override
    public boolean isMemberMissionNotChallenging (Long missionId) {
        Long memberId = 1L;
        MemberMission memberMission = memberMissionRepository.findMemberMissionByMemberIdAndMissionId(memberId, missionId )
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        return memberMission.getStatus() == null;
    }
}
