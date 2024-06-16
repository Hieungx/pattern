package managedpolicyStrategy.model.vbi;

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
public class PolicyDraftVBIRequest extends DynamicPolicyDraftRequest {
    private String id;
    private String insuranceId;
    private String cccd;
}
