package com.four;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import net.sf.clipsrules.jni.*;

public class ClipsAgent2 extends Agent {

    private ClipsAgentGui myGui;

    KnowledgeBase kb;
    String folderName;
    
    protected void setup() {

        myGui = new ClipsAgentGui(this);
        myGui.showGui();

        System.out.println("Agent "+getLocalName()+" started.");  

    }

    protected void takeDown() {
        // Printout a dismissal message
        System.out.println("Agent "+getLocalName()+" terminating.");
    }

    public void getFolderName(String folderName) {
        System.out.println("Choosing folder: " + folderName);
        addBehaviour(new TellBehaviour());
        this.folderName = folderName;
    }

    public void execute() {
        //System.out.println("Executing...");
        addBehaviour(new AskBehaviour());
    }

    private class TellBehaviour extends Behaviour {

        boolean tellDone = false;

        public void action() {

            System.out.println("Tell is executed");

            kb = new KnowledgeBase(folderName);
            
            tellDone = true;

        } 
            
        public boolean done() {
            if (tellDone)
                return true;
            else
                return false;
        }
   
    }    // END of inner class ...Behaviour

    private class AskBehaviour extends Behaviour {

        boolean askDone = false;

        public void action() {

            System.out.println("Ask is executed");
        
            kb.execute();

            askDone = true;

        } 
        
        public boolean done() {
            if (askDone)
                return true;
            else
                return false;
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        } 
    } 
}