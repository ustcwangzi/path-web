package com.path.web.controller;

import com.path.web.auth.Auth;
import com.path.web.request.AddPathRequest;
import com.path.web.response.BaseResponse;
import com.path.web.utils.ValidationUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Auth
@Controller
@RequestMapping(value = "/path")
public class PathController {
    private static final String HOST = "http://127.0.0.1:8888/server/path";

    @Resource
    private RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping(value = "/add")
    public BaseResponse<Boolean> add(AddPathRequest request) {
        try {
            ValidationUtils.valid(request);
        } catch (Exception e) {
            return BaseResponse.buildInvalid(e.getMessage());
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AddPathRequest> httpEntity = new HttpEntity<>(request, httpHeaders);
        ResponseEntity<Boolean> response = restTemplate.postForEntity(HOST + "/add", httpEntity, Boolean.class);
        return response.getBody() != null && response.getBody() ? BaseResponse.buildSuccess(true) : BaseResponse.buildFail("add fail");
    }

    @ResponseBody
    @RequestMapping(value = "/query")
    public BaseResponse<Map<String, List<String>>> query(Integer sourceCity) {
        if (sourceCity == null || sourceCity <= 0) {
            return BaseResponse.buildInvalid("invalid sourceCity");
        }

        Map<String, List<String>> result = restTemplate.getForObject(HOST + "/query?sourceCity=" + sourceCity, Map.class);
        return BaseResponse.buildSuccess(result);
    }
}
