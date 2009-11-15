package codeclips.templates;

import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CodeClipsContentAssistant extends ContentAssistant {
	
	private IContentAssistProcessor contentAssistProcessor;
	private final TabCompleteCodeClipsAction tabCompleteCodeClipsAction;
	
	private static class StringInformationPresenter implements IInformationPresenter {
		public String updatePresentation(Display display, String hoverInfo,
				TextPresentation presentation, int maxWidth, int maxHeight) {
			return hoverInfo;
		}
	}
	
	private static class DefaultInformationControlCreator extends AbstractReusableInformationControlCreator {
		public IInformationControl doCreateInformationControl(Shell shell) {
			DefaultInformationControl defaultInformationControl = new DefaultInformationControl(shell, new StringInformationPresenter());
			return defaultInformationControl;
		}
	}

	public CodeClipsContentAssistant(TabCompleteCodeClipsAction tabCompleteCodeClipsAction) {
		super();
		this.tabCompleteCodeClipsAction = tabCompleteCodeClipsAction;
		enableAutoActivation(false);
		enablePrefixCompletion(true);
		enableAutoInsert(true);
		enableColoredLabels(true);
		setStatusLineVisible(true);
		setStatusMessage("Type 1..9 to select nth snippet");
		setInformationControlCreator(new DefaultInformationControlCreator());
	}
	
	@Override
	public IContentAssistProcessor getContentAssistProcessor(
			String contentType) {
		if (contentAssistProcessor == null) {
			contentAssistProcessor = new CodeClipsCompletionProcessor(tabCompleteCodeClipsAction);
		}
		return contentAssistProcessor;
	}
	
}
