package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.validation.annotation.ExistRegion;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class MissionRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createDTO{
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
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
