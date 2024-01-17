package helper;

public class Endpoint {

    private static String userId = "60d0fe4f5311236168a109ca";
    private static String wrongId = "60d0fe4f5311236168a109xx";
    private static String symbolId = "@60d0fe4f5311236168a109ca";

    public static final String host_dummyapi = "https://dummyapi.io/data/v1/";
    public static final String GET_LIST_USERS = host_dummyapi + "user";
    public static final String CREATE_NEW_USERS = host_dummyapi + "user/create";
    public static final String GET_LIST_TAGS = host_dummyapi + "tag";
    public static final String GET_LIST_USERS_ID = host_dummyapi + "user/" + userId;
    public static final String GET_WRONG_USERS_ID = host_dummyapi + "user/" + wrongId;
    public static final String GET_WRONG_SYMBOL_USERS_ID = host_dummyapi + "user/" + symbolId;
}

