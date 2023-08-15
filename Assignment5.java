import java.util.Scanner;

public class Assignment5{
    private static final Scanner Scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[32;1m";
        final String COLOR_PINK="\033[35m";
        final String RESET = "\033[0m";

        final String DASHBOARD = " Welcome to Smart Banking App";
        final String CREATE_NEW_ACCOUNT = " Create New Account";
        final String DEPOSIT = "Deposit";
        final String WITHDRAWLS = "Withdrawls";
        final String TRANSFER = "Transfer";
        final String CHECK_ACCOUNT_BALANCE = "Check Account Balance";
        final String DELETE_ACCOUNT = "Delete Account";


        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        String[] nameArray = new String[0];
        int[] Balance = new int[0];

        String screen = DASHBOARD;

        do{
            final String APP_TITLE = String.format("%s%s%s",COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");
            
            switch(screen){
                case DASHBOARD :
                    System.out.println(COLOR_PINK+"[1]. Create New Account"+RESET);
                    System.out.println("[2]. Deposite");
                    System.out.println(COLOR_PINK+"[3]. Withdraw"+RESET);
                    System.out.println("[4]. Transfer");
                    System.out.println(COLOR_PINK+"[5]. Check Account Balance"+RESET);
                    System.out.println("[6]. Delete Account");
                    System.out.println(COLOR_PINK+"[7]. Exit\n"+RESET);
                    System.out.print(COLOR_GREEN_BOLD+"\tEnter an option to continue: "+RESET);
                    int option = Scanner.nextInt();
                    Scanner.nextLine();
                    
                    switch(option){
                        case 1: screen=CREATE_NEW_ACCOUNT;break;
                        case 2: screen=DEPOSIT;break;
                        case 3: screen=WITHDRAWLS;break;
                        case 4: screen=TRANSFER;break;
                        case 5: screen=CHECK_ACCOUNT_BALANCE;break;
                        case 6: screen=DELETE_ACCOUNT;break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }
                    break;

                case CREATE_NEW_ACCOUNT:
                    System.out.printf(COLOR_GREEN_BOLD+"Account Number :"+RESET+" %s - %s%04d %s \n",("SDB"),COLOR_BLUE_BOLD,(nameArray.length+1),RESET);

                    boolean valid=false;
                    String name;
                    System.out.println();

                    do{
                        valid=false;
                        System.out.print("Enter the Name :");
                         name = Scanner.nextLine().strip();
                        if(name.isBlank()){
                            System.out.printf(ERROR_MSG,"Name can't be empty");
                            valid=true;
                            continue;
                        }
                        for(int i=0;i<name.length();i++){
                            if(!(Character.isLetter(name.charAt(i)))){
                                System.out.printf(ERROR_MSG,"Invalid Name");
                                valid=true;
                                break;
                            }

                        }
                        
                    }while(valid);
                    boolean valid2=false;
                    int initialBalance;
                    do{
                        valid2=false;
                        System.out.print("Enter Initial Deposit Value :");
                        initialBalance = Scanner.nextInt();
                        Scanner.nextLine();
                        
                        
                        if(initialBalance<5000){
                            System.out.printf(ERROR_MSG,"Insufficient Deposit Amount");
                            valid2=true;
                            continue;

                        }

                    }while(valid2);

                    String[] newNameArray = new String[nameArray.length + 1];
                    int[] newBlance = new int[nameArray.length + 1];
                    for (int i = 0; i < nameArray.length; i++) {
                        newNameArray[i] = nameArray[i];
                        newBlance[i] = Balance[i];
                    }
                    newNameArray[newNameArray.length - 1] = name;
                    newBlance[newBlance.length - 1] = initialBalance;
                    nameArray = newNameArray;
                    Balance = newBlance ;
                    System.out.println();
                    System.out.printf(SUCCESS_MSG,"Name,Account no has been created sucessfully!!! \n");
                    System.out.print(COLOR_BLUE_BOLD+"Do you want add another(Y/N) =>");
                    if (Scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;
       
            }


        }while(true);
    }
}