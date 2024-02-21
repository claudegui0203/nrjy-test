package com.nrjd.intelligence.business.body;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class register {
    private String realName = "";
    private String password = "";
    private String username = "";
    private List<String> roleNames = new ArrayList<>();
    private List<Integer> roleIds = new ArrayList<>();
    private String company = "";
    private String phone = "";
    private String isDisplay = "";
}
