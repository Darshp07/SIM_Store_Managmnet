package com.example.simmanagementsystem.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimdetailsRequest {


    private String simNo;
    private String accountNumber;
    private String mobileNumber;
    private String staffId;
    private String storeId;


}
