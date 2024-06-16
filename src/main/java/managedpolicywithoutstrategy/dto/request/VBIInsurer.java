package managedpolicywithoutstrategy.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VBIInsurer {
    private String policyNumber;
    private String insuredName;
    private String type;
    private int insuredAmount;
}
