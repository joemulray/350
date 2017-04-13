public class main {

  public static void main(String[] args) { 

    int i;

    int seconds; 

    AlarmClock myClock = new AlarmClock(8, 0, 0, "AM", 8, 5, "AM");


    for (int i = 0; i < 5; i++)

      {

        System.out.println("Time: " + myClock.showTime());

        for (int seconds = 0; seconds < 60; seconds++)

        {

         myClock.checkAlarm();

         myClock.tick();

        }

      }

    myClock.snooze();


    for (i = 0; i < 9; i++)

    {

      System.out.println("Time: " + myClock.showTime());

      for (int seconds = 0; seconds < 60; seconds++)

      {

        myClock.checkAlarm();

        myClock.tick();

      }

    }


   myClock.AlarmOff();

  }


}


