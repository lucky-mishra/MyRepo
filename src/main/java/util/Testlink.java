package util;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class Testlink {
    public static String testProject = "Dummy";
    public static String testPlan = "DevOps";
    public static String build = "Build-1";

    public static String DEVKEY = "0ff397e18d8dfe8f362e60d7f301b9f2";
    //public static String URL = "http://127.0.0.1/Bitnami/testlink-1.9.20-14/apps/testlink/htdocs/lib/api/xmlrpc/v1/xmlrpc.php";
    public static String URL = "http://127.0.0.1/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

    public static void reportResult(String TestProject, String TestPlan, String TestcaseID, String Build, String Notes, String Result) throws TestLinkAPIException, testlink.api.java.client.TestLinkAPIException {
        TestLinkAPIClient api = new TestLinkAPIClient(DEVKEY, URL);
        api.reportTestCaseResult(TestProject, TestPlan, TestcaseID, Build, Notes, Result);
    }

}
