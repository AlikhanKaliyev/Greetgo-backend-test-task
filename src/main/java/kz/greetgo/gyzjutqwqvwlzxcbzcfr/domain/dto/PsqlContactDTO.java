package kz.greetgo.gyzjutqwqvwlzxcbzcfr.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PsqlContactDTO {
    private UUID id;
    private String name;
    @JsonProperty("birth_year")
    private Integer birthYear;
    @JsonProperty("first_phone_number")
    private String firstPhoneNumber;
    @JsonProperty("second_phone_number")
    private String secondPhoneNumber;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
