public class main {

  public static void main(String[] args) { 

    int i;

    int seconds; 

    AlarmClock myClock = new AlarmClock(8, 0, 0, "AM", 8, 5, "AM");

    //set alarm clock to 96.5
    myClock.setStation("96.5 WIRED");

    for (i = 0; i < 5; i++)

      {


        for (seconds = 0; seconds < 60; seconds++)

        {

         myClock.tick();
         myClock.checkAlarm();

        }

        System.out.println("Time: " + myClock.showTime());

      }

    myClock.snooze();

    //set station to Q120;
    myClock.setStation("Q102");

    for (i = 0; i < 9; i++)

    {

      for (seconds = 0; seconds < 60; seconds++)

      {

        myClock.tick();
        myClock.checkAlarm();

      }

      System.out.println("Time: " + myClock.showTime());

    }


   myClock.AlarmOff();

  }


}


