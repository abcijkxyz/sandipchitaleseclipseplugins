package eclipsemate;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class EnvironmentDialog extends Dialog {

	private Map<String, String> environment;
	
	private static Color ODD_ROW_COLOR;

	protected EnvironmentDialog(Shell shell, Map<String, String> environment) {
		super(shell);
		this.environment = new TreeMap<String, String>();
		this.environment.putAll(environment);
		this.environment.putAll(new ProcessBuilder("").environment());
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new FillLayout());

		Table table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		TableColumn valueColumn = new TableColumn(table, SWT.NONE);
		TableItem item;
		
		for (String name : environment.keySet()) {
			String value = environment.get(name);
			item = new TableItem(table, SWT.NONE);
			item.setText(new String[] {name, value});
		}
		
		table.setSelection(0);
		table.deselectAll();
		
		ODD_ROW_COLOR = new Color(parent.getDisplay(), 240,240, 250);
		TableItem[] items = table.getItems();
		for (int i = 0; i < items.length; i++) {
			if (i%2 == 0) {
				items[i].setBackground(ODD_ROW_COLOR);
			}
		}
		
		nameColumn.pack();
		valueColumn.pack();
		
		return composite;
	}
}
