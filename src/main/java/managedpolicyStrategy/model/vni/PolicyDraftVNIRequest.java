package managedpolicyStrategy.model.vni;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import managedpolicyStrategy.model.common.DynamicPolicyDraftRequest;

/**
 * @author hieungx
 * 15/06/2024
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDraftVNIRequest extends DynamicPolicyDraftRequest {
    String id;
    String insuranceId;
    String identificationType;
    String identificationCode;
}
