
package IssueTracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class UndoRedo {
    
    //Create stack for undo and redo
    Stack<Character> undo = new Stack();
    Stack<Character> redo = new Stack();
    //Create stack specific for character deleted from backspace action
    Stack<Character> backspace = new Stack();
    String beforeDelete;
    int count;
    boolean backSpaceStatus = false;
    
    /**To call this class, 
     * Call in the Form Class's constructor
     * Create object - exp: UndoRedo UR = new UndoRedo(*redo button variable,undo button variable,text area variable *)
     * Reminder: No need Undo/RedobuttonActionPerformed because it already provided in this class :)
     * If there is any problem do tell me
    */
    public UndoRedo(JButton Redo,JButton Undo,JTextArea text) {
        
        text.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                textKeyPressed(e,text);
            }
            public void keyReleased(KeyEvent e) {
                textKeyReleased(e,text);
            }
        });
        
        Undo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                undoButtonActionPerformed(e, text);
            }
        });
        
        Redo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               redoButtonActionPerformed(e, text);
            }
        });
    }
    
    //Catch backspace key if pressed to get the text before deleted
    public void textKeyPressed(KeyEvent e,JTextArea text){
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            beforeDelete = text.getText();
        }
    }
    
    //Action performed for undo button
    public void undoButtonActionPerformed(ActionEvent evt, JTextArea text){
        try{
            
            String output = "";
            if(!backspace.empty()){         // if undo button is called after backspace button is pressed
                Character bs = backspace.pop(); //get the latest character that been deleted
                undo.push(bs);
                count++;
                for(int i = 0; i<count; i++){
                    output = output + undo.get(i); //display the character
                }
                text.setText(output);
                
            }
            else if(!undo.empty()){
                redo.push(undo.pop());
                count--;
                for(int i = 0; i<count; i++){
                   output = output + undo.get(i);
                }
                text.setText(output);
            }
        }
        catch(Exception e){
             undo = new Stack();
             redo = new Stack();
             backspace = new Stack();
             count = 0;
             backSpaceStatus = false;
             text.setText("");
        }
    }
    
    //Action performed for redo button
    public void redoButtonActionPerformed(ActionEvent evt,JTextArea text){
        try{
            String output = "";
            if(!redo.empty()){
                undo.push(redo.pop()); 
                count++;
                for(int i = 0; i<count; i++){
                    output = output + undo.get(i); //display the character
                }
                text.setText(output);
            }
        }
        catch(Exception e){
            undo = new Stack();
            redo = new Stack();
            backspace = new Stack();
            count = 0;
            backSpaceStatus = false;
            text.setText("");
        }
    }
    
    //Action after backspace key released
    public void textKeyReleased(KeyEvent evt,JTextArea text){
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
             String afterDelete = text.getText();
             int length = beforeDelete.length()-afterDelete.length(); //Get the difference lenght between the text before deleted and after deleted
             for(int i = 0; i< length; i++){
                 if(!undo.empty()){
                     backspace.push(undo.pop()); //push the character that have been deleted into backspace stack
                     count--;
                 }
             }
             redo = new Stack();// clear redo stack
             backSpaceStatus = true;
             
        }
          else if(evt.getKeyCode() != KeyEvent.VK_ALT 
                && evt.getKeyCode() != KeyEvent.VK_CAPS_LOCK
                && evt.getKeyCode() != KeyEvent.VK_CONTROL
                && evt.getKeyCode() != KeyEvent.VK_DELETE
                && evt.getKeyCode() != KeyEvent.VK_DOWN
                && evt.getKeyCode() != KeyEvent.VK_END
                && evt.getKeyCode() != KeyEvent.VK_ESCAPE
                && evt.getKeyCode() != KeyEvent.VK_HOME
                && evt.getKeyCode() != KeyEvent.VK_INSERT
                && evt.getKeyCode() != KeyEvent.VK_UP
                && evt.getKeyCode() != KeyEvent.VK_LEFT
                && evt.getKeyCode() != KeyEvent.VK_RIGHT
                && evt.getKeyCode() != KeyEvent.VK_PAGE_DOWN
                && evt.getKeyCode() != KeyEvent.VK_PAGE_UP
                && evt.getKeyCode() != KeyEvent.VK_PRINTSCREEN
                && evt.getKeyCode() != KeyEvent.VK_SHIFT
                && evt.getKeyCode() != KeyEvent.VK_TAB
                && evt.getKeyCode() != KeyEvent.VK_WINDOWS
                ){
              
                    if(backSpaceStatus==true){
                        if(text.getText().length()==0){
                            undo = new Stack(); // reset the undo stack
                        }
                        backspace = new Stack(); // reset the backspace stack if input anything after backspace
                        backSpaceStatus = false;

                    }
                    redo = new Stack(); //clear redo stack
                    undo.push(evt.getKeyChar());
                    count++;
            
        }
    }
    
    
}
