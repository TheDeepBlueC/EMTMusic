import java.util.*;
public class User{
  // The G stands for "genre"
  public String username,happyG,angryG,energeticG,scaryG,sadG,calmG;
  public User(String name, String happy, String angry, String energetic, String scary, String sad, String calm){
    this.username = name;
    this.happyG = happy;
    this.angryG = angry;
    this.energeticG = energetic;
    this.scaryG = scary;
    this.sadG = sad;
    this.calmG = calm;
  }
  //For returning the actual variables in the User class
  public String returnUsername(){
    return username;
  }
  public String returnHappy(){
    return happyG;
  }
  public String returnAngry(){
    return angryG;
  }
  public String returnEnergetic(){
    return energeticG;
  }
  public String returnScary(){
    return scaryG;
  }
  public String returnSad(){
    return sadG;
  }
  public String returnCalm(){
    return calmG;
  }
}