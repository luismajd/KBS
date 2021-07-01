package com.four;

import net.sf.clipsrules.jni.Environment;
import java.io.File;

public class KnowledgeBase
{
    Environment clips_env;

    public KnowledgeBase(String folderName) {
        clips_env = new Environment();

        clips_env.eval("(clear)");
        if(folderName != null) {
            //FileManager fm = new FileManager();
            String path = "src/com/four/" + folderName + "/";
            String[] fileNames;
            File f = new File(path);
            fileNames = f.list();
            for(int i=fileNames.length-1; i>=0; i--) {
                System.out.println("Loading " + path + fileNames[i]);
                clips_env.load(path + fileNames[i]);
                clips_env.eval("(reset)");
                //clips_env.run();
            } 
        }
        else {
            clips_env.eval("(reset)");
        }
    }
    
    public void setFact(String fact) {
        clips_env.assertString("(" + fact + ")");
    }

    public void setRule(String rule) {
        clips_env.build("(defrule " + rule + ")");
    }

    public void execute() {
        clips_env.run();
    }
}