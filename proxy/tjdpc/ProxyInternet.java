package tjdpc;

import java.util.ArrayList;
import java.util.List;

class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();

    private static List<String> bannedSites;

    //  https://www.baeldung.com/java-static-instance-initializer-blocks
    //  In Java, a static block executes code before the object initialization...
    static {
        bannedSites = new ArrayList<String>();
        bannedSites.add("whatever.com");
        bannedSites.add("nope.com");
        bannedSites.add("yup.com");
        bannedSites.add("hello.com");
    }

    @Override
    public void connectTo(String serverhost) throws Exception {
        if (bannedSites.contains(serverhost.toLowerCase())) {
            throw new Exception("Access Denied");
        }
        internet.connectTo(serverhost);
    }
}
