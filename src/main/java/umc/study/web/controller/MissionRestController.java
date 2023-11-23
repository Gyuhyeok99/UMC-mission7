package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.converter.MissionConverter;
import umc.study.converter.StoreConvertor;
import umc.study.service.missionService.MissionCommandService;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    @PostMapping
    public ApiResponse<MissionResponseDTO.createResultDTO> createMission(@RequestBody @Valid MissionRequestDTO.createDTO createDTO) {
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(missionCommandService.createMission(createDTO)));
    }

    @PostMapping("/challenging")
    public ApiResponse<MissionResponseDTO.challengingResultDTO> challenging(@RequestBody @Valid MissionRequestDTO.challengingDTO challengingDTO) {
        return ApiResponse.onSuccess(MemberMissionConverter.toChallengingResultDTO(missionCommandService.challenging(challengingDTO)));
    }
}
