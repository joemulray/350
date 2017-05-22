
import java.util.*;
import java.io.Serializable;

/**
 * 
 */
public class Test extends Survey  implements Serializable{

    private static final double serialVersionUID = -1L;
    /**
     * Default constructor
     */
    public Test() {}

    //AnswerSheet variable
    private ArrayList<Answers> AnswerSheet = new ArrayList<Answers>();


    /**
     * 
     */

    /**
     * Function to create a Test Question
     * overrides a survey create
     */
    @Override
    public void addQuestion() {


    Scanner keyboard = new Scanner(System.in);
    String choice;

    System.out.println("\n1) Add a new T/F question");
    System.out.println("2) Add a new multiple choice");
    System.out.println("3) Add a new short answer question");
    System.out.println("4) Add a new essay question");
    System.out.println("5) Add a new ranking question");
    System.out.println("6) Add a new matching question");
    System.out.println("7) Quit");

    choice = keyboard.nextLine();

    switch(choice){
        case "1":
            TF TFQ = new TF(); 
            TFQ.setType(this.type); //create new true false question
            TFQ.create();
            TFQ.createAnswer(); //gets correct answer
            this.Questions.add(TFQ); 
            break;
        case "2":
            MultipleChoice MCQ = new MultipleChoice(); //create new MC question
            MCQ.setType(this.type);
            MCQ.create();
            MCQ.createAnswer();
            this.Questions.add(MCQ);
            break;
        case "3":
            ShortAnswer SAQ = new ShortAnswer();
            SAQ.setType(this.type);//create new SAQ question
            SAQ.create();
            SAQ.createAnswer();
            this.Questions.add(SAQ);
            break;
        case "4":
            Essay EQ = new Essay();
            EQ.setType(this.type); //create new Essay question
            EQ.create();
            EQ.createAnswer();
            this.Questions.add(EQ);
            break;
        case "5":
            Ranking RQ = new Ranking();
            RQ.setType(this.type);//create new Ranking question
            RQ.create();
            RQ.createAnswer();
            this.Questions.add(RQ);
            break;
        case "6":
            Matching MQ = new Matching();
            MQ.setType(this.type);
            MQ.create(); //create new Matching question
            MQ.createAnswer();
            this.Questions.add(MQ);
            break;
        case "7":
            exit();

        default:
            //handle unwanted input
            addQuestion();
            break;
        }

    }


    @Override
    public void display(){

        int count = 1;

        for (Question question: Questions) {

            System.out.println(count + ")");
            question.display();
            
            //if test get correct answer

            System.out.println("\n The correct answer is:"); 
            question.displayAnswer();

            count ++;
            System.out.println("\n");
        }

    }

    public void grade(){

        //for each quesiton compare user answer and answer of answersheet
        createAnwerSheet();

        if(allTaken.size() == 0){
            System.out.println("\nNo responces for this Test.");
            return;
        }

        //count number of correct answers 
        int numCorrect = 0;
        int numWrong = 0;
        int total;
        int count = 1;

        /*get the last responce from user, basically grading last test taken
        after take is called saves responce.*/
        ArrayList<Answers> userAnswer = allTaken.get(allTaken.size() -1);

        displayName();

        //for each correct answer on answersheet
        for(int index = 0; index < AnswerSheet.size(); index++){

            boolean isCorrect = true;
            Answers user = userAnswer.get(index);
            Answers correct = AnswerSheet.get(index);
            Question currentQ = Questions.get(index);

            List<String> correctAnswers = correct.getAnswer();
            List<String> usersA = user.getAnswer();

            System.out.println(count + ")");
            currentQ.display();
            System.out.println("\n The correct answer is:"); 
            currentQ.displayAnswer();
            System.out.println("\n Your Answer: ");
            user.display();

            if(correctAnswers.size() > 0){
            for(int pos = 0; pos < correct.getAnswer().size(); pos++){

                //no partial credit if one of the answers if wrong entire question is wrong
                    if(!correctAnswers.get(pos).equals(usersA.get(pos))){
                        isCorrect = false;
                    }
            
            }

                if(isCorrect)
                    numCorrect++;
                else
                    numWrong++;
                }

                count++;
                System.out.println("\n");

            }

            total = numCorrect + numWrong;
            System.out.println("Grade: " +  ( ((float) numCorrect) /total)*100 + "  " + numCorrect + "/" + total);
            System.out.println("Correct:" + numCorrect);
            System.out.println("Wrong:" + numWrong);

    }


    /**
     * @return
     */

    //For later assingments function.
    public void createAnwerSheet(){

        //might have to change this if edit correct answer dont think it will update

        if(this.AnswerSheet.size() == 0)
        for (Question q : Questions){
            this.AnswerSheet.add(q.getAnswer());
        }
    }



}