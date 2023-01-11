package constants;

import utils.PropertiesUtils;

public class Constants {
    //Files
    public static final String TEST_PROPERTIES = "src/test/resources/test.properties";

    //Timeouts
    public static final int TIMEOUT= 20;

    //URLs
    public static final String LOAN_MANAGER_URL = PropertiesUtils.readProperty("loan.manager.url", Constants.TEST_PROPERTIES);
    public static final String LOGIN_URL = PropertiesUtils.readProperty("login.url", Constants.TEST_PROPERTIES);

    //Loan status
    public static final String APPROVED = "Approved";

}
