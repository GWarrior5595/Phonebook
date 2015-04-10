import java.lang.String;
import java.io.*;
import java.util.*;
/** 
 * Project: fileIO
 * Description: This program will take in a file that holds information for contacts in a phonebook. It will provide functionalities such as:
 *	- viewing all contacts in a legible style
 *	- adding new contacts to the list
 *	- removing contacts from a list
 *	- editing the contents of a current contact (once the above is implemented)
 *
 * Created On:  02/19/2014
 * Mentor:      Barsam Dokh(bitchass)
 * Mentoree:    Erphun Ranjbar
 *
 * Modified On: 02/23/2014
 */
public class PhoneBook {
    // GLOBAL VARIABLES
    private final static String TITLE = "phonebookdata.txt";
    
    /*
     * Enum to clarify the different commands.
     */
    private enum Option {
        HELPNOUSAGE,// help command not producing usage information
        HELP,       // help command
        LISTA,      // list contacts ascending order
        LISTD,      // list contacts descending order
        FIND,       // find contacts with given parameters
        ADD,        // add a new contact
        REMOVE,     // remove a contact
        EDIT,       // edit a contact
        UPLOAD,     // upload the given contacts file to my contacts file
        CLEAN,      // cleans out all phone book contacts
        NONE        // None of the above
    }

    // ======================================================================
    //                      Implement other methods here
    // ====================================================================== 
    //TODO: create method
    private static void createFile(){

    }
    /**
     *List all the contacts in ascending order.
     */
    public static void listAscending() {
        try{
	        String inputFile = "contacts.txt";
	        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
	        String inputLine;
	        List<String> lineList = new ArrayList<String>();
	        bufferedReader.readLine();
	        while ((inputLine = bufferedReader.readLine()) != null) {
	            lineList.add(inputLine);
	        }
	        //TODO: WHY ISN'T IT IN ALPHA ORDER?!?!
	        Collections.sort(lineList);
	        for(String outputLine: lineList){
	        	String[] parseLn2=outputLine.split(",");
	        	if(parseLn2.length==9){
                    System.out.print("\n"+parseLn2[1]+ ", "+parseLn2[0]+" ("+parseLn2[2]+")");
                    System.out.print("\n");
                    System.out.println("Phone: "+parseLn2[3]);
                    System.out.println("Address: "+parseLn2[4]+" "+parseLn2[5]+" "+parseLn2[6]+" "+parseLn2[7]);
                    System.out.println("Notes: "+parseLn2[8]);
                    System.out.print("\n");
		        }
	        }
	        bufferedReader.close();
        }
        catch (Exception e){
        	System.err.println(( "Error - listDescending() - " + e.getMessage()));
            e.printStackTrace();
        }
   }

    /**
     * List all the contacts in descending order.
     */
    public static void listDescending() {
        try{
	        String inputFile = "contacts.txt";
	        BufferedReader bufferedreader = new BufferedReader(new FileReader(inputFile));
	        String inputLine2;
	        List<String> lineList2 = new ArrayList<String>();
	        inputLine2 = bufferedreader.readLine();
	        while ((inputLine2 = bufferedreader.readLine()) != null) {
	            lineList2.add(inputLine2);
	        }
	      //TODO: WHY ISN'T IT IN ANTI-ALPHA ORDER?!?!
	        Collections.sort(lineList2, Collections.reverseOrder());
	        for(String outputLine: lineList2){
	        	String[] parseLn2=outputLine.split(",");
	        	if(parseLn2.length==9){
                    System.out.print("\n"+parseLn2[1]+ ", "+parseLn2[0]+" ("+parseLn2[2]+")");
                    System.out.print("\n");
                    System.out.println("Phone: "+parseLn2[3]);
                    System.out.println("Address: "+parseLn2[4]+" "+parseLn2[5]+" "+parseLn2[6]+" "+parseLn2[7]);
                    System.out.println("Notes: "+parseLn2[8]);
                    System.out.print("\n");
		        }
	        }
	        bufferedreader.close();
        System.out.print("\n");
        }
        catch (Exception e){
        	System.err.println(( "Error - listDescending() - " + e.getMessage()));
            e.printStackTrace();
        }
    }

    /**
     * Find all contacts that contain the given keyword in any of
     * their fields.
     *
     * @param keyword is the keyword to search for in the contacts.
     */
    public static void find(String keyword) {
    	//TODO: FIX THE CASING
        System.out.println("Find contacts containing '" + keyword + "'");
        try{
            String inputFile = "contacts.txt";
            FileReader reader = new FileReader(inputFile);
            BufferedReader bufferedreader = new BufferedReader(reader);
            List<String> lineList2 = new ArrayList<String>();
            String inputLine2;
            
            while ((inputLine2 = bufferedreader.readLine()) != null) {
                lineList2.add(inputLine2);
            }
            
            for(String outputLine: lineList2){
                String[] parseLn2 = outputLine.split(",");
                
                for(int i=0;i<parseLn2.length;i++){
                    if(parseLn2[i].contains(keyword)){
                        System.out.print("\n"+parseLn2[1]+ ", "+parseLn2[0]+" ("+parseLn2[2]+")"+"\n");
                        System.out.println("Phone: "+parseLn2[3]);
                        System.out.println("Address: "+parseLn2[4]+" "+parseLn2[5]+" "+parseLn2[6]+" "+parseLn2[7]);
                        System.out.println("Notes: "+parseLn2[8]);
                        System.out.print("\n");
                    }
                }
            }
        }
        catch (Exception e){
            System.err.println(( "Error - Find() - " + e.getMessage()));
            e.printStackTrace();
        }

    }

    /**
     * Add a new contact to the phone book. When this command is
     * ran, it will ask the user one question at a time waiting
     * for them to respond a question at a time until all the 
     * files are answered.
     */
    public static void add() {
        System.out.println("Add a new contact");
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the first name: ");
        String FName=ob.nextLine();
        System.out.println("Enter the last name: ");
        String LName=ob.nextLine();
        System.out.println("Enter the age: ");
        String Age=ob.nextLine();
        System.out.println("Enter the phone number: ");
        String Phone =ob.nextLine();
        System.out.println("Enter the street address: ");
        String StreeAdd=ob.nextLine();
        System.out.println("Enter the city: ");
        String City=ob.nextLine();
        System.out.println("Enter the state: ");
        String State=ob.nextLine();
        System.out.println("Enter the Zipcode: ");
        String Zip = ob.nextLine();
        System.out.println("Enter any notes you have of the contact: ");
        String Notes = ob.nextLine();
        try{
            PrintWriter x = new PrintWriter(new FileWriter("contacts.txt", true));
            x.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",FName,LName,Age,Phone,StreeAdd,City,State,Zip,Notes));
            x.flush();
            x.close();
        }
        catch (Exception e){
            System.err.println(( "Error - add() - " + e.getMessage()));
            e.printStackTrace();
        }

    }

    /**
     * Remove the contact given firstOrLastName.
     *
     * @param firstOrLastName is the first or last name of the 
     *              contact to remove
     */
    public static void remove(String firstOrLastName) {
        System.out.println("remove contact " + firstOrLastName);
        try{
	        File inputFile = new File("contacts.txt");   // Your file  
	        File tempFile = new File("tempcontacts.txt");// temp file
	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
	        String currentLine;
	        while((currentLine = reader.readLine()) != null) {
	            if(currentLine.contains(firstOrLastName)) continue;
                writer.write(currentLine);
                writer.newLine();
	        }
	        writer.close();
	        boolean successful = tempFile.renameTo(inputFile);
	        System.out.println(successful);
        }
        catch (Exception e){
            System.err.println(( "Error - remove() - " + e.getMessage()));
            e.printStackTrace();
        }
    }


    /**
     * Edit the contact given its firstOrLastName. When this
     * command is ran, it will run just like the
     * <code>add()</code> method. However, if the user leaves
     * a field empty (i.e "First Name: ") and hits enter, the
     * current field will stay the same. If they fill in a field
     * (i.e "Phone Number: 1111111111") it will update the current
     * phone number to the new phone number entered.
     *
     * @param firstOrLastName is the first or last name of the
     *              contact to edit.
     */
    public static void edit(String firstOrLastName) {
        // TODO: implement this
        System.out.println("Edit contact " + firstOrLastName);
    }

    /**
     * Takes a file name to a phone book text file that contains
     * contacts and it will add all the new contacts to our
     * phone book data.
     *
     * @param filename is the name of the uploading phone book.
     */
    public static void upload(String filename) {
        // TODO: implement this
        System.out.println("Upload data from '" + filename + "'");
        try{
	        BufferedReader bufferedreader = new BufferedReader(new FileReader(filename));
	        String inputLine2; 
	        PrintWriter writtenfile = new PrintWriter(new FileWriter("contacts.txt", true));
	        //READ AND IGNORE HEADER, MOVES POINTER DOWN ONE LINE
	        bufferedreader.readLine();
	        //Reads every line from filename and writes it to phonebookdata.txt
	        while ((inputLine2 = bufferedreader.readLine()) != null) {
	        	
	        	writtenfile.println("\n"+inputLine2); 
	        }
	        writtenfile.flush();
	        writtenfile.close();  
        }
        catch (Exception e){
            System.err.println(( "Error - upload() - " + e.getMessage()));
            e.printStackTrace();
        }
    }
    
    /**
    *cleans out the phone book text file
    *
    */

    public static void clean(){
        //TODO: implement this
    }

    // ====================================================================== 
    //                      Do not edit past this point
    // ====================================================================== 

    /**
     * The main method. 
     *
     * @param args are the command arguments passed to this program.
     */
    public static void main(String[] args) {
        // If no arguments are given, show usage
        if (args.length == 0)
            usage();
        else {
            Option command = cmd(args);  
            if (command == Option.HELP)
                usage();
            // TODO: insert into command history here
        }
    }

    /*
     * Process the given command and return an enum of the command.
     */
    private static Option cmd(String[] cmd) {
        Option option = Option.NONE;
        if (cmd[0].length() > 1) {
            switch (cmd[0].toCharArray()[1]) {
                case 'h':
                    usage();
                    option = Option.HELPNOUSAGE;
                    break;
                case 'l':
                    if (cmd.length == 1) {
                        listAscending();
                        option = Option.LISTA;
                    }
                    else
                        option = Option.HELP;
                    break;
                case 'L':
                    if (cmd.length == 1) {
                        listDescending();
                        option = Option.LISTD;
                    }
                    else
                        option = Option.HELP;
                    break;
                case 'f':
                    if (cmd.length == 2) {
                        find(cmd[1]);
                        option = Option.FIND;
                    }
                    else
                        option = Option.HELP;
                    break;
                case 'a':
                    if (cmd.length == 1) {
                        add();
                        option = Option.ADD;
                    }
                    else
                        option = Option.HELP;
                    break;
                case 'r':
                    if (cmd.length == 2) {
                        remove(cmd[1]);
                        option = Option.REMOVE;
                    }
                    else
                        option = Option.HELP;
                    break;
                case 'e':
                    if (cmd.length == 2) {
                        edit(cmd[1]);
                        option = Option.EDIT;
                    }
                    else
                        option = Option.HELP;
                    break;
                case 'c':
                    if (cmd.length == 1) {
                        clean();
                        option = Option.CLEAN;
                    }
                    else
                        option = Option.HELP;
                    break;
                case 'u':
                    if (cmd.length == 2) {
                        upload(cmd[1]);
                        option = Option.UPLOAD;
                    }
                    else
                        option = Option.HELP;
                    break;
                default:
                    usage();
            }
        }
        return option;
    }
    
    /*
     * Display the usage of the program.
     */
    private static void usage() {
        System.out.println("usage: java PhoneBook [-h] [-l] [-L] [-a] [-e [fname | lname]]" + 
            "\t[-f <keyword>] [-r [fname | lname]] [-c] [-f <file>]");
        System.out.println("\t -h  -  help");
        System.out.println("\t -l  -  list all contacts in alphabetical order");
        System.out.println("\t -L  -  list all contacts in reverse alphabetical order");
        System.out.println("\t -f <keyword>  -  find all contacts that contain <keyword> in any part of their field"); 
        System.out.println("\t -a  -  adds a new contact");
        System.out.println("\t -r [fname | lname]  -  removes a contact given their first or last name");
        System.out.println("\t -e [fname | lname]  -  edits a contacts information give their first or last name");
        System.out.println("\t -c  -  cleans out all contacts in the phonebook");
        System.out.println("\t -u <file>  -  uploads and adds contacts from the given <filename>");
    }
}
