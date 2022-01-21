package Lab4.Controller;

import Lab4.Controller.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class My_Logger {

    private final ArrayList<Exception> ErrList = new ArrayList<>();
    Logger MyLOGGER;

    public My_Logger(String path) throws IOException {
        FileInputStream ins = new FileInputStream(path);
        LogManager.getLogManager().readConfiguration(ins);
        MyLOGGER = Logger.getLogger(Controller.class.getName());
    }

    public void add_Err(Exception e){
        ErrList.add(e);
        MyLOGGER.log(Level.WARNING, e.getMessage());
    }
    public void add_Log(Level level, String str){
        MyLOGGER.log(level, str);
    }

    public int get_Err_Count(){
        return ErrList.size();
    }
}