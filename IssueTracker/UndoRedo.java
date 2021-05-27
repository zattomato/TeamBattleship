
package IssueTracker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class UndoRedo {
    
    /**To call this class, 
     * Call in the Form Class's constructor
     * Create object - exp: UndoRedo UR = new UndoRedo(*redo button variable,undo button variable,text area variable *)
     * Reminder: No need Undo/RedobuttonActionPerformed because it already provided in this class :)
     * If there is any problem do tell me
    */
    public UndoRedo(JButton Redo,JButton Undo,JTextArea text) {
        UndoManager um= new UndoManager();
        text.getDocument().addUndoableEditListener(
            new UndoableEditListener(){
                public void undoableEditHappened(UndoableEditEvent e){
                    um.addEdit(e.getEdit());
                }
            });
        
        Undo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(um.canUndo()){
                    um.undo();
                }
            }
        });
        
        Redo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(um.canRedo()){
                    um.redo();
                }
            }
        });
    }
    
    
}
