package managedpolicyStrategy.service;

import managedpolicyStrategy.model.common.DynamicPolicyDraftRequest;

/**
 * @author hieungx
 * 15/06/2024
 **/
public interface IDynamicSaveDraftService<T extends DynamicPolicyDraftRequest> {
    Object saveDraft(T draftRequest);
}
