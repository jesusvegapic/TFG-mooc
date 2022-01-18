package jesusvegapic.TFG.mooc.students.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private StudentId studentId;

    @NonNull
    private String email;

    @NonNull
    private String name;

    @NonNull
    private String familyName;

    @NonNull
    private String address;

    @NonNull
    private String city;

    @NonNull
    private String province;

    @NonNull
    private String postalCode;

    @NonNull
    private String passwd;

    @NonNull
    private String bankAccount;

}
