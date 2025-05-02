import java.util.*;
import java.io.*;
import java.net.*;
import java.awt.*;

public class MusicPlayer{
  //Declares variables from within the program then opens up the appropriate playlist
  public void musicSearch(User u, File f, Scanner console, String emotion, BufferedReader br) throws IOException, URISyntaxException{
    br.readLine();
    String genre = "";
    if(emotion.toLowerCase().equals("happy")){
      genre = br.readLine();
      br.close();
      if(genre.toLowerCase().equals("pop")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=rc5AMHoztqU&list=PLhfSd7iGYLuyikACE9BcUSAtyxxPj7meP&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rock")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=aJ9usrpAPao&list=PLhfSd7iGYLuxnDW7xblwEqd4ITYbMPRBV&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("classical")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=h7IGagejBmo&list=PLhfSd7iGYLuyYdJVVFNMrxYGlVDvxCOuu&index=2&t=71s"));
      }
      if(genre.toLowerCase().equals("country")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=Yt7MsUol0sk&list=PLhfSd7iGYLuxqBdtsNuYlL2cqkt86iIVq&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rap")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
      }
    }
    else if(emotion.toLowerCase().equals("angry")){
      br.readLine();
      genre = br.readLine();
      br.close();
      if(genre.toLowerCase().equals("pop")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=cfmRtPQu8Qk&list=PLhfSd7iGYLuzKVAfrKBO-m8KGI7fMGEi4&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rock")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=pHgpt2rdcxU&list=PLhfSd7iGYLuyI6l5UNWCMy4QzhZPKtEmT&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("classical")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=pExZ6b3rN0M&list=PLhfSd7iGYLuzPK81sc5QMpauPuD9dZfgA&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("country")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=bM9M8f26s3Q&list=PLhfSd7iGYLuziM83Ri-KeGX-aREoU8dzv&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rap")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
      }
    }else if(emotion.toLowerCase().equals("energetic")){
      br.readLine();
      br.readLine();
      genre = br.readLine();
      br.close();
      if(genre.toLowerCase().equals("pop")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=KbyPok-3dio&list=PLhfSd7iGYLuwv5Yey73KDovbNFhxiSCyP&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rock")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=ctG-n-Sj2TY&list=PLhfSd7iGYLuzq76aZClVsAa71NS75xV27&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("classical")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=h1PAQA1qQ8Q&list=PLhfSd7iGYLuwfe_gFXYbMnvhaEDn3ksNn&index=1"));
      }
      if(genre.toLowerCase().equals("country")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=nbtPiJSu2SU&list=PLhfSd7iGYLuwnBuDqx_C9kaP0srsTApHC&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rap")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
      }
    }else if(emotion.toLowerCase().equals("scary")){
      br.readLine();
      br.readLine();
      br.readLine();
      genre = br.readLine();
      br.close();
      if(genre.toLowerCase().equals("pop")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=StgAsIxCP6A&list=PLhfSd7iGYLuxp8bxdhsLry_csYZ98MdHb&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rock")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=DjcCQsRCHUs&list=PLhfSd7iGYLuwB7o7R8WbangTS_WRKN0jt&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("classical")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=1u2fCJwW8Ys&list=PLhfSd7iGYLuxX1OME722frbe9ZtROkfrJ&index=2&t=1s"));
      }
      if(genre.toLowerCase().equals("country")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=rthp7Nm03tw&list=PLhfSd7iGYLuw0-sjOdqL0JuJeM0onYwQp&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rap")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
      }
    }else if(emotion.toLowerCase().equals("sad")){
      br.readLine();
      br.readLine();
      br.readLine();
      br.readLine();
      genre = br.readLine();
      br.close();
      if(genre.toLowerCase().equals("pop")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=bIB8EWqCPrQ&list=PLhfSd7iGYLuzSYf4E1Qh6I3XOKFfA6ZkW&index=1"));
      }
      if(genre.toLowerCase().equals("rock")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=lXcX5llJeko&list=PLhfSd7iGYLuwSOmrQo7tFIwmLwrJitOky&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("classical")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=xVBNVR1wQT8&list=PLhfSd7iGYLuzh021ZdImSuxDy76EaNMui&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("country")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=YBGKwMAtdHI&list=PLhfSd7iGYLuwI0_nULkyJU8V9z7asdpxZ&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rap")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
      }
    }else if(emotion.toLowerCase().equals("calm")){
      br.readLine();
      br.readLine();
      br.readLine();
      br.readLine();
      br.readLine();
      genre = br.readLine();
      br.close();
      if(genre.toLowerCase().equals("pop")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=Hm3RCcIlAzw&list=PLhfSd7iGYLuxl9uMhDuK9krPKSpYOcidl&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rock")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=nt9uBlRuBPw&list=PLhfSd7iGYLuxy2O0wh5yuao5klvMjWf0w&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("classical")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=k_ZLxAPro3w&list=PLhfSd7iGYLuzY3pnNO0wgXXY1PLisZ5mB&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("country")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=YawVb7r_mds&list=PLhfSd7iGYLuzZRW1QbdB2AUpXkqWMpxcn&index=2&t=0s"));
      }
      if(genre.toLowerCase().equals("rap")){
        java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
      }
    }else{
      br.close();
      System.out.println("Programming Error");
    }
  }
}