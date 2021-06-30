package com.four;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import net.sf.clipsrules.jni.*;

public class ClipsAgent extends Agent {

    private ClipsAgentGui myGui;

    KnowledgeBase kb;
    
    protected void setup() {

        myGui = new ClipsAgentGui(this);
        myGui.showGui();

        System.out.println("Agent "+getLocalName()+" started.");  

        addBehaviour(new TellBehaviour());

    }

    protected void takeDown() {
        // Printout a dismissal message
        System.out.println("Agent "+getLocalName()+" terminating.");
    }

  public void getFact(String fact) {
        System.out.println("Adding fact: " + fact);
        kb.setFact(fact);
  }

  public void getRule(String rule) {
        System.out.println("Adding rule: " + rule);
        kb.setRule(rule);
  }

  public void execute() {
        //System.out.println("Executing...");
        addBehaviour(new AskBehaviour());
  }

  public void terminate() {
      takeDown();
  }

  private class TellBehaviour extends Behaviour {

    boolean tellDone = false;

    public void action() {

        System.out.println("Tell is executed");

        kb = new KnowledgeBase(null);
        
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