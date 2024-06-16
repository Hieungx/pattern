package managedpolicyStrategy.controller;

import managedpolicyStrategy.model.common.DynamicPolicyDraftRequest;
import managedpolicyStrategy.service.IDynamicSaveDraftService;
import managedpolicyStrategy.service.factory.DynamicSaveDraftServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hieungx
 * 15/06/2024
 **/
@RestController
@RequestMapping("/v1/policy")
public class PolicyController {
    private final DynamicSaveDraftServiceFactory dynamicSaveDraftServiceFactory;

    @Autowired
    public PolicyController(DynamicSaveDraftServiceFactory dynamicSaveDraftServiceFactory) {
        this.dynamicSaveDraftServiceFactory = dynamicSaveDraftServiceFactory;
    }

    @PostMapping(value = "/save")
    public Object getDetail(@RequestBody DynamicPolicyDraftRequest request) {
//        IDynamicSaveDraftService<DynamicPolicyDraftRequest> service = dynamicSaveDraftServiceFactory.getService(request.getClass());
//        service.saveDraft(request);
        return null;
    }
}
