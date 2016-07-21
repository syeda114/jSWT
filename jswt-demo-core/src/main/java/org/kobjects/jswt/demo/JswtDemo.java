package org.kobjects.jswt.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class JswtDemo {

    static int clickCount = 0;

    public static void main (String [] args) {
        Display display = new Display();

        Shell shell = run(display);

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }

    public static Shell run(Display display) {
        Shell shell = new Shell (display);
        shell.setText("jSWT Demo");

        ScrolledComposite scrolledComposite = new ScrolledComposite(shell, 0);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        Composite leftBar = new Composite(scrolledComposite, 0);
        scrolledComposite.setContent(leftBar);
        scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));

        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.fill = true;
        leftBar.setLayout(rowLayout);

        final Label label = new Label(leftBar, 0);
        label.setText("Label");
        Text text = new Text(leftBar, 0);
        Button button = new Button(leftBar, 0);
        button.setText("Button");
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                label.setText("Click " + ++clickCount);
            }
        });

        DemoCanvas demoCanvas = new DemoCanvas(shell);
        demoCanvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
                true /* expand horizontally */, true /* expand vertically */));

        GridLayout gridLayout = new GridLayout(2, false);
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;

        Menu menuBar = new Menu(shell);
        MenuItem fileMenuItem = new MenuItem(menuBar, SWT.DROP_DOWN);
        fileMenuItem.setText("File");
        Menu fileMenu = new Menu(fileMenuItem);

        MenuItem aboutItem = new MenuItem(fileMenu, 0);
        aboutItem.setText("About");
        MenuItem openItem = new MenuItem(fileMenu, 0);
        openItem.setText("Open");

        shell.setMenuBar(menuBar);

        shell.setLayout (gridLayout);
        shell.pack ();
        shell.open ();
        return shell;
    }

}
