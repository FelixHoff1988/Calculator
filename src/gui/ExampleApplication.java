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

import calculations.MathBasics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



/**
 * Beispiel einer Swing Applikation mit Menu, ToolBar 
 * und einem Dialog.
 * @author nwulff
 *
 */
public class ExampleApplication extends SwingApp {
	public static boolean showComponents = false;
    public MathBasics basics = new MathBasics();
	/**
	 * 
	 */
	public ExampleApplication() {
		getFrame().setTitle("Beispiel einer Java Swing Applikation");
	}

	/**
	 * @return
	 * @see de.lab4inf.gui.SwingApp#createToolBar()
	 */
	@Override
	protected JComponent createToolBar() {
        JToolBar tb = new JToolBar(JToolBar.HORIZONTAL);
        if(showComponents) {
        	Border bo = new LineBorder(Color.green,3);
        	tb.setBorder(bo);
        }
        tb.setToolTipText("dies ist die ToolBar, teste die Buttons");
        JButton b;
        String name;
        for (int i = 0; i < 11; i++) {
            name = "Button:" + i;
            b = new JButton("" + i);
            b.setName(name);
            b.setToolTipText("Anzeige in der Status Zeile von " + name);
            tb.add(b);
            b.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent evt) {
                    final String fmt = "Evt: %s pressed";
                    JButton button = (JButton) evt.getSource();
                    setStatusMsg(String.format(fmt, button.getName()));
                }

            });
        }
        return tb;
	}

	/**
	 * @return
	 * @see de.lab4inf.gui.SwingApp#createContent()
	 */
	@Override
	protected JComponent createContent() {
        JTextPane content = new JTextPane();
        Dimension d = new Dimension(200, 400);
        content.setMinimumSize(d);
        String msg = "Hallo World! \n\n Mit einer beispielhaften Swing GUI\n\n"+
                " Probiere die Knöpfe in der ToolBar aus und achte auf den Status...";
        content.setText(msg);
        return content;
	}

	/**
	 * @param statusField
	 * @return
	 * @see de.lab4inf.gui.SwingApp#createStatusBar(javax.swing.JTextField)
	 */
	@Override
	protected JComponent createStatusBar(JTextField status) {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        JPanel statusBar = new JPanel(layout);
        if(showComponents) {
	        Border bo = new LineBorder(Color.red,2);
	        statusBar.setBorder(bo);
        }
        statusBar.setToolTipText("dies ist die StatusBar");
        String msg = "Hey die GUI scheint zu laufen :-)";
        Font font = status.getFont();
        int height = font.getSize() + 8;
        int width = 8 * msg.length();
        status.setText(msg);
        Dimension dim = new Dimension(width, height);
        status.setMaximumSize(dim);
        status.setMinimumSize(dim);
        status.setPreferredSize(dim);
        statusBar.add(new JLabel("Status: "));
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
	        Border bo = new LineBorder(Color.blue,5);
	        mb.setBorder(bo);
        }
        menu.setText("Menu-1");
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
        menu.setText("Menu-2");
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

    public JPanel newKey(JPanel GridBag, String nameButton, int xPos, int yPos, int width, int height, int gridwidth, int gridheight) {
        JButton button = new JButton(nameButton);
        button.setName(nameButton);
        GridBagConstraints gbc = new GridBagConstraints();
        button.setPreferredSize(new Dimension(width,height));
        gbc.gridx = xPos;
        gbc.gridy = yPos;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        GridBag.add(button, gbc);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                final String fmt = "Evt: %s pressed";
                switch (button.getName()) {
                    case "0":
                        basics.setValueOne(0);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "1":
                        basics.setValueOne(1);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "2":
                        basics.setValueOne(2);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "3":
                        basics.setValueOne(3);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "4":
                        basics.setValueOne(4);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "5":
                        basics.setValueOne(5);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "6":
                        basics.setValueOne(6);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "7":
                        basics.setValueOne(7);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "8":
                        basics.setValueOne(8);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "9":
                        basics.setValueOne(9);
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "+":
                        basics.addition(basics.getValueOne());
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "-":
                        basics.setOperator('-');
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "*":
                        basics.setOperator('*');
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "/":
                        basics.setOperator('/');
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "(":
                        basics.setOperator('(');
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case ")":
                        basics.setOperator(')');
                        setStatusMsg(String.format(fmt, button.getName()));
                        break;
                    case "=":
                        String res = Float.toString(basics.result);
                        setStatusMsg(res);
                        break;
                }


            }
        });
        return GridBag;
    }

    protected JPanel createKeyboard(){
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel GridBag = new JPanel(layout);

        newKey(GridBag, "(", 0,0, 60,40, 1, 1);
        newKey(GridBag, ")", 1,0, 60,40, 1, 1);
        newKey(GridBag, "del", 2,0, 60,40, 1, 1);
        newKey(GridBag, "C", 3,0, 60,40, 1, 1);

        newKey(GridBag, "^2", 0,1, 60,40, 1, 1);
        newKey(GridBag, "^x", 1,1, 60,40, 1, 1);
        newKey(GridBag, "^1/2", 2,1, 60,40, 1, 1);
        newKey(GridBag, "^1/n", 3,1, 60,40, 1, 1);

        newKey(GridBag, "7", 0,2, 60,40, 1, 1);
        newKey(GridBag, "8", 1,2, 60,40, 1, 1);
        newKey(GridBag, "9", 2,2, 60,40, 1, 1);
        newKey(GridBag, "+", 3,2, 60,40, 1, 1);

        newKey(GridBag, "4", 0,3, 60,40, 1, 1);
        newKey(GridBag, "5", 1,3, 60,40, 1, 1);
        newKey(GridBag, "6", 2,3, 60,40, 1, 1);
        newKey(GridBag, "-", 3,3, 60,40, 1, 1);

        newKey(GridBag, "1", 0,4, 60,40, 1, 1);
        newKey(GridBag, "2", 1,4, 60,40, 1, 1);
        newKey(GridBag, "3", 2,4, 60,40, 1, 1);
        newKey(GridBag, "*", 3,4, 60,40, 1, 1);

        newKey(GridBag, ",", 0,5, 60,40, 1, 1);
        newKey(GridBag, "0", 1,5, 60,40, 1, 1);
        newKey(GridBag, "=", 2,5, 60,40, 1, 1);
        newKey(GridBag, "/", 3,5, 60,40, 1, 1);

        return GridBag;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExampleApplication.showComponents = true;
        SwingApp app = new ExampleApplication();
        app.startUp();
    }
}
