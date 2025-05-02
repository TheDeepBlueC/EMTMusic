import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;
public class MusicDriver{
  // The main method
  public static void main(String[] args) throws IOException, URISyntaxException{
    User u;
    File f;
    Scanner console = new Scanner(System.in);
    introduction();
    String userinfo = userface(console);
    if(userinfo.toLowerCase().equals("new user") || userinfo.toLowerCase().equals("new")){
      System.out.print("Enter your new username: ");
      String username = console.nextLine();
      String filename = username + ".txt";
      f = new File(filename);
      if(f.createNewFile()){
        u = newUser(console,f,username);
      }else{
        System.out.println("Sorry, username already exists \n");
        u = returningUser(console,f,username);
        System.out.println("Retrieving user data... \n");
      }
    }else{
      System.out.print("Enter your username: ");
      String username = console.nextLine();
      String filename = username + ".txt";
      f = new File(filename);
      if(f.exists()){
        u = returningUser(console,f,username);
        System.out.println("Retrieving user data... \n");
      }else{
        System.out.println("Sorry: Username does not exist. \n");
        System.out.println("Creating new user... \n");
        u = newUser(console,f,username);
      }
    }
    menu(console, u, f);
  }
  // Thie is a method for the introduction of the program
  public static void introduction(){
    System.out.println("Welcome to the emotional management through music program. \n");
    System.out.print("For this program, you will begin by providing information on how you currently feel.");
    System.out.print(" Afterwards, the program will ask you if you would like to vent out what you are currently feeling or change how you are feeling altogether.");
    System.out.print("If you chose to vent out what you are feeling, the program will associate what you are feeling with");
    System.out.print(" the genre you currently have set in your data file.");
    System.out.print(" The same process will happen if you chose to change how you are feeling ");
    System.out.print("except this time the program will ask for the emotion you would like to feel instead and then play ");
    System.out.println("the associated genre for that emotion instead. \n"); 
    System.out.println("First things first... \n");
  }
  // This is to determine if they are a new or returning user
  public static String userface(Scanner console) throws IOException{
    String userinfo = " ";
    do{
      System.out.print("Are you a (new user) or a (returning user): ");
      userinfo = console.nextLine();
      if(!userinfo.toLowerCase().equals("new user") && !userinfo.toLowerCase().equals("new")
             && !userinfo.toLowerCase().equals("returning user") && !userinfo.toLowerCase().equals("returning")){
        System.out.println("Invalid entry, please try again");
      }
    }while(!userinfo.toLowerCase().equals("new user") && !userinfo.toLowerCase().equals("new")
             && !userinfo.toLowerCase().equals("returning user") && !userinfo.toLowerCase().equals("returning"));
    return userinfo;
  }
  // A method for new users
  public static User newUser(Scanner console, File f, String username) throws IOException{
    BufferedWriter bw = new BufferedWriter(new FileWriter(f));
    bw.write(username);
    bw.newLine();
    String happy = happyGenre(console);
    bw.write(happy);
    bw.newLine();
    String angry = angryGenre(console);
    bw.write(angry);
    bw.newLine();
    String energetic = energeticGenre(console);
    bw.write(energetic);
    bw.newLine();
    String scary = scaryGenre(console);
    bw.write(scary);
    bw.newLine();
    String sad = sadGenre(console);
    bw.write(sad);
    bw.newLine();
    String calm = calmGenre(console);
    bw.write(calm);
    bw.newLine();
    bw.close();
    User u2 = new User(username, happy, angry, energetic, scary, sad, calm);
    System.out.println("Username Saved");
    return u2;
  }
  // A method for returning users
  public static User returningUser(Scanner console, File f, String username) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader(f));
    br.readLine();
    String happy = br.readLine();
    String angry = br.readLine();
    String energetic = br.readLine();
    String scary = br.readLine();
    String sad = br.readLine();
    String calm = br.readLine();
    br.close();
    User u3 = new User(username, happy, angry, energetic, scary, sad, calm);
    return u3;
  }
  // A menu select screen
  public static void menu(Scanner console, User u, File f) throws IOException, URISyntaxException{
    System.out.println("Welcome to the main menu. \n");
    String choice = "";
    while(!choice.toUpperCase().equals("LISTEN") && !choice.toUpperCase().equals("OPTIONS") && !choice.toUpperCase().equals("QUIT")){
      System.out.print("What would you like to do: (listen), (options), (quit)");
      choice = console.nextLine();
      if(!choice.toUpperCase().equals("LISTEN") && !choice.toUpperCase().equals("OPTIONS") && !choice.toUpperCase().equals("QUIT")){
        System.out.println("Invalid entry");
      }
    }
    if(choice.toUpperCase().equals("LISTEN")){
      program(console,u,f);
    }
    if(choice.toUpperCase().equals("OPTIONS")){
      options(console,u, f);
    }
    if(choice.toUpperCase().equals("QUIT")){
      quit();
    }
  }
  // The actual call to the program itself
  public static void program(Scanner console, User u, File f) throws IOException, URISyntaxException{
    System.out.print("How do you feel right now?: ");
    String emotion = console.nextLine();
    EmotionCheck ec = new EmotionCheck();
    if(!ec.isEmotion(emotion).equals("none")){
      String decision = "";
      while(!decision.equals("vent") && !decision.equals("change")){
        System.out.print("Do you wish to (vent) or (change) your emotions?: ");
        decision = console.nextLine();
        if(!decision.equals("vent") && !decision.equals("change")){
          System.out.println("Invalid entry");
        }
      }
      if(decision.equals("vent")){
        String emo = ec.isEmotion(emotion);
        boolean choice = confirmation(console, emo, u);
        if(choice == true){
          System.out.println("Playing " + emo + " music.");
          playMusic(emo, u, console, f);
        }else{
          System.out.println("Returning to main menu. \n");
          menu(console,u,f);
        }
      }else{
        String emotion2 = "";
        while(ec.isEmotion(emotion2).equals("none")){
          System.out.print("How do you wish to feel?: ");
          emotion2 = console.nextLine();
          if(!ec.isEmotion(emotion2).equals("none")){
            String emo2 = ec.isEmotion(emotion2);
            boolean choice = confirmation(console, emo2, u);
            if(choice == true){
              System.out.println("Playing " + emo2 + " music.");
              playMusic(emo2, u , console, f);
            }else{
              System.out.println("Returning to main menu. \n");
              menu(console,u,f);
            }
          }else{
            System.out.println("Sorry: Emotion not found");
          }
        }
      }
    }else{
      System.out.println("Sorry: Emotion not found.");
      program(console,u,f);
    }
    
  }
  // To confirm if the individual really wants to listen to a certain type of music
  public static boolean confirmation(Scanner console, String emo, User u){
    String confirm = "";
    while(!confirm.toUpperCase().equals("Y") && !confirm.toUpperCase().equals("N") && !confirm.toUpperCase().equals("YES") && !confirm.toUpperCase().equals("NO")){
      if(emo.toLowerCase().equals("happy")){
        System.out.print("Would you like to listen to happy " + u.returnHappy() + " music?(Y/N): ");
        confirm = console.nextLine();
      }else if(emo.toLowerCase().equals("angry")){
        System.out.print("Would you like to listen to angry " + u.returnAngry() + " music?(Y/N): ");
        confirm = console.nextLine();
      }else if(emo.toLowerCase().equals("energetic")){
        System.out.print("Would you like to listen to energetic " + u.returnEnergetic() + " music?(Y/N): ");
        confirm = console.nextLine();
      }else if(emo.toLowerCase().equals("scary")){
        System.out.print("Would you like to listen to scary " + u.returnScary() + " music?(Y/N): ");
        confirm = console.nextLine();
      }else if(emo.toLowerCase().equals("sad")){
        System.out.print("Would you like to listen to sad " + u.returnSad() + " music?(Y/N): ");
        confirm = console.nextLine();
      }else if(emo.toLowerCase().equals("calm")){
        System.out.print("Would you like to listen to calm " + u.returnCalm() + " music?(Y/N): ");
        confirm = console.nextLine();
      }
      if(!confirm.toUpperCase().equals("Y") && !confirm.toUpperCase().equals("N") && !confirm.toUpperCase().equals("YES") && !confirm.toUpperCase().equals("NO")){
        System.out.println("Invalid entry");
      }
    }
    if(confirm.toUpperCase().equals("Y") || confirm.toUpperCase().equals("YES")){
      return true;
    }else{
      return false;
    }
  }
  // The options select screen
  public static void options(Scanner console, User u, File f) throws IOException, URISyntaxException{
    String selection = "";
    while(!selection.toLowerCase().equals("change") && !selection.toLowerCase().equals("view")
            && !selection.toLowerCase().equals("return") && !selection.toLowerCase().equals("delete")){
      System.out.print("What would you like to do: (change) one of your preferred genres, (view) your file's contents");
      System.out.print(", (delete) your file, or (return) to the main menu.");
      selection = console.nextLine();
      if(!selection.toLowerCase().equals("change") && !selection.toLowerCase().equals("view")
           && !selection.toLowerCase().equals("return") && !selection.toLowerCase().equals("delete")){
        System.out.println("Invalid entry");
      }
    }
    if(selection.toLowerCase().equals("change")){
      u = changePreference(console,u,f);
      System.out.println();
      options(console,u,f);
    }if(selection.toLowerCase().equals("view")){
      printInfo(console,u,f);
      System.out.println();
      options(console,u,f);
    }if(selection.toLowerCase().equals("return")){
      System.out.println("Returning to main menu... \n");
      System.out.println();
      menu(console,u,f);
    }
    if(selection.toLowerCase().equals("delete")){
      System.out.println();
      deleteFile(f,console,u);
    }
  }
  // A method that changes a user's prefered genre
  public static User changePreference(Scanner console, User u, File f) throws IOException{
    String selection = "";
    while(!selection.toLowerCase().equals("happy") && !selection.toLowerCase().equals("angry") 
            && !selection.toLowerCase().equals("sad") && !selection.toLowerCase().equals("scary") && 
          !selection.toLowerCase().equals("calm") && !selection.toLowerCase().equals("energetic")){
      System.out.print("Select the emotion associated with the genre you wish to change: (happy), (angry), ");
      System.out.print("(sad), (scary), (energetic), (calm)");
      selection = console.nextLine();
      if(!selection.toLowerCase().equals("happy") && !selection.toLowerCase().equals("angry") && 
         !selection.toLowerCase().equals("sad") && !selection.toLowerCase().equals("scary") &&
         !selection.toLowerCase().equals("calm") && !selection.toLowerCase().equals("energetic")){
        System.out.println("Invalid entry");
      }
    }
    String username = u.returnUsername();
    String happy = u.returnHappy();
    String angry = u.returnAngry();
    String energetic = u.returnEnergetic();
    String scary = u.returnScary();
    String sad = u.returnSad();
    String calm = u.returnCalm();
    if(selection.toLowerCase().equals("happy")){
      happy = happyGenre(console);
      System.out.println("You will now listen to happy " + happy + " music whenever you like.");
    }
    if(selection.toLowerCase().equals("angry")){
      angry = angryGenre(console);
      System.out.println("You will now listen to angry " + angry + " music whenever you like.");
    }
    if(selection.toLowerCase().equals("energetic")){
      energetic = energeticGenre(console);
      System.out.println("You will now listen to energetic " + energetic + " music whenever you like.");
    }
    if(selection.toLowerCase().equals("scary")){
      scary = scaryGenre(console);
      System.out.println("You will now listen to scary " + scary + " music whenever you like.");
    }
    if(selection.toLowerCase().equals("sad")){
      sad = sadGenre(console);
      System.out.println("You will now listen to sad " + sad + " music whenever you like.");
    }
    if(selection.toLowerCase().equals("calm")){
      calm = calmGenre(console);
      System.out.println("You will now listen to calm " + calm + " music whenever you like.");
    }
    f.delete();
    try{
      f.createNewFile();
    }catch (IOException e){
      e.printStackTrace();
    }
    try{
      BufferedWriter bw = new BufferedWriter(new FileWriter(f));
      bw.write(username);
      bw.newLine();
      bw.write(happy);
      bw.newLine();
      bw.write(angry);
      bw.newLine();
      bw.write(energetic);
      bw.newLine();
      bw.write(scary);
      bw.newLine();
      bw.write(sad);
      bw.newLine();
      bw.write(calm);
      bw.close();
    }catch(IOException e){
      throw new IOException("Invalid file");
    }
    User u4 = new User(username,happy,angry,energetic,scary,sad,calm);
    return u4;
  }
  
  // For declaring genres preference
  // Happy Genre Method
  public static String happyGenre(Scanner console){
    String happy = "";
    while(!happy.toLowerCase().equals("pop") && !happy.toLowerCase().equals("rock") && !happy.toLowerCase().equals("classical")
            && !happy.toLowerCase().equals("country") && !happy.toLowerCase().equals("rap")){
      System.out.print("Which genre would you like to listen to when listening to happy music?: (pop), (rock), (classical), (country)");
      happy = console.nextLine();
      if(!happy.toLowerCase().equals("pop") && !happy.toLowerCase().equals("rock") && !happy.toLowerCase().equals("classical")
           && !happy.toLowerCase().equals("country") && !happy.toLowerCase().equals("rap")){
        System.out.println("Invalid Entry");
      }
    }
    return happy.toLowerCase();
  }
  // Angry Genre Method
  public static String angryGenre(Scanner console){
    String angry = "";
    while(!angry.toLowerCase().equals("pop") && !angry.toLowerCase().equals("rock") && !angry.toLowerCase().equals("classical")
            && !angry.toLowerCase().equals("country") && !angry.toLowerCase().equals("rap")){
      System.out.print("Which genre would you like to listen to when listening to angry music?: (pop), (rock), (classical), (country)");
      angry = console.nextLine();
      if(!angry.toLowerCase().equals("pop") && !angry.toLowerCase().equals("rock") && !angry.toLowerCase().equals("classical")
           && !angry.toLowerCase().equals("country") && !angry.toLowerCase().equals("rap")){
        System.out.println("Invalid Entry");
      }
    }
    return angry.toLowerCase();
  }
  // Energetic Genre Method
  public static String energeticGenre(Scanner console){
    String energetic = "";
    while(!energetic.toLowerCase().equals("pop") && !energetic.toLowerCase().equals("rock") && !energetic.toLowerCase().equals("classical")
            && !energetic.toLowerCase().equals("country") && !energetic.toLowerCase().equals("rap")){
      System.out.print("Which genre would you like to listen to when listening to energetic music?: (pop), (rock), (classical), (country)");
      energetic = console.nextLine();
      if(!energetic.toLowerCase().equals("pop") && !energetic.toLowerCase().equals("rock") && !energetic.toLowerCase().equals("classical")
           && !energetic.toLowerCase().equals("country") && !energetic.toLowerCase().equals("rap")){
        System.out.println("Invalid Entry");
      }
    }
    return energetic.toLowerCase();
  }
  // Scary Genre Method
  public static String scaryGenre(Scanner console){
    String scary = "";
    while(!scary.toLowerCase().equals("pop") && !scary.toLowerCase().equals("rock") && !scary.toLowerCase().equals("classical")
            && !scary.toLowerCase().equals("country") && !scary.toLowerCase().equals("rap")){
      System.out.print("Which genre would you like to listen to when listening to scary music?: (pop), (rock), (classical), (country)");
      scary = console.nextLine();
      if(!scary.toLowerCase().equals("pop") && !scary.toLowerCase().equals("rock") && !scary.toLowerCase().equals("classical")
           && !scary.toLowerCase().equals("country") && !scary.toLowerCase().equals("rap")){
        System.out.println("Invalid Entry");
      }
    }
    return scary.toLowerCase();
  }
  // Sad Genre Method
  public static String sadGenre(Scanner console){
    String sad = "";
    while(!sad.toLowerCase().equals("pop") && !sad.toLowerCase().equals("rock") && !sad.toLowerCase().equals("classical")
            && !sad.toLowerCase().equals("country") && !sad.toLowerCase().equals("rap")){
      System.out.print("Which genre would you like to listen to when listening to sad music?: (pop), (rock), (classical), (country)");
      sad = console.nextLine();
      if(!sad.toLowerCase().equals("pop") && !sad.toLowerCase().equals("rock") && !sad.toLowerCase().equals("classical")
           && !sad.toLowerCase().equals("country") && !sad.toLowerCase().equals("rap")){
        System.out.println("Invalid Entry");
      }
    }
    return sad.toLowerCase();
  }
  // Calm Genre Method
  public static String calmGenre(Scanner console){
    String calm = "";
    while(!calm.toLowerCase().equals("pop") && !calm.toLowerCase().equals("rock") && !calm.toLowerCase().equals("classical")
            && !calm.toLowerCase().equals("country") && !calm.toLowerCase().equals("rap")){
      System.out.print("Which genre would you like to listen to when listening to calm music?: (pop), (rock), (classical), (country)");
      calm = console.nextLine();
      if(!calm.toLowerCase().equals("pop") && !calm.toLowerCase().equals("rock") && !calm.toLowerCase().equals("classical")
           && !calm.toLowerCase().equals("country") && !calm.toLowerCase().equals("rap")){
        System.out.println("Invalid Entry");
      }
    }
    return calm.toLowerCase();
  }
  //The method purely designed to view the data located in the user's file
  public static void printInfo(Scanner console, User u, File f) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader(f));
    String username = br.readLine();
    System.out.println("Username: " + username);
    String happy = br.readLine();
    System.out.println("Happy Genre: " + happy);
    String angry = br.readLine();
    System.out.println("Angry Genre: " + angry);
    String energetic = br.readLine();
    System.out.println("Energetic Genre: " + energetic);
    String scary = br.readLine();
    System.out.println("Scary Genre: " + scary);
    String sad = br.readLine();
    System.out.println("Sad Genre: " + sad);
    String calm = br.readLine();
    System.out.println("Calm Genre: " + calm);
    br.close();
  }
  //The method that helps with playing the actual music
  public static void playMusic(String emotion, User u, Scanner console, File f) throws IOException, URISyntaxException{
    MusicPlayer mp = new MusicPlayer();
    BufferedReader br = new BufferedReader(new FileReader(f));
    mp.musicSearch(u,f,console,emotion,br);
    System.out.println("Returning to main menu...");
    menu(console,u,f);
  }
  
  //The method for deleting a file from the database
  public static void deleteFile(File f, Scanner console, User u) throws IOException, URISyntaxException{
    String confirm1 = "";
    String confirm2 = "";
    String confirm3 = "";
    String username = u.returnUsername();
    System.out.print("If you wish do delete your file, the program will quit. Are you sure you wish to delete your file " + username + ".txt?"); 
    System.out.print(" This will also delete your user (Y/N): ");
    confirm1 = console.nextLine();
    if(confirm1.toUpperCase().equals("Y") || confirm1.toUpperCase().equals("YES")){
      System.out.print("Are you sure you would like to delete the file " + username + ".txt? This action cannot be reversed (Y/N): ");
      confirm2 = console.nextLine();
      if(confirm2.toUpperCase().equals("Y") || confirm2.toUpperCase().equals("YES")){
        System.out.print("Are you 100% sure you would like to delete " + username + ".txt from the database once and for all? ");
        System.out.print("THIS IS YOUR LAST WARNING!!! (Y/N): ");
        confirm3 = console.nextLine();
        if(confirm3.toUpperCase().equals("Y") || confirm3.toUpperCase().equals("YES")){
          f.delete();
          System.out.println("The file " + username + ".txt has been deleted.");
          quit();
        }else{
          options(console,u,f);
        }
      }else{
        options(console,u,f);
      }
    }else{
      options(console,u,f);
    }
  }
  //A method that closes the program and saves the user
  public static void quit(){
    System.out.println("Quitting...");
  }
}