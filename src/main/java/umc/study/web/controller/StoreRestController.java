package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConvertor;
import umc.study.service.storeService.StoreCommandService;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class  StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping
    public ApiResponse<StoreResponseDTO.createResultDTO> createStore(@RequestBody @Valid StoreRequestDTO.createDTO createDTO) {
        return ApiResponse.onSuccess(StoreConvertor.toAddResultDTO(storeCommandService.createStore(createDTO)));
    }
}
