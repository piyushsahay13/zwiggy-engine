package com.zwiggy.zwiggyengine.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class MailRequestBody {
    private String username;
    private String to;
    private String from;
    private String subject;
    private boolean attchmentReq;
    private String attchmentPath;
    private Map<String, String> additionalInfo;
}
