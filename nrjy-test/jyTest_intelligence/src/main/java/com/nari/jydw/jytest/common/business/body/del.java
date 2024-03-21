package com.nari.jydw.jytest.common.business.body;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class del {
    private List<Long> ids = new ArrayList<>();
}
