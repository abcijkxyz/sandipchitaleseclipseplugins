package codeclips.templates;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateBuffer;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateVariable;

public class DocumentCodeClipsTemplateContext extends DocumentTemplateContext {

	public DocumentCodeClipsTemplateContext(TemplateContextType type, IDocument document, int offset, int length) {
		super(type, document, offset, length);
	}

	public DocumentCodeClipsTemplateContext(TemplateContextType type, IDocument document, Position position) {
		super( type, document, position);
	}
	
	static final String TAB_STOP_TYPES = "123456789"; //$NON-NLS-1$
	
	@Override
	public TemplateBuffer evaluate(Template template)
			throws BadLocationException, TemplateException {
		TemplateBuffer templateBuffer = super.evaluate(template);
		// Sort tab stop variable if any
		TemplateVariable[] variables = templateBuffer.getVariables();
		if (variables.length > 0) {
			List<TemplateVariable> tabStops = new LinkedList<TemplateVariable>();
			List<TemplateVariable> nonTabStops = new LinkedList<TemplateVariable>();
			for (int i = 0; i < variables.length; i++) {
				TemplateVariable variable = variables[i];
				if (variable.getType().length() == 1 && TAB_STOP_TYPES.contains(variable.getType())) {
					tabStops.add(variable);
				} else {
					nonTabStops.add(variable);
				}
			}
			if (tabStops.size() > 1) {
				Collections.sort(tabStops, new Comparator<TemplateVariable>() {
					public int compare(TemplateVariable o1, TemplateVariable o2) {
						return o1.getType().compareTo(o2.getType());
					}
				});
			}
			tabStops.addAll(nonTabStops);
			tabStops.toArray(variables);
		}
		return templateBuffer;
	}
}
