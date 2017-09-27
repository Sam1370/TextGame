package sam1370.textgame;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class GameWindow extends WindowAdapter implements WindowListener, ActionListener, Runnable {
    private static String defaultInputFieldText = "> ";
    private JFrame frame;
    // private static JTextArea textArea;
    private static JTextArea textArea;
    private static JTextField inputField;
    private Thread reader;
    private Thread reader2;
    private boolean quit;
    Color bgColor = Color.BLACK;
    Color fgColor = Color.WHITE;
    float fontSize = 24.0f;

    private final PipedInputStream pin = new PipedInputStream();
    private final PipedInputStream pin2 = new PipedInputStream();

    public GameWindow() {

	// create all components and add them
	frame = new JFrame("TextGame, by Sam1370");
	frame.setBackground(bgColor);
	frame.setForeground(fgColor);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = new Dimension((int) (screenSize.width / 2), (int) (screenSize.height / 2));
	int x = (int) (frameSize.width / 2);
	int y = (int) (frameSize.height / 2);
	frame.setBounds(x, y, frameSize.width, frameSize.height);
	textArea = new JTextArea();
	textArea.setCaret(new NoTextSelectionCaret(textArea));
	DefaultCaret caret = (DefaultCaret) textArea.getCaret();
	caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	textArea.setLineWrap(true);
	textArea.setBackground(bgColor);
	textArea.setForeground(fgColor);
	File fontFile = new File("monaco.ttf");
	Font font = null;
	try {
	    font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	    font = font.deriveFont(fontSize);
	    textArea.setFont(font);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	textArea.setEditable(false);
	frame.getContentPane().setLayout(new BorderLayout());
	JScrollPane scrPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrPane.setBackground(bgColor);
	frame.getContentPane().add(scrPane, BorderLayout.CENTER);
	inputField = new JTextField(defaultInputFieldText, 20);
	inputField.setNavigationFilter(new NavigationFilterPrefixWithBackspace(2, inputField));
	inputField.setBackground(bgColor);
	inputField.setForeground(fgColor);
	inputField.addKeyListener(new KeyListener() {

	    @Override
	    public void keyPressed(KeyEvent ke) {
		CommandInitiator.keyPressed(ke);
	    }

	    @Override
	    public void keyReleased(KeyEvent ke) {
	    }

	    @Override
	    public void keyTyped(KeyEvent ke) {
	    }

	});

	if (font != null) {
	    inputField.setFont(font);
	}

	frame.getContentPane().add(inputField, BorderLayout.SOUTH);

	frame.setVisible(true);

	frame.addWindowListener(this);

	String outType = "UNKNOWNTYPE";
	try {
	    outType = "STDOUT";
	    PipedOutputStream pout = new PipedOutputStream(this.pin);
	    PrintStream prnt = new PrintStream(pout, true);
	    System.setOut(prnt);
	    outType = "STDERR";
	    PipedOutputStream pout2 = new PipedOutputStream(this.pin2);
	    PrintStream prnt2 = new PrintStream(pout2, true);
	    System.setErr(prnt2);
	} catch (Exception ex) {
	    textArea.append("Couldn't redirect " + outType + " to this console\n" + ex.getMessage());
	}

	quit = false; // signals the Threads that they should exit

	// Starting two separate threads to read from the PipedInputStreams
	//
	reader = new Thread(this);
	reader.setDaemon(true);
	reader.start();
	//
	reader2 = new Thread(this);
	reader2.setDaemon(true);
	reader2.start();
    }

    public static String getInputFieldText() {
	return inputField.getText();
    }

    public static void resetInputField() {
	inputField.setText(defaultInputFieldText);
    }

    public static void setCaretPosition() {
	textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public synchronized void windowClosed(WindowEvent evt) {
	quit = true;
	this.notifyAll(); // stop all threads
	try {
	    reader.join(1000);
	    pin.close();
	} catch (Exception e) {
	}
	try {
	    reader2.join(1000);
	    pin2.close();
	} catch (Exception ex) {
	}
	System.exit(0);
    }

    public synchronized void windowClosing(WindowEvent evt) {
	frame.setVisible(false); // default behavior of JFrame
	frame.dispose();
    }

    public synchronized void actionPerformed(ActionEvent evt) {
	textArea.setText("");
    }

    public synchronized void run() {
	try {
	    while (Thread.currentThread() == reader) {
		try {
		    this.wait(100);
		} catch (InterruptedException ie) {
		}
		if (pin.available() != 0) {
		    String input = this.readLine(pin);
		    textArea.append(input);
		}
		if (quit)
		    return;
	    }

	    while (Thread.currentThread() == reader2) {
		try {
		    this.wait(100);
		} catch (InterruptedException ie) {
		}
		if (pin2.available() != 0) {
		    String input = this.readLine(pin2);
		    textArea.append(input);
		}
		if (quit)
		    return;
	    }
	} catch (Exception e) {
	    textArea.append("\nConsole reports an Internal error.");
	    textArea.append("The error is: " + e);
	}

    }

    public synchronized String readLine(PipedInputStream in) throws IOException {
	String input = "";
	do {
	    int available = in.available();
	    if (available == 0)
		break;
	    byte b[] = new byte[available];
	    in.read(b);
	    input = input + new String(b, 0, b.length);
	} while (!input.endsWith("\n") && !input.endsWith("\r\n") && !quit);
	return input;
    }
}