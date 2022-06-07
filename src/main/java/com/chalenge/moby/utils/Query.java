package com.chalenge.moby.utils;

public class Query {
    private Query(){}
    public static final String FIND_CANDIDATE_BY_DOCUMENT = "SELECT * FROM CANDIDATES C WHERE C.document = ?1";

    public static final String FIND_TECHNOLOGY_BY_NAME_AND_VERSION = "SELECT * FROM TECHNOLOGIES T WHERE T.name = ?1 AND T.version = ?2";

    public static final String FIND_BY_CANDIDATEID_AND_TECHNOLOGYID = "SELECT * FROM CANDIDATE_X_TECHNOLOGY CXT WHERE CXT.candidate_id = ?1 AND CXT.technology_id = ?2";

    public static final String FIND_CANDIDATE_BY_TECHNOLOGYNAME = "SELECT * FROM CANDIDATE_X_TECHNOLOGY CXT INNER JOIN TECHNOLOGIES T ON CXT.technology_id = T.technology_id WHERE T.name = ?1";
}
