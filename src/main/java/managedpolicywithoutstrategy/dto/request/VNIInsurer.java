package managedpolicywithoutstrategy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VNIInsurer {
    @NotEmpty(message = "policyNumber VNI not null")
    @NotNull(message = "policyNumber VNI not null")
    private String policyNumber;
    @NotEmpty(message = "insuredName")
    private String insuredName;
    private String type;
    private int insuredAmount;
    // Getters and Setters
}
