import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Subash Shibu, CSA, Per.3
 * @version 2.0 September 11, 2019
 */
public class SubashShibu extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the SubashShibu class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public SubashShibu(String f, String l, int r, int s) {
        numStudents++;
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public SubashShibu() {
        numStudents++;
        firstName="Subash";
        lastName="Shibu";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the SubashShibu actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * This will make my actor stand up and print my name as well as my hobby.
     * It will also run an animation where I dance and teleport around.
     * Once my actor is clicked again it initiates a conversation with me.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
                myHobby("I like to do Magic!");
                circleClass();  // Subash Shibu's special method
            }
            else {
                answerQuestion();
                sitDown();
            }
                    
        }
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends. 
     * This function utilizes if statements to make a conversation with the user.
     * It is a multi-stage Q&A
     */
    public void answerQuestion(){
        int pos = 4;
        String yes [] = new String [pos];
        // accounts for the various forms of the word yes
        yes[0] = "yea";
        yes[1] = "yes";
        yes[2] = "yeah";
        yes[3] = "yep";
        //initiates the conversation
        String q=Greenfoot.ask("What would you like to know");
        if (q.contains("hard")){
            //tells whats hard for me
            q=Greenfoot.ask("2D arrays, recursion, strings, loops, merge sort... you can ask me questions about these, but otherwise can I sit down?");
        }
        else if(q.contains("many")){
            // tells the number of students in the class
            q = Greenfoot.ask("There are " + numStudents + " students in the class... May I sit down?");
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
        while(true){
            //in the while loop the code runs until I get any of the variations of yes.
            //this is the extra credit portion... includes a multi-level aspect to the Q&A
        if(q.contains("2D") || q.contains("2d")){
            q = Greenfoot.ask("Like a 1D array, a 2D array is a collection of data cells, all of the same type, which can be given a single name. However, a 2D array is organized as a matrix with a number of rows and columns. Can I sit down now?");
        }
          if(q.contains("recursion")){
            q = Greenfoot.ask("Recursion in java is a process in which a method calls itself continuously. A method in java that calls itself is called recursive method. Can I sit down now?");
        }
          if(q.contains("strings")){
            q = Greenfoot.ask(" Strings, which are widely used in Java programming, are a sequence of characters. In the Java programming language, strings are objects. Can I sit down now?");
        }
          if(q.contains("loop") || q.contains("loops")){
            q = Greenfoot.ask("The Java for loop is a control flow statement that iterates a part of the programs multiple times. Can I sit down now?");
        }
          if(q.contains("merge") || q.contains("sort")){
            q = Greenfoot.ask("Merge sort is an efficient, general-purpose, comparison-based sorting algorithm. Can I sit down now?");
        }
        // these are asking variation question as to whether I can sit down
        if (q.equals(yes[0]) || q.equals(yes[1]) || q.equals(yes[2]) || q.equals(yes[3])){
            Greenfoot.delay(10);
            sitDown();
            break;
        }
        else if(q.equals("no")){
            Greenfoot.ask("I don't care I still want to sit down");
             Greenfoot.delay(10);
            sitDown();
            break;
        }
        
        else{
            q = Greenfoot.ask("I won't sit down until you give me an affermative yes");
    }
} 
    }
    /**
     * This is a local method specific to the SubashShibu class used to animate the character once the image is clicked on.
     * This is my animation and I utlizied 2d arrays and several other things to animate my character
     */
    public void circleClass(){
        int nums = 0;
        int [][] loc = new int [3][3];
        //iterates through several frames (images) and makes it look like I am dancing
        while (nums != 4) {
            for (int frame = 1; frame <= 5; frame++) {
                setImage("subash"+frame+".png");
                Greenfoot.delay(6);
            } 
            nums++;
        }
        // I teleport and I utilized a 2d array in order to do so
        for (int i = 0; i < 3; i++) { 
                for (int j = 0; j < 3; j++) {
                    // the two while loops set different values for my x as well as y coordinate
                        loc[i][j] = (int)(Math.random() * 5 +2); // I utilized math.random to make a random x-coordinate
                        int x = loc[i][j];
                        Greenfoot.delay(5);
                        loc[i][j] = (int)(Math.random() * 3 +2); // I utilized math.random to make a random y-coordinate
                        int y = loc[i][j];
                        Greenfoot.delay(5);
                        setLocation(x, y); // puts both the x and y coordinate together and sets my locations making it look like I teleport.
                    
                }
            }
           Greenfoot.delay(20);
           returnToSeat(); // I return to my original position.
    }
     public void myHobby(String s) {
         System.out.println(s); // prints my hobby
}

}
