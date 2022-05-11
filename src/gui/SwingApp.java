/*
 * Project: GoL
 *
 * Copyright (c) 2004-2022,  Prof. Dr. Nikolaus
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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Skeleton of a Java Swing based GUI application.
 * @author nwulff
 *
 */
public abstract class SwingApp {
	private final JLabel status;
	private final JFrame mainWnd;
    public int w = 420;
    public int h = 480;
	/**
	 * Default constructor of a SwingApp providing a JFrame
	 * as main window of the application.
	 */
	public SwingApp() {
    	Dimension appSize = Toolkit.getDefaultToolkit().getScreenSize();

		mainWnd = new JFrame(" SwingApp ");
    	mainWnd.setBounds(appSize.width/2, appSize.height/2, w,h);
    	mainWnd.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mainWnd.setName("SwingApp:MainWindow");

		status = new JLabel();
		status.setName("SwingApp:StatusField");
		init(mainWnd);
	}
	/**
	 * Start the graphical presentation of the application.
	 */
    public void startUp() {
    	mainWnd.setVisible(true);
    }
    /**
     * Shut the application down, closing the window.
     */
    public void shutDown() {
    	mainWnd.setVisible(false);
    	mainWnd.dispose();
        System.out.println("bye, bye...");
        System.exit(0);
    }
    /**
     * Get the frame of this application.
     * @return JFrame instance
     */
    public JFrame getFrame() {
    	return mainWnd;
    }
    /**
     * Initialize the graphical components of this application.
     * @param frame to deploy the components within
     */
	protected void init(final JFrame frame) {
        frame.setJMenuBar(createMenuBar());
        frame.add(createKeyboard(), BorderLayout.CENTER);
        frame.add(createStatusBar(status), BorderLayout.NORTH);
        Component navi = createNavigator();
        if (navi != null) {
            frame.add(navi, BorderLayout.WEST);
        }
	}
	
    /**
     * Create a Navigation area for this application.
     * @return JComponent navigation
     */
    protected JComponent createNavigator() {
    	return null;
    }




    /**
     * Create the status bar for the gui  integrating the given statusField.
     * @param statusField field to use for messages
     * @return  JComponent status bar
     */
    protected abstract JComponent createStatusBar(final JLabel statusField);

    /**
     * Create the menu for the gui.
     * @return JMenuBar menubar to use
     */
    protected abstract JMenuBar createMenuBar();

    /**
     * Get the status value.
     * @return the status
     */
    protected final JLabel getStatusField() {
        return status;
    }

    /**
     * Set the status message.
     * @param msg String to display.
     */
    protected void setStatusMsg(String msg) {
        getStatusField().setText(msg);
    }

    protected abstract JPanel createKeyboard();
	
}
