package com.jp.app;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Optional;

public class AssessmentMessage {
    @NotNull
    @Positive(message = "identifier must be positive", groups = {InfoLevel.class})
    private Integer identifier;
    @NotNull
    @Email(message = "Email not valid", groups = {ErrorLevel.class})
    private String email;

    private LocalDate dateOfBirth;

    public AssessmentMessage (Integer identifier, String email){
        this.identifier = identifier;
        this.email = email;
    }

    public Optional<@Past LocalDate> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
