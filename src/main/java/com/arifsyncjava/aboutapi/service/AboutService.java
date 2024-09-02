package com.arifsyncjava.aboutapi.service;

import com.arifsyncjava.aboutapi.constant.AboutConstant;
import com.arifsyncjava.aboutapi.model.DataModel;
import jakarta.servlet.http.HttpServletRequest;
import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.arifsyncjava.aboutapi.constant.AboutConstant.DEVELOPER_EMAIL;
import static com.arifsyncjava.aboutapi.constant.AboutConstant.DEVELOPER_NAME;

@Service
public class AboutService {

    private final UserAgentAnalyzer agentAnalyzer;

    public AboutService() {
        this.agentAnalyzer = UserAgentAnalyzer.newBuilder()
            .hideMatcherLoadStats().
            withCache(1000)
            .build();
    }


    public ResponseEntity<DataModel.AboutResponse> execute (HttpServletRequest request) {
        UserAgent userAgent = agentAnalyzer.parse(
                request.getHeader(AboutConstant.USER_AGENT_HEADER));


        String browser = userAgent.getValue(UserAgent.AGENT_NAME);
        String os = userAgent.getValue(UserAgent.OPERATING_SYSTEM_NAME);
        String device = userAgent.getValue(UserAgent.DEVICE_NAME);


        var developer = new DataModel.Developer(DEVELOPER_NAME,DEVELOPER_EMAIL);
        var client = new DataModel.Client(browser,os,device);

        var response = new DataModel.AboutResponse(developer,client);

        return ResponseEntity.ok(response);




    }









}
