package managedpolicywithoutstrategy.service;

import managedpolicywithoutstrategy.dto.request.VBIInsurer;
import managedpolicywithoutstrategy.dto.request.VNIInsurer;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    public String processVNIInsurer(VNIInsurer vniInsurer) {

        // Logic xử lý cho VNIInsurer
        return "Processed VNIInsurer: " + vniInsurer.getPolicyNumber();
    }

    public String processVBIInsurer(VBIInsurer vbiInsurer) {

        // Logic xử lý cho VBIInsurer
        return "Processed VBIInsurer: " + vbiInsurer.getPolicyNumber();
    }
}
