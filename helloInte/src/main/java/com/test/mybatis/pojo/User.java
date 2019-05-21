package com.test.mybatis.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5410503338079388540L;
    private int region_id;

    private int country_id;
    private int province_id;
    private String name;

}
