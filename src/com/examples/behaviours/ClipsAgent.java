package examples.behaviours;

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
      
  }

  public void getRule(String rule) {

  }

  public class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
        
    } 
    
    public int onEnd() {
        myAgent.doDelete();   
        return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
