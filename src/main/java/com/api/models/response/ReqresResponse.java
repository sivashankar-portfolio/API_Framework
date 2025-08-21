package com.api.models.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ReqresResponse (


    int per_page,
    String total,
    String total_pages,
    int page,
    List<Data> data

){}

