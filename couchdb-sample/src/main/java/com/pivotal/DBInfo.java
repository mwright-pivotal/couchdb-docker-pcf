package com.pivotal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by mwright on 3/29/17.
 */
public class DBInfo {
    @JsonProperty("db_name")
    String db_name;
}
