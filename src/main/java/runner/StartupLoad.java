package runner;

public class StartupLoad extends Thread {

    @Override
    public void run() {
        levelOneDB lvl1 = new levelOneDB();
        levelTwoBd lvl2 = new levelTwoBd();
        levelThreeBD lvl3 = new levelThreeBD();

        try {
            lvl1.start();
            lvl1.join();

            lvl2.start();
            lvl2.join();

            lvl3.start();
            lvl3.join();
        } catch ( Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
