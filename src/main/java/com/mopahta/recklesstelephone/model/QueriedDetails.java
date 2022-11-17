package com.mopahta.recklesstelephone.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class QueriedDetails {
    private String depName;
    private String workerName;
    private String workingMail;
    private String jobTitle;
    private String number;
    private boolean isPublic;

}
