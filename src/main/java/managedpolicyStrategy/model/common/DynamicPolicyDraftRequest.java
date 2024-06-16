package managedpolicyStrategy.model.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import managedpolicyStrategy.model.vbi.PolicyDraftVBIRequest;
import managedpolicyStrategy.model.vni.PolicyDraftVNIRequest;

/**
 * @author hieungx
 * 15/06/2024
 **/
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PolicyDraftVBIRequest.class, name = "PolicyVBIRequest"),
        @JsonSubTypes.Type(value = PolicyDraftVNIRequest.class, name = "PolicyVNIRequest")
})
public class DynamicPolicyDraftRequest {
}
