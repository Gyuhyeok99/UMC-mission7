package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;

public class StoreRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createDTO {
        @NotBlank
        private String name;
        @NotBlank
        private String address;
        @ExistRegion
        private Long regionId;
    }
}
