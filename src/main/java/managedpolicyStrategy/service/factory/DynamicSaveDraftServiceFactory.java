package managedpolicyStrategy.service.factory;

import managedpolicyStrategy.model.common.DynamicPolicyDraftRequest;
import managedpolicyStrategy.model.vbi.PolicyDraftVBIRequest;
import managedpolicyStrategy.model.vni.PolicyDraftVNIRequest;
import managedpolicyStrategy.service.IDynamicSaveDraftService;
import managedpolicyStrategy.service.impl.vbi.VBIServiceImpl;
import managedpolicyStrategy.service.impl.vni.VNIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hieungx
 * 15/06/2024
 **/
@Component
public class DynamicSaveDraftServiceFactory {
    private final Map<Class<? extends DynamicPolicyDraftRequest>, IDynamicSaveDraftService<? extends DynamicPolicyDraftRequest>> serviceMap = new HashMap<>();

    @Autowired
    public DynamicSaveDraftServiceFactory(VBIServiceImpl vbiService, VNIServiceImpl vniService) {
        serviceMap.put(PolicyDraftVBIRequest.class, vbiService);
        serviceMap.put(PolicyDraftVNIRequest.class, vniService);
    }

    public <T extends DynamicPolicyDraftRequest> IDynamicSaveDraftService<T> getService(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        IDynamicSaveDraftService<T> service = (IDynamicSaveDraftService<T>) serviceMap.get(clazz);
        if (service == null) {
            throw new IllegalArgumentException("No service found for class: " + clazz.getName());
        }
        return service;
    }
}
