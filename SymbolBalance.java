import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class SymbolBalance implements SymbolBalanceInterface{

    String _symbolFile;
    MyStack stack = new MyStack();
    BalanceError _error; 
    

    public void setFile(String filename){
         _symbolFile = filename;
    }

    public BalanceError checkFile(){
        boolean error = false;
        int isComment = 0;
        try{
            File f = new File(_symbolFile); 
            Scanner symbolScanner = new Scanner(f);


            int line = 1;
            int count = 0;
            while(symbolScanner.hasNextLine()){
                    String checkString = symbolScanner.nextLine();
                    if (check(checkString, line, 0, stack, error, isComment)){
                        error = true;
                        break;
                     }
                    line++;
                    count = 0;
            }

            if(error){
                System.out.print("");
            }else{
                if (!stack.isEmpty())
                    _error = new NonEmptyStackError((char)stack.peek(), stack.size());
            }
            
        
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
  
        return _error;
    }
    
    
    

    private boolean check(String s, int line, int count, MyStack stack, boolean error, int isComment){
        char[] charChecker = s.toCharArray();
        char start = '"';
        char end = '"';
        
        for(char x: charChecker){
            char qoute = '"';
            char star = '*';
            char slash = '/';
            
            if (isComment == 0){
                if((x == star && charChecker[count-1] == slash )){
                    if(!stack.isEmpty() && stack.peek().equals(star)){
                       stack.pop();
                       stack.pop();
                    }else{
                        stack.push(slash);
                        stack.push(star);
                        isComment = 1;
                    }
                }else if(x == qoute){
                    stack.push(qoute);
                    isComment = 1;
                }else{
                    isComment = 0;
                    openCheck(x, line);
                    
                   if(closedCheck(x, line, error) != null){
                        return true;
                  }
                    
                }
            }else{
                if(x == slash && charChecker[count -1] == star){
                    if(!stack.peek().equals(qoute)){
                        stack.pop();
                        stack.pop();
                        isComment = 0;
                    }
                }else if(x == qoute){
                    stack.pop();
                    isComment = 0;
                }else{
                    isComment = 1;
                }
            }
            
            count++;
        }
        return false;
    }

        private void openCheck(char x, int line){
            if(x=='{' || x == '('|| x == '[')
                stack.push(x); 
        }


        private BalanceError closedCheck(char x, int line, boolean error){                                                                                       
    
            if(x == '}'){
                if (stack.isEmpty()){
                    _error = new EmptyStackError(line);
                    error = true;
                    return _error;
                    
                }else{   
                    if (stack.peek().equals('{') ) {
                        stack.pop();
                        return null;
                    }else{
                        _error = new MismatchError(line, x, (char)stack.peek());
                        error = true;
                        return _error;
                    }
                }
            }else if (x == ')'){
                 if (stack.isEmpty()){
                    _error = new EmptyStackError(line);
                    error = true;
                    return _error;
                   
                }else{
                    if (stack.peek().equals('(')){
                        stack.pop();
                        return null;
                    }else{
                        
                        _error = new MismatchError(line, x,(char)stack.peek());
                        error = true;
                        return _error;
                        
                    }
                }
            }else if (x == ']'){
                 if (stack.isEmpty()){
                    _error = new EmptyStackError(line);
                    error = true;
                    return _error;
                   
                }else{
                    if (stack.peek().equals('[')){
                        stack.pop();
                        return null;
                    }else{
                        _error = new MismatchError(line, x,(char)stack.peek());
                        error = true;
                        return _error;
                    }
                }
            }  
            return null; 
    }

}
