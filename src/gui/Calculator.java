/*
 * Project: GoL
 *
 * Copyright (c) 2004-2022,  Prof. Dr. Nikolaus Wulff
 * University of Applied Sciences, Muenster, Germany
 * Lab for computer sciences (Lab4Inf).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package gui;

import calculations.Input;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


/**
 * Beispiel einer Swing Applikation mit Menu, ToolBar 
 * und einem Dialog.
 * @author nwulff
 *
 */
public class Calculator extends SwingApp {
	public static boolean showComponents = false;

    public Input input = new Input();
    public Dimension dim;
	/**
	 * 
	 */
	public Calculator() {
		getFrame().setTitle("Signum");
	}

	/**
	 * @param statusField
	 * @return
	 * @see de.lab4inf.gui.SwingApp#createStatusBar(javax.swing.JTextField)
	 */
	@Override
	protected JComponent createStatusBar(JLabel status) {
        FlowLayout layout = new FlowLayout(FlowLayout.RIGHT);
        JPanel statusBar = new JPanel(layout);
        status.setHorizontalAlignment(SwingConstants.RIGHT);
        if(showComponents) {

            statusBar.setBackground(Color.white);
	        statusBar.setBorder(new LineBorder(Color.DARK_GRAY,1));
        }
        String msg = "0";
        Font font = status.getFont();
        int height = (font.getSize() + 8)*3;
        int width = 390;
        status.setText(msg);
        dim = new Dimension(width, height);
        status.setMaximumSize(dim);
        status.setMinimumSize(dim);
        status.setPreferredSize(dim);
        statusBar.add(status);
        return statusBar;
	}

	/**
	 * @return
	 * @see de.lab4inf.gui.SwingApp#createMenuBar()
	 */
	@Override
	protected JMenuBar createMenuBar() {
        JMenuBar mb = new JMenuBar();
        mb.setToolTipText("Dies ist die MenuBar");
        JMenu menu = new JMenu();
        JMenuItem item;
        if(showComponents) {
	        Border bo = new LineBorder(Color.gray,1);

	        mb.setBorder(bo);
        }
        menu.setText("File");
        menu.setToolTipText("Nur \"exit\" funktioniert! ");
        mb.add(menu);

        item = new JMenuItem("TutGarNichts");
        item.setToolTipText("macht nichts");
        menu.add(item);
        item = new JMenuItem("TutNichts");
        item.setToolTipText("macht noch weniger als nichts");
        menu.add(item);
        menu.addSeparator();
        item = new JMenuItem("Exit");
        menu.add(item);
        item.setToolTipText("Ende der Anwendung");
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                shutDown();
            }

        });
        menu = new JMenu();
        menu.setText("Settings");
        menu.setToolTipText("hier gibt's noch nichts zu gucken");
        mb.add(menu);
        
        // for the Help menu to be at the right side!
        mb.add(Box.createHorizontalGlue());
        menu = new JMenu();
        menu.setText("Help");
        menu.setToolTipText("Viel Hilfe gibt es noch nicht...");
        item = new JMenuItem("About");
        item.setToolTipText("startet einen modalen Dialog");
        item.addActionListener((evt)-> {
	        	setStatusMsg("starting JDialog");
	        	JDialog dialog = new JDialog(getFrame(),"Hilfe");
	        	dialog.setModal(true);
	        	dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	        	Rectangle bounds = getFrame().getBounds();
	        	int w = bounds.width/2;
	        	int h = bounds.height/2;
	        	bounds.width-=w;
	        	bounds.height-=h;
	        	bounds.x+=w/2;
	        	bounds.y+=h/2;
	        	dialog.setBounds(bounds);
	        	JButton ok = new JButton("ok");
	        	ok.setToolTipText("schließt den Dialog");
	        	ok.addActionListener((e)->{dialog.setVisible(false); setStatusMsg("Dialog closed");});
	        	JTextField about = new JTextField();
	        	about.setText("Demo GUI Applikation mit sperrendem Dialog");
	        	dialog.add(about,BorderLayout.CENTER);
	        	dialog.add(ok,BorderLayout.SOUTH);
	        	dialog.setVisible(true);
        });
        menu.add(item);
        mb.add(menu);

        return mb;
	}

    public JPanel newButton(JPanel GridBag, String nameButton, int xPos, int yPos, int gridwidth, int gridheight) {
        JButton button = new JButton(nameButton);
        button.setName(nameButton);
        Color transparent = new Color(0f,0f,0f,0f);
        button.setForeground(transparent);

        button.setBackground(transparent);

        char chara[] = new char[nameButton.length()];
        chara = nameButton.toCharArray();
        button.setBorder(new DrawButton(20,chara));
        GridBagConstraints gbc = new GridBagConstraints();
        GridBag.setBorder(new EmptyBorder(3,3,3,3));
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets= new Insets(2,2,2,2);
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = xPos;
        gbc.gridy = yPos;
        GridBag.add(button, gbc);
        actionHandler(button);
        return GridBag;
    }

    public void actionHandler(JButton pbutton) {
        pbutton.addActionListener(evt -> {
        switch (pbutton.getName()) {
            case "0":
                setStatusMsg(input.zeroPressed());
                break;
            case "1":
                setStatusMsg(input.numPressed("1"));
                break;
            case "2":
                setStatusMsg(input.numPressed("2"));
                break;
            case "3":
                setStatusMsg(input.numPressed("3"));
                break;
            case "4":
                setStatusMsg(input.numPressed("4"));
                break;
            case "5":
                setStatusMsg(input.numPressed("5"));
                break;
            case "6":
                setStatusMsg(input.numPressed("6"));
                break;
            case "7":
                setStatusMsg(input.numPressed("7"));
                break;
            case "8":
                setStatusMsg(input.numPressed("8"));
                break;
            case "9":
                setStatusMsg(input.numPressed("9"));
                break;
            case "+":
                setStatusMsg((input.operatorPressed(" + ")));
                break;
            case "-":
                setStatusMsg((input.operatorPressed(" - ")));
                break;
            case "*":
                setStatusMsg((input.operatorPressed(" * ")));
                break;
            case "/":
                setStatusMsg((input.operatorPressed(" / ")));
                break;
            case "(":
                setStatusMsg(input.openBracketPressed());
                break;
            case ")":
                setStatusMsg(input.closeBracketPressed());
                break;
            case ",":
                setStatusMsg(input.commaPressed());
                break;
            case "=":
                setStatusMsg(input.equalPressed());
                break;
            case "C":
                setStatusMsg(input.clearPressed());
                break;
            case "del":
                setStatusMsg(input.delPressed());
        }
    });
    }

    protected JPanel createKeyboard(){
        GridBagLayout layout = new GridBagLayout();
        JPanel GridBag = new JPanel(layout);

        newButton(GridBag, "(", 0,0,1, 1);
        newButton(GridBag, ")", 1,0, 1, 1);
        newButton(GridBag, "del", 2,0, 1, 1);
        newButton(GridBag, "C", 3,0, 1, 1);

        newButton(GridBag, "^2", 0,1, 1, 1);
        newButton(GridBag, "^x", 1,1, 1, 1);
        newButton(GridBag, "^1/2", 2,1, 1, 1);
        newButton(GridBag, "^1/n", 3,1, 1, 1);

        newButton(GridBag, "7", 0,2, 1, 1);
        newButton(GridBag, "8", 1,2, 1, 1);
        newButton(GridBag, "9", 2,2, 1, 1);
        newButton(GridBag, "+", 3,2, 1, 1);

        newButton(GridBag, "4", 0,3, 1, 1);
        newButton(GridBag, "5", 1,3, 1, 1);
        newButton(GridBag, "6", 2,3, 1, 1);
        newButton(GridBag, "-", 3,3, 1, 1);

        newButton(GridBag, "1", 0,4, 1, 1);
        newButton(GridBag, "2", 1,4, 1, 1);
        newButton(GridBag, "3", 2,4, 1, 1);
        newButton(GridBag, "*", 3,4, 1, 1);

        newButton(GridBag, ",", 0,5, 1, 1);
        newButton(GridBag, "0", 1,5, 1, 1);
        newButton(GridBag, "=", 2,5, 1, 1);
        newButton(GridBag, "/", 3,5, 1, 1);

        return GridBag;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Calculator.showComponents = true;
        SwingApp app = new Calculator();
        app.startUp();
    }
}
