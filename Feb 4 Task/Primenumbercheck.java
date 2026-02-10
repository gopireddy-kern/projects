public class Primenumbercheck {
    public static void main(String[] args) {
        int num =29;

        if (num <= 1) {
        } else {
            for (int i = 2; i <= math.sqrt(num); i++)

     {
                  if (num % i == 0)  {
                       break;

                       }

                    }

                }
        boolean isprime = false;
                  if (isprime)
                     System.out.println(num +"is a prime number");
                    
                     else

                        System.out.println(num + "is not a prime number");

    }

    private static class math {

        private static int sqrt(int num) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public math() {
        }
    }
    
}
