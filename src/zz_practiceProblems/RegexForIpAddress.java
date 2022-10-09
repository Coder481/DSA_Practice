package zz_practiceProblems;

public class RegexForIpAddress {

    public static void main(String[] args) {

        String ipt = "123.123.123.123";

        String ipAddressMatcher = "^([0-1]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])[.]" +
                "([0-1]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])[.]" +
                "([0-1]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])[.]" +
                "([0-1]?[0-9]?[0-9]|2[0-4][0-9]|25[0-5])$";

        if (ipt.matches(ipAddressMatcher))
            System.out.println(ipt + " is IP Address");
        else
            System.out.println(ipt + " is not IP Address");
    }

}
