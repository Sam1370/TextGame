package sam1370.textgame;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class NavigationFilterPrefixWithBackspace extends NavigationFilter {
    private int prefixLength;
    private Action deletePrevious;

    public NavigationFilterPrefixWithBackspace(int prefixLength, JTextComponent component) {
	this.prefixLength = prefixLength;
	deletePrevious = component.getActionMap().get("delete-previous");
	component.getActionMap().put("delete-previous", new BackspaceAction());
	component.setCaretPosition(prefixLength);
    }

    @Override
    public void setDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias) {
	fb.setDot(Math.max(dot, prefixLength), bias);
    }

    @Override
    public void moveDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias) {
	fb.moveDot(Math.max(dot, prefixLength), bias);
    }

    class BackspaceAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6440974102467329134L;

	@Override
	public void actionPerformed(ActionEvent e) {
	    JTextComponent component = (JTextComponent) e.getSource();

	    if (component.getCaretPosition() > prefixLength) {
		deletePrevious.actionPerformed(null);
	    }
	}
    }
}