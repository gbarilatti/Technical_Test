package com.chalenge.moby.utils;

public class Query {
    private Query(){}
    public static final String FIND_CANDIDATE_BY_DOCUMENT = "SELECT * FROM CANDIDATES C WHERE C.document = ?1";

    public static final String FIND_TECHNOLOGY_BY_NAME_AND_VERSION = "SELECT * FROM TECHNOLOGIES T WHERE T.technology_name = ?1 AND T.version = ?2";

    public static final String FIND_BY_CANDIDATE_ID_AND_TECHNOLOGY_ID = "SELECT * FROM CANDIDATE_X_TECHNOLOGY CXT WHERE CXT.candidate_id = ?1 AND CXT.technology_id = ?2";

    public static final String FIND_CANDIDATE_BY_TECHNOLOGY_NAME = "SELECT C.candidate_name, C.last_name, C.document_type ,C.document, C.birthday, T.technology_name, T.version, CXT.experience_years " +
                                                                  "FROM CANDIDATES C INNER JOIN CANDIDATE_X_TECHNOLOGY CXT  ON C.candidate_id=CXT.candidate_id " +
                                                                  "INNER JOIN TECHNOLOGIES T ON CXT.technology_id=T.technology_id WHERE T.technology_name LIKE ?1";
}
