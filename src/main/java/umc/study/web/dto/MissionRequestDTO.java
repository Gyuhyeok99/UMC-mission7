package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistRegion;
import umc.study.validation.annotation.ExistStore;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createDTO{
        @NotBlank
        private Integer reward;
        @NotBlank
        private LocalDate deadline;
        @NotBlank
        private String missionSpec;
        @ExistStore
        private Long storeId;
    }


    public static class addDTO{
        @NotBlank
        private String name;
        @NotBlank
        private String address;
        @ExistRegion
        private Long regionId;
    }
}
