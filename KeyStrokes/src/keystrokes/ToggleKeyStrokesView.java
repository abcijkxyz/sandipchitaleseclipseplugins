package keystrokes;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.bindings.keys.SWTKeySupport;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.keys.BindingService;
import org.eclipse.ui.keys.IBindingService;

@SuppressWarnings("restriction")
public class ToggleKeyStrokesView extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = getKeyStrokeViewShell();
		if (shell != null) {
			shell.setVisible(!shell.isVisible());
		}
		return null;
	}
	
	private static Shell keyStrokeViewShell;

	public static Shell getKeyStrokeViewShell() {
		if (keyStrokeViewShell == null) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			Display display = workbench.getDisplay();
			Font LARGE_FONT = new Font(display, JFaceResources.TEXT_FONT,
					32, SWT.NORMAL);
			Color BLACK = display.getSystemColor(SWT.COLOR_BLACK);
			Color WHITE = display.getSystemColor(SWT.COLOR_WHITE);
			keyStrokeViewShell = new Shell(display, SWT.TITLE | SWT.ON_TOP | SWT.NO_FOCUS);
			keyStrokeViewShell.setBackground(BLACK);
			GridLayout gridLayout = new GridLayout();
			gridLayout.marginWidth = 10;
			gridLayout.marginHeight = 10;
			keyStrokeViewShell.setLayout(gridLayout);

			final Label label = new Label(keyStrokeViewShell, SWT.CENTER | SWT.NO_BACKGROUND | SWT.NO_FOCUS);

			GridData labelGridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			label.setLayoutData(labelGridData);

			label.setFont(LARGE_FONT);
			label.setForeground(WHITE);
			label.setText("        ");
			Listener listener = new Listener() {
				public void handleEvent(Event event) {
					int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(event);
					label.setText(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator).format());
				}
			};
			IBindingService iBindingService = (IBindingService) workbench.getService(IBindingService.class);
			if (iBindingService instanceof BindingService) {
				BindingService bindingService = (BindingService) iBindingService;
				try {
					if ( bindingService.getKeyboard().getKeyDownFilter() != null) {
						display.removeFilter(SWT.KeyDown,  bindingService.getKeyboard().getKeyDownFilter());
					}
					display.addFilter(SWT.KeyDown, listener);
				} finally {
					if ( bindingService.getKeyboard().getKeyDownFilter() != null) {
						display.addFilter(SWT.KeyDown,  bindingService.getKeyboard().getKeyDownFilter());
					}
				}
			} else {
				display.addFilter(SWT.KeyDown, listener);
			}
			Rectangle displayBounds = display.getBounds();
			
			keyStrokeViewShell.setBounds(
					displayBounds.x+displayBounds.width-200,
					displayBounds.y+displayBounds.height-90,
					200,
					90);
		}
		return keyStrokeViewShell;
	}
}