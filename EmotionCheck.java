public class EmotionCheck{
  //Synonyms for happy
  String[] happy = {"happy", "cheerful", "contented", "delighted", "ecstatic","elated", "glad","joyful","joyous",
    "jubliant", "lively", "merry", "overjoyed", "pleasant","pleased", "thrilled", "upbeat", "jolly", "gay","gleeful"};
  //Synonyms for angry
  String[] angry = {"angry", "mad", "bitter", "enraged", "exasperated", "furious", "heated","impassioned","indigant","irrate",
    "irritable", "irritated","offended","outraged","resentful","sullen","uptight","affronted","antagonized","displeased",
    "ferocious","fierce","fiery","fuming","hateful","hot","inflamed", "infuriated", "maddened", "wrathful"};
  //Synonyms for energetic
  String[] energetic = {"energetic","active","aggressive","enterprising","industrious","lively","powerful","spry",
    "tirless","breezy","brisk","hardy","peppy","potent","snappy","strenuos","tough","zippy"};
  //Synonyms for scared
  String[] scary = {"scared", "afriad","fearful","panicked","panicky","startled","petrified","shaken","terrified",
    "aghast","panic-stricken","terror-stricken", "nervous", "anxious"};
  //Synonyms for sad
  String[] sad = {"sad", "depressed", "bitter","dismal","heartbroken","melancholy","mountful","pessimistic","somber",
    "sorrowful","sorry","wistful","bereaved","blue","cheerless","dejected","desparing","despondent","distressed",
    "down","down in dumps","down in mouth","gloomy","glum","heartsick","heavyhearted","hurt","hurting","in grief",
    "in the dumps","morbid","troubled"};
  //Synonyms for calm
  String[] calm = {"calm","peaceful","cool","harmonious","low-key","mild","placid","serene","slow","smooth","soothing",
    "tranquil","bucolic","halcyon","hushed","pacific","still","breathless","inactive","in order","restful","motionless",
    "quiet","quiescent","reposeful", "relaxed"};
  //Checks to see if an emotion is found in any of the lists
  public String isEmotion(String emo){
    for(String a : happy){
      if(emo.equals(a)){
        return "happy";
      }
    }
    for(String b : angry){
      if(emo.equals(b)){
        return "angry";
      }
    }
    for(String c : energetic){
      if(emo.equals(c)){
        return "energetic";
      }
    }
    for(String d : scary){
      if(emo.equals(d)){
        return "scary";
      }
    }
    for(String e : sad){
      if(emo.equals(e)){
        return "sad";
      }
    }
    for(String f : calm){
      if(emo.equals(f)){
        return "calm";
      }
    }
    return "none";
  }
}