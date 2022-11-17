package by.mopahta.recklesstelephone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WorkerInfoDTO {

    private String name;
    private String surname;
    private String patronymic;
    private String workingMail;
    private String position;

}
