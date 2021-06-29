package com.four;

import net.sf.clipsrules.jni.*;

public class KnowledgeBase
{
    public static void main(String[] args) {
        Environment clisp_env = new Environment();

        clisp_env.eval("(clear)");

        clisp_env.load("src/clisp/test.clp");
        clisp_env.eval("(reset)");
        clisp_env.eval("(facts)");
        clisp_env.run();
    }
}