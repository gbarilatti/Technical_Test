package com.chalenge.moby.utils;

public class Query {
    public static final String FIND_CANDIDATE_BY_DOCUMENT = "SELECT * FROM CANDIDATES C WHERE C.document = ?1";

    public static final String FIND_TECHNOLOGY_BY_NAME_AND_VERSION = "SELECT * FROM TECHNOLOGIES T WHERE T.name = ?1 AND T.version = ?2";
}
