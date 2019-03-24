Custom classloader

Your task is to create a custom classloader for TextService. 
To test how it works, create an infinite loop that prints TextService#staticText() method result. 
If TextService#staticText() text updated and class TextService was recompiled an updated text version 
should start printing without restart the app.

while (true) {
   println(TextService#staticText());
}



public class TextService {

   public String staticText() {
       return "Some static text";
   }
}