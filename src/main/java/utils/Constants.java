package utils;

import Browser.Configuration;
import org.json.JSONObject;

import java.util.Properties;

public class Constants {


    public static String LOGFILENAME = null;
    public static String LOGSDIR = "Logs";

    public static String REPORTSDIR = "Reports";
    public static String testoutput = "./Logs/testoutput.txt";
    public static String MainConfig = "config.properties";
    public static String TESTOUTPUT = "Reports";

    public static final String TEST_DATA_PATH = "src/test/resources/TestData/ridp_test_data.xlsx";
    public static final String ENROLL_TEST_DATA_PATH = "src/test/resources/TestData/QAData.json";
    public static final String TEST_DATA_FILE= "src/resources/TestData/QAData.json";

    public static final String QA_TEST_DATA = "src/test/resources/TestData/QAData.json";
    public static String jsonString = null;
    public static String SAML_LINK = null;



    //public static String testData = null;
    public static final String DATASHEET  = "Sheet1";
    public static final String Passwd  = "Test1234!";
    public static String href1 = null;
    public static final String USER_DIR = System.getProperty("user.dir");
    /** The Constant DATAFILE. */
    public static String DATAFILE = null;

    /** The Constant DATASHEET. */
    //public static String DATASHEET = null;
    public static Properties MainConfigpath = null;
    public static  String yopMailPageURL = "http://www.yopmail.com/en";
    public static  String loginPage = "https://uat0.healthcare.gov/login";
    public static  String grpurl="https://qa-group.sidecarhealth.com/";
    public static  String memberurl="https://qa-site.sidecarhealth.com/";
    public static  String adminloginPage = "https://qa-admin.sidecarhealth.com/login";

    public static String TEST_CONFIG_PATH = "config.properties";
    public static String MAIN_CONFIG_PATH = null;
    static final String TEST_OUTPUT = "Reports";
    static final String FOLDER_NAME = "TestSuites";
    static final String LOGS_DIR = "Logs";
    static final String TMP_DIR = "Tmp";
    static String LOG_FILENAME = null;
    static String CURRENT_TESTING = null;
    static String CURRENT_TESTING_TYPE = null;

    public static String TEST_CASE_ID = null;
    public static String PARTNER_ID = null;
    public static String LOCATION_ID = null;
    public static String BROWSER_TYPE = null;
    public static String USERNAME = null;
    public static String BEARER_TOKEN = null;
    public static String dburl="jdbc:mysql://sidecarhealth-mysql-qa-enc-2020-07-16-09-13.chyovhogfasy.us-east-1.rds.amazonaws.com:3306";
    public static String dbuserName="sidecarhealthdb";
    public static String dbpassword="400$1d3car!ax2381Qa";
    public static String qadburl="jdbc:mysql://sidecarhealth-mysql-qa-feb-2021.chyovhogfasy.us-east-1.rds.amazonaws.com:3306";
    public static String qadbuserName="sidecarqa";
    public static String qadbpassword="400$1d3car!ax2381Qa";

    //sidecarhealth_expense_db

   // public static final String ENTOLL_TEST_DATA_PATH = "src/main/resources/TestData/EnrollTestData.json";
    //public static final String TEST_DATA_FIRST_NAME = "src/main/resources/TestData/first_names.txt";
    public static final String ENTOLL_TEST_DATA_PATH = "src/test/resources/TestData/EnrollTestData.json";
    public static final String TEST_DATA_FIRST_NAME = "src/test/resources/TestData/first_names.txt";



}
