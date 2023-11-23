package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(MissionRequestDTO.challengingDTO challengingDTO) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MissionResponseDTO.challengingResultDTO toChallengingResultDTO(MemberMission memberMission) {
        return MissionResponseDTO.challengingResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
}
