package service;

import java.io.FileWriter;
import java.sql.Timestamp;

public class Logger
{

    public static void Log()
    {
        LogN( 0 );
    }

    public static void LogN( final int depth )
    {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        String logName = ste[ 3 + depth].getMethodName();
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

        try
        {
            FileWriter csvWrite = new FileWriter(m_log_path, true);
            csvWrite.write( logName+ "," + timeStamp.toString() +",\n" );
            csvWrite.close();
        }
        catch ( Exception  e )
        {
            System.out.println("I/O error for log");
        }
    }

    static String m_log_path = "./logTRANSPORT.log";

}
