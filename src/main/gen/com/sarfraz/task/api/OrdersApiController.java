package com.sarfraz.task.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-07-03T16:26:22.933846+05:30[Asia/Calcutta]")
@Controller
@RequestMapping("${openapi.eSamudaayAssignment.base-path:/v1}")
public class OrdersApiController implements OrdersApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrdersApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
