/** 
 * @author Jake Pickett
 * @author Sonia Narayanan
 * @version October 12, 2016
 */

import java.util.*; 


public class TriathlonTime {
   
   private Time swimTime;
   private Time t1Time;
   private Time bikeTime;
   private Time t2Time;
   private Time runTime;

   public TriathlonTime() {
      this.swimTime = swimTime;
      this.t1Time = t1Time;
      this.bikeTime = bikeTime;
      this.t2Time = t2Time;
      this.runTime = runTime;
   }

   public Time getSwimTime() {
      return swimTime;
   }
   
   public void setSwimTime(Time newSwimTime) {
      swimTime = newSwimTime;
   }

   public Time getT1Time() {
      return t1Time;
   }

   public void setT1Time(Time newT1Time) {
      t1Time = newT1Time;
   }

   public Time getBikeTime() {
      return bikeTime;
   }

   public void setBikeTime(Time newBikeTime) {
      bikeTime = newBikeTime;
   }
   
   public Time getT2Time() {
      return t2Time;
   }

   public void setT2Time(Time newT2Time) {
      t2Time = newT2Time;
   }

   public Time getRunTime() {
      return runTime;
   }

   public void setRunTime(Time newRunTime) {
      runTime = newRunTime;
   }

   public Time getTotalTime(Time swimTime, Time t1Time, Time bikeTime, Time t2Time, Time runTime) {

      int[] swimTemp = swimTime.getTime();
      int[] t1Temp = t1Time.getTime();
      int[] bikeTemp = bikeTime.getTime();
      int[] t2Temp = t2Time.getTime();
      int[] runTemp = runTime.getTime();

      int totalHours = swimTemp[0] + t1Temp[0] + bikeTemp[0] + t2Temp[0] + runTemp[0];
      int totalMinutes = swimTemp[1] + t1Temp[1] + bikeTemp[1] + t2Temp[1] + runTemp[1];
      int totalSeconds = swimTemp[2] + t1Temp[2] + bikeTemp[2] + t2Temp[2] + runTemp[2];
      
      Time totalTime = new Time();
      totalTime.setTime(totalHours, totalMinutes, totalSeconds);

      return totalTime;
   }
}




