package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.createDTO createDTO) {
        return Mission.builder()
                .reward(createDTO.getReward())
                .deadline(createDTO.getDeadline())
                .missionSpec(createDTO.getMissionSpec())
                .build();
    }
    public static MissionResponseDTO.createResultDTO toCreateResultDTO(Mission mission) {
        return MissionResponseDTO.createResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
