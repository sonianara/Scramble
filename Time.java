
public class Time {

   private int hour;
   private int minute;
   private int second;

   public void setTime(int newHour, int newMinute, int newSecond) {
      hour = newHour;
      minute = newMinute;
      second = newSecond;
   }

   public int[] getTime() {
      return new int[] {hour, minute, second};
   }
}
