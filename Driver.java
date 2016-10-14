public class Driver {

   public static void main(String [] args) {
      System.out.println("Testing ");
      
      RandomLetters rl = new RandomLetters();
      for(Letter l: rl.getFullSet()) System.out.println(l.getLetter());
   }
}