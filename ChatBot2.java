import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;
public class ChatBot2 extends JFrame implements ActionListener {
    //Accepted Keywords
    //geninfo
    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();
    private String input;
    private String[] foundingWords = new String[]{"FOUNDE", "FOUNDER", "FOUNDED", "BUILT"};
    private String[] locationWords = new String[]{"WHERE", "LOCA", "CAMPUS"};
    private String[] missionWords = new String[]{"WHY", "MISSION", "GOAL"};
    private String[] demographicsWords = new String[]{"BLACK", "MINORITY", "POC", "RACE", "DEMO", "GENDER", "MALE"};
    private String[] facultyWords = new String[]{"FACULTY", "DEAN", "PRESIDENT", "CABRERA"};
    private String[] contactWords = new String[]{"CONTACT", "CONTACT", "EMAIL", "#", "PHONE", "CALL"};
    private String[] sizeWords = new String[]{"HOW", "MANY", "STUDENT"};
    private String[] gradWords = new String[]{"GRAD", "RATE", "GRADUATION", "OFFICE"};
    private String[] mascotWords = new String[]{"MASCOT", "BUZZ", "WHO", "JACKET", "YELLOW"};
    private String[] startingSalaryWords = new String[]{"SALARY", "STARTING", "HOW", "MONEY"};
    private String[] housingWords = new String[]{"HOUS", "DORM", "ROOM", "RESIDE", "HALL", "LIV"};
    private String[] parkingWords = new String[]{"PARKING", "PARK", "VISIT", "VISITOR", "CAR"};
    private String[] safetyWords = new String[]{"DANGER", "SHOT", "SAFE", "HOW", "CAMPUS"};
    private String[] internetWords = new String[]{"INTERNET", "NET", "SPEED", "FAST", "SLOW", "WIFI", "DATA"};
    private String[] covidWords = new String[]{"CORONAVIRUS", "CORONA", "COVID", "DEAL", "MASK", "HOW"};
    private String[] diningWords = new String[]{"DINING", "FOOD", "MEAL", "PLAN", "EAT"};
    private String[] visitingWords = new String[]{"VISIT", "VISITING", "TOUR", "CAMPUS", "TECH", "GEORG"};
    private String[] busWords = new String[]{"BUS", "HOW", "AROUND", "CAMPUS", "CAR"};
    private String[] fundsWords = new String[]{"BUZZ", "CARD", "FUND", "DINING", "DOLLAR", "MONEY", "BALANCE"};
    private String[] jobWords = new String[]{"JOB", "ON", "CAMPUS", "WORK", "INTERN", "WORK STUDY", "WORK STUDY"};
    private String[] healthWords = new String[]{"SICK", "DOC", "HEALTH", "NURSE", "HURT", "NEED"};

    //admissions
    private String[] processWords = new String[]{"PROCESS", "OVERVIEW"};
    private String[] ratesWords = new String[]{"RATE", "%", "PERCENT", "CHANCE", "ACCEPT", "WAITL", "REJECT", "YIELD", "ENROLL"};
    private String[] deadlinesWords = new String[]{"DEADLINE", "WHEN", "DECISION", "EARLY", "REGUL", "ACTION", "RELEASE"};
    private String[] statsWords = new String[]{"STAT", "DATA", "SAT", "ACT", "GPA", "NUM", "AVERAGE", "AVG", "TEST", "SCORES"};
    private String[] transferWords = new String[]{"TRANSFER", "APPLICA", "ADMISSION", "DEADLINE"};

    //finAid
    private String[] fafsaWords = new String[]{"FAFS", "DUE", "CSS"};
    private String[] scholarshipWords = new String[]{"MERIT", "SCHOLAR", "MONE", "AID", "POOR", "AFFORD"};
    private String[] costWords = new String[]{"COST", "TUIT", "YEAR", "MUCH", "TUITION", "TUITION", "COST"};
    private String[] loansWords = new String[]{"LOAN", "LOANS", "CANNOT", "AFFORD"};
    //reuse contactWords from geninfo

    //athletics
    private String[] crcWords = new String[]{"CRC", "GYM", "FACILITY"};
    private String[] scheduleWords = new String[]{"SCHEDULE", "NEXT", "UPCOMING", "GAME", "WHEN"};
    private String[] recordWords = new String[]{"RECORD", "WIN", "LOSS", "GAME"};
    private String[] intramuralsWords = new String[]{"INTRAMURAL", "CLUB", "ORG", "REC"};
    private String[] programsWords = new String[]{"PROGRAM", "SPORT", "WHAT", "OFFER"};

    //academics
    private String[] majorWords = new String[]{"MAJOR", "CS", "MINOR", "MAJORS", "LIST"};
    private String[] difficultyWords = new String[]{"HARD", "DIFFICULT", "STRESS"};
    private String[] registrationWords = new String[]{"REGISTRATION", "TIME", "REGISTER", "CLASS"};
    private String[] calendarWords = new String[]{"CALENDAR", "ACADEMIC", "START", "FINAL", "BEGIN"};
    private String[] rankingWords = new String[]{"RANK", "TOP", "NEWS", "US NEWS", "USNEWS"};

    public ChatBot2() {
        Chatarea.append("Buzz : Hello and welcome to Georgia Tech's chat bot!\n");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(600, 800);
        frame.setTitle("Ask Buzz");
        frame.add(Chatarea);
        frame.add(chatbox);
        Chatarea.setSize(600, 700);
        Chatarea.setLocation(2, 2);
        chatbox.setSize(600, 30);
        chatbox.setLocation(0, 700);
        chatbox.addActionListener(this);
        boolean a = true;
        /* try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        } */

        /* while (a){
            try
            {
                Thread.sleep(2000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            if(input != null) {
                a = false;
                questionList();
            }
        } */
        questionList();

    }

    public void actionPerformed(ActionEvent e) {
        String gtext = chatbox.getText();
        Chatarea.append("You : " + gtext + "\n");
        chatbox.setText("");
        if(gtext != null || !gtext.equals("")) {
            this.input = gtext.toUpperCase();
        }

    }


    public void questionList() {
        Chatarea.append("Buzz : Please select the category that your question is contained in!\n");
        Chatarea.append("1. General Information\n"); //university address, phone number, post office
        Chatarea.append("2. Admissions\n"); //ea, rd deadlines, essays, acceptance rate, avg sat score,
        Chatarea.append("3. Financial Aid\n"); //fafsa deadline, financial aid met, etc
        Chatarea.append("4. Athlethics\n"); //asks what sport, record, schedule, etc
        Chatarea.append("5. Academics \n"); //registration times,
        Chatarea.append("6. Other\n"); //should direct student to look at website closer

        boolean loop = true;
        while (loop) {
            input = null;
            while (input == null) {
                try
                {
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
            if (input.contains("1") || input.contains("ONE") || input.contains("GENERAL") || input.contains("INFO")) {
                loop = false;
                generalInfo();
            } else if (input.contains("2") || input.contains("TW") || input.contains("ADMISSIONS") || input.contains("ADMISSION")) {
                loop = false;
                admissions();
            } else if (input.contains("3") || input.contains("THRE") || input.contains("FINANCIAL") || input.contains("AID")) {
                loop = false;
                finAid();
            } else if (input.contains("4") || input.contains("FOU") || input.contains("ATH") || input.contains("SPORTS")) {
                loop = false;
                athletics();
            } else if (input.contains("5") || input.contains("FIV") || input.contains("ACADEMICS") || input.contains("ACAD")) {
                loop = false;
                academics();
            } else if (input.contains("6") || input.contains("OTHER") || input.contains("OTH")) {
                Chatarea.append("Buzz : Please refer to the Georgia Tech website for information not contained in these categories\n");
                Chatarea.append("Do you have any more questions?\n");
                input = null;
                while (input == null) {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                if (input.contains("NO") || input.contains("NEIN")) {
                    loop = false;
                } else {
                    Chatarea.append("Buzz : Ok! Please refer to the category list and input what you need help with.\n");
                    input = null;
                }
            } else {
                Chatarea.append("Buzz : Please be more specific in regards to what category your question is contained in.\n");
                input = null;
            }
        }

    }


    public int weight(String input, String[] strings) {
        int counter = 0;
        for (String a : strings) {
            if (input.contains(a)) {
                counter++;
            }
        }
        return counter;
    }

    public int findMax(int[] input) {
        int greatest = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > input[greatest]) {
                greatest = i;
            }
        }
        return greatest;
    }

    public void anotherQuestion() {
        Chatarea.append("Buzz : Do you have another question today?\n");
        input = null;
        while (input == null) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        if (input.contains("YE") || input.contains("JA")) {
            questionList();
        } else {
            Chatarea.append("Buzz : Ok. Glad I could help. Have a nice day! :)\n");
        }
    }

    public void generalInfo() {
        Chatarea.append("Buzz : What is your general info related question?\n");
        input = null;
        while (input == null) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        int founding = weight(input, foundingWords);
        int location = weight(input, locationWords);
        int mission = weight(input, missionWords);
        int demographics = weight(input, demographicsWords);
        int faculty = weight(input, facultyWords);
        int contact = weight(input, contactWords);
        int size = weight(input, sizeWords);
        int grad = weight(input, gradWords);
        int mascot = weight(input, mascotWords);
        int startingSalary = weight(input, startingSalaryWords);
        int housing = weight(input, housingWords);
        int parking = weight(input, parkingWords);
        int safety = weight(input, safetyWords);
        int internet = weight(input, internetWords);
        int covid = weight(input, covidWords);
        int dining = weight(input, diningWords);
        int visiting = weight(input, visitingWords);
        int bus = weight(input, busWords);
        int funds = weight(input, fundsWords);
        int job = weight(input, jobWords);
        int health = weight(input, healthWords);
        int[] weights = new int[]{founding, location, mission, demographics, faculty, contact, size, grad, mascot, startingSalary, housing, parking, safety, internet, covid, dining, visiting, bus, funds, job, health};
        int max = findMax(weights);
        if (weights[max] == 0) {
            Chatarea.append("Buzz : We cannot answer your question at this time. \nPlease refer to the website for more information.\n");
            anotherQuestion();
            return;
        }
        switch (max) {
            case 0:
                Chatarea.append("Buzz : Georgia Tech was founded on October 13, 1885.\n");
                Chatarea.append("The goal of Tech's founding was to start the \n");
                Chatarea.append("conversion of the agrarian South to a more industrial society.\n");
                break;
            case 1:
                Chatarea.append("Buzz : Georgia Tech is located in beautiful Atlanta, Georgia.\n");
                break;
            case 2:
                Chatarea.append("Buzz : Georgia Tech's mission is to develop leaders who");
                Chatarea.append("advance technology and improve the human condition.\n");
                break;
            case 3:
                Chatarea.append("Buzz : Georgia Tech is considered to be highly diverse!\n");
                Chatarea.append("Though the student body is primarily Georgia, \n");
                Chatarea.append("Georgia Tech admits students from around the country and the world!\n");
                break;
            case 4:
                Chatarea.append("Buzz : The current president of Georgia Tech is Angel Cabrera.\n");
                Chatarea.append("More information about current faculty \ncan be found by looking on this website!\n");
                break;
            case 5:
                Chatarea.append("Buzz : You can contact Georgia Tech by calling 404.894.2000\n");
                break;
            case 6:
                Chatarea.append("Buzz : Georgia Tech has around 16,000 students.\n");
                break;
            case 7:
                Chatarea.append("Buzz : The graduation rate of Georgia Tech is 86%. Also, the acceptance rate is 25%.\n");
                break;
            case 8:
                Chatarea.append("Buzz : Georgia Tech's mascot is Buzz (me :) )!\n");
                break;
            case 9:
                Chatarea.append("Buzz : The average starting salary for a Georgia Tech grad is $70k \nbut it can vary depending on the major.\n");
                break;
            case 10:
                Chatarea.append("Buzz : Georgia Tech has a wide selection of residence \nhalls dedicated to housing first-year students.\n");
                Chatarea.append("Some dorms are located in the \nquiet and peaceful West side of campus.\nOther dorms are located in the lively East side of campus.\n");
                break;
            case 11:
                Chatarea.append("Buzz : There is free visitor parking on campus and full time \nstudents may purchase a parking pass for the semester on our website.\n");
                break;
            case 12:
                Chatarea.append("Buzz : Georgia Tech Police Department patrols around \ncampus 24/7 and makes sure campus is safe for all students.\n");
                break;
            case 13:
                Chatarea.append("Buzz : Georgia Tech provides free WiFi for its students and faculty members.\n");
                Chatarea.append("Internet speed can exceed 800 mbps.\n");
                break;
            case 14:
                Chatarea.append("Buzz : Georgia Tech has implemented a widespread testing \nservice across campus and masks are required inside all public buildings.\n");
                Chatarea.append("Please refer to the website for further \ninformation about our COVID policies.\n");
                break;
            case 15:
                Chatarea.append("Buzz : Georgia Tech offers several different meal \nplans that are tailored to different types of students.\n");
                Chatarea.append("Dining options can be found all across \ncampus, each offering their own delicious dishes.\n");
                Chatarea.append("Most meal plans offer four swipes (four meals) a day.\n");
                break;
            case 16:
                Chatarea.append("Buzz : Due to the current circumstances surrounding \nCovid-19, Georgia Tech is not currently offereing campus tours.\n");
                Chatarea.append("However, the Georgia Tech website offers virtual tours of the campus.\n");
                break;
            case 17:
                Chatarea.append("Buzz : Georgia Tech has several bus routes \nthat go all around on and off campus.\n");
                Chatarea.append("Because of this, most students \ndo not feel the need to bring a car to campus.\n");
                break;
            case 18:
                Chatarea.append("Buzz : Every student has a Buzz Card with \nmoney that can be used to make many on-campus purchases. Students with meal plans also have a dedicated balance, Dining Dollars, for purchasing on-campus meals.\n");
                Chatarea.append("To check or add to your balance, please refer to your Student eAccount.\n");
                break;
            case 19:
                Chatarea.append("Buzz : To check for campus job \nopenings or internships, please check our website.\n");
                Chatarea.append("Many students may qualify for a \nwork study so please follow up with financial aid if you're curious.\n");
                break;
            case 20:
                Chatarea.append("Buzz : Please see Stamps Health Services for your health related questions.\n");
                break;
        }
        anotherQuestion();
        return;

    }

    public void admissions() {
        Chatarea.append("Buzz : What is your admissions related question?\n");
        input = null;
        while (input == null) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        int process = weight(input, processWords);
        int rates = weight(input, ratesWords);
        int deadlines = weight(input, deadlinesWords);
        int stats = weight(input, statsWords);
        int contact = weight(input, contactWords);
        int transfer = weight(input, transferWords);
        int[] weights = new int[]{process, rates, deadlines, stats, contact, transfer};
        int max = findMax(weights);
        if (weights[max] == 0) {
            Chatarea.append("Buzz : We cannot answer your question at this time. \nPlease refer to the website for more information.\n");
            anotherQuestion();
            return;
        }
        switch (max) {
            case 0:
                Chatarea.append("Buzz : The holistic review for first-year applicants considers:\nAcademics\nStandardized Tests\nCommunity Service\nExtracurricular Engagement\nPersonal Essays\nRecommendations\nInterviews\nMajor Selection\n");
                break;
            case 1:
                Chatarea.append("Buzz : 2018-2019 rates\n");
                Chatarea.append("Acceptance Rate: 18.5%\n");
                Chatarea.append("Yield Rate: 41%\n");
                Chatarea.append("Waitlist Rate: 10%\n");
                break;
            case 2:
                Chatarea.append("Buzz : Application Deadlines\nEarly Action 1: Oct 15\nEarly Action 2: Nov 2\nRegular Decision: Jan 4\n");
                Chatarea.append("Decision Release Dates\nEarly Action 1: Mid-Dec\nEarly Action 2: Mid-Jan\nRegular Decision: Mid-March\n");
                break;
            case 3:
                Chatarea.append("Buzz : SAT range\nERW (25th-75th percentile): 630-730\nMath (25th-75th percentile): 670-780\n");
                Chatarea.append("ACT range\nEnglish (25th-75th percentile): 29-35\nMath (25th-75th percentile): 29-34\nComposite (25th-75th percentile): 29-34\n");
                Chatarea.append("Avg GPA of incoming freshman: 4.08\n");
                break;
            case 4:
                Chatarea.append("Buzz : Email: admission@gatech.edu\n");
                Chatarea.append("Phone Number: 404.894.4154\n");
                break;
            case 5:
                Chatarea.append("Buzz : The transfer application requires students to have taken select major-related courses.\nThe minimum GPA for the College of Computing is 3.3 and 3.0 for the other colleges at Tech.\n");
                Chatarea.append("Georgia Tech offers 3 different opportunities to apply: Fall, Spring, and Summer term.\n");
                break;
        }
        anotherQuestion();
        return;
    }

    public void finAid() {
        Chatarea.append("Buzz : What is your financial aid related question?\n");
        input = null;
        while (input == null) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        int fafsa = weight(input, fafsaWords);
        int scholarship = weight(input, scholarshipWords);
        int cost = weight(input, costWords);
        int loans = weight(input, loansWords);
        int contact = weight(input, contactWords);
        int[] weights = new int[]{fafsa, scholarship, cost, loans, contact};
        int max = findMax(weights);
        if (weights[max] == 0) {
            Chatarea.append("Buzz : We cannot answer your question at this time. \nPlease refer to the website for more information.\n");
            anotherQuestion();
            return;
        }
        switch (max) {
            case 0:
                Chatarea.append("Buzz : The deadline for priority consideration \nfor FAFSA and CSS applications is January 31st.\n");
                Chatarea.append("Georgia Tech also has proprietary application that must be completed to qualify for aid.\n");
                break;
            case 1:
                Chatarea.append("Buzz : There are both merit and need-based scholarships offered by Georgia Tech.\n");
                Chatarea.append("Please check the website for more information \nabout how to apply for these scholarships.\n");
                break;
            case 2:
                Chatarea.append("Buzz : Georgia Tech is $20k a year for in-state students and $50k a year for out of state students\n");
                break;
            case 3:
                Chatarea.append("Buzz : To apply for a loan, please complete the financial aid app and then check the website\n");
                Chatarea.append("In addition, you may qualify for a work study on campus!\n");
                Chatarea.append("It is our mission to make college as affordable as possible.\n");
                break;
            case 4:
                Chatarea.append("Buzz : You can contact the Financial Aid office at finaid@gatech.edu\n");
                break;
        }
        anotherQuestion();
        return;
    }

    public void athletics() {
        Chatarea.append("Buzz : What is your athletics related question\n");
        input = null;
        while (input == null) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        int crc = weight(input, crcWords);
        int schedule = weight(input, scheduleWords);
        int record = weight(input, recordWords);
        int intramurals = weight(input, intramuralsWords);
        int programs = weight(input, programsWords);
        int[] weights = new int[]{crc, schedule, record, intramurals, programs};
        int max = findMax(weights);
        if (weights[max] == 0) {
            Chatarea.append("Buzz : We cannot answer your question at this time. \nPlease refer to the website for more information.\n");
            anotherQuestion();
            return;
        }
        switch (max) {
            case 0:
                Chatarea.append("Buzz : GaTech's Campus Recreation Center provides \naccess to facilities like the gym, basketball court, swimming pool, and more!\n");
                Chatarea.append("All students are given free access to these facilities.\n");
                break;
            case 1:
                Chatarea.append("Buzz : The next football game is on Sept 12, against Florida State @ Florida State.\n");
                Chatarea.append("The next volleyball game is at 5:00 P.M. EST on Oct 22, against Clemson @ home.\n");
                Chatarea.append("The next women's cross country event is on Oct 30.\n");
                Chatarea.append("The next men's basketball game is TBA.\n");
                break;
            case 2:
                Chatarea.append("Buzz : Football: 2-2\nVolleyball: 5-1\n");
                break;
            case 3:
                Chatarea.append("Buzz : GaTech offers a wide selection of intramurals \nand recreational programs for students to engage in competitive sports!\nContact them at gtcompsports@gatech.edu or 404.894.9984.\n");
                break;
            case 4:
                Chatarea.append("Buzz : Georgia Tech has football, basketball, \nbaseball, softball, golf, tennis, and volleyball.\n");
                break;
        }
        anotherQuestion();
        return;
    }

    public void academics() {
        Chatarea.append("Buzz : What is your academics related question?\n");
        input = null;
        while (input == null) {
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        int majors = weight(input, majorWords);
        int difficulty = weight(input, difficultyWords);
        int registration = weight(input, registrationWords);
        int academicCalendar = weight(input, calendarWords);
        int ranking = weight(input, rankingWords);
        int[] weights = new int[]{majors, difficulty, registration, academicCalendar, ranking};
        int max = findMax(weights);
        if (weights[max] == 0) {
            Chatarea.append("Buzz : We cannot answer your question at this time. \nPlease refer to the website for more information.\n");
            anotherQuestion();
            return;
        }
        switch (max) {
            case 0:
                Chatarea.append("Buzz : Georgia Tech offers a total of 37 undergraduate majors and 46 minors.\n");
                break;
            case 1:
                Chatarea.append("Buzz : Yes, Tech can be difficult at times but we have a supportive community like no other.\n");
                break;
            case 2:
                Chatarea.append("Buzz : Please refer to Oscar to find out your \nregistration times and see the course directory.\n");
                break;
            case 3:
                Chatarea.append("Buzz : Please refer to the website to see the academic calendar.\n");
                break;
            case 4:
                Chatarea.append("Buzz : US news ranks Georgia Institute of Technology as #35 in the nation for national universities.\n");
        }
        anotherQuestion();
        return;

    }

    public static void main(String[] args) {
        new ChatBot2();
    }
}
