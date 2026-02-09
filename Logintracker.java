public class Logintracker {
    
static int totalLogins = 0;


    public void LoginTracker(int sessionId) {
        totalLogins++;   
    }


    public static void main(String[] args) {

        LoginTracker user1 = new LoginTracker(101);
        user1.displayLoginInfo();

        LoginTracker user2 = new LoginTracker(102);
        user2.displayLoginInfo();

        LoginTracker user3 = new LoginTracker(103);
        user3.displayLoginInfo();
    }

    private static class LoginTracker {

        public LoginTracker(int i) {
        }

        private void displayLoginInfo() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
