package managedpolicywithoutstrategy.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import managedpolicywithoutstrategy.dto.request.VBIInsurer;
import managedpolicywithoutstrategy.dto.request.VNIInsurer;
import managedpolicywithoutstrategy.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hieungx
 * 16/06/2024
 **/
@RestController
@RequestMapping("/api/insurance")
public class InsuranceController {
    @Autowired
    private Validator validator;

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping("/process")
    public ResponseEntity<String> processInsurance(@RequestBody JsonNode requestBody) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String type = requestBody.get("type").asText();

            if ("VNI".equalsIgnoreCase(type)) {
                VNIInsurer vniInsurer = objectMapper.treeToValue(requestBody, VNIInsurer.class);
                Errors errors = new BeanPropertyBindingResult(vniInsurer, "vniInsurer");
                validator.validate(vniInsurer, errors);
                if (errors.hasErrors()) {
                    List<String> errorMessages = errors.getAllErrors()
                            .stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.toList());
                    return ResponseEntity.badRequest().body(String.join(", ", errorMessages));
                }
                String result = insuranceService.processVNIInsurer(vniInsurer);
                return ResponseEntity.ok(result);
            } else if ("VBI".equalsIgnoreCase(type)) {
                VBIInsurer vbiInsurer = objectMapper.treeToValue(requestBody, VBIInsurer.class);
                Errors errors = new BeanPropertyBindingResult(vbiInsurer, "vbiInsurer");
                validator.validate(vbiInsurer, errors);
                if (errors.hasErrors()) {
                    List<String> errorMessages = errors.getAllErrors()
                            .stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.toList());
                    return ResponseEntity.badRequest().body(String.join(", ", errorMessages));
                }
                String result = insuranceService.processVBIInsurer(vbiInsurer);
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body("Invalid type specified");
            }
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Invalid request body");
        }
    }
}

