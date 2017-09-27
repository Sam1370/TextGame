package sam1370.textgame;

import javax.swing.text.*;

public class NoTextSelectionCaret extends DefaultCaret {

    /**
     * 
     */
    private static final long serialVersionUID = 3516650635924954885L;

    public NoTextSelectionCaret(JTextComponent textComponent) {
	setBlinkRate(textComponent.getCaret().getBlinkRate());
	textComponent.setHighlighter(null);
    }

    @Override
    public int getMark() {
	return getDot();
    }
}
