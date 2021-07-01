package com.demo;

import net.sf.clipsrules.jni.*;

public class Demo
{
    public static void main(String[] args) {
        Environment clisp_env = new Environment();

        clisp_env.eval("(clear)");

        // Well, runing from the current working directory works fine
        clisp_env.load("src/com/four/persons/load-persons.clp");
        clisp_env.eval("(reset)");
        clisp_env.run();
        //clisp_env.eval("(facts)");
        clisp_env.load("src/com/four/persons/load-persons-rules.clp");
        clisp_env.eval("(reset)");
        clisp_env.run();
    }
}
