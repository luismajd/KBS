package com.four;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class ClipsAgent extends Agent {

  private ClipsAgentGui myGui;

  protected void setup() {

    myGui = new ClipsAgentGui(this);
    myGui.showGui();

    System.out.println("Agent "+getLocalName()+" started.");

    addBehaviour(new MyOneShotBehaviour());

  }

  public void getFact(String fact) {
    System.out.println("Adding fact.");
  }

  public void getRule(String rule) {
    System.out.println("Adding rule.");
  }

  public void execute() {
    System.out.println("Executing...");
  }

  public class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      System.out.println("Agent action...");
    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
