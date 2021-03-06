/**
 * CS361 OOP project 3 GUI iteration
 * 
 * @author Erik Cohen
 * @author Dylan Tymkiw
 * @author Muqing Wen
 * @version 1.3
 * @since 1.0
*/

package proj3CohenTymkiwWen;

import java.util.Stack;

public class TextHistory
{
    private Stack<String> undo ;
    private Stack<String> redo;

    public TextHistory(){
        this.undo = new Stack<String>();
        this.redo = new Stack<String>();
    }

    public void save(String save) {
        this.redo.clear();
        this.undo.add(save);
    }

    public String undo() {
        if(! this.undo.empty()){
            String lastState = this.undo.pop();
            this.redo.add(lastState);
            if(! this.undo.empty()){
                return this.undo.peek();
            }
        }
        return null;
    }

    public String redo(){
        if(! this.redo.isEmpty()){
            String redoVal = this.redo.pop();
            this.undo.push(redoVal);
            return redoVal;
        }
        return null;
    }
}


