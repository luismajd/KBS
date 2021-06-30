package com.four;

import net.sf.clipsrules.jni.Environment;

public class KnowledgeBase
{
    Environment clips_env;

    public KnowledgeBase() {
        clips_env = new Environment();

        clips_env.eval("(clear)");
        clips_env.eval("(reset)");

        //clips_env.eval("(facts)");
        //clips_env.eval("(defrule r1 (sintoma ?x) => (printout t ?x crlf))");
        //clips_env.run();
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