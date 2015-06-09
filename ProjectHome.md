

This project hosts Sandip Chitale's Eclipse plug-ins.

# Code Clips #

This Code Clips features allows creation of Code Clips.

## Code Clips Update Site ##

http://sandipchitaleseclipseplugins.googlecode.com/svn/trunk/CodeClipsUpdateSite

# Selection Explorer #

This Selection Explorer feature shows information about:

  * Active Part (this is somewhat similar to Plug-in spy action)
    * Part name
    * Part Id
    * Class implementing the part
    * Super class of the class implementing the part
    * Interfaces
    * Contributing Plugin
  * Active Selection
    * Class of selection objects
    * Superclass of selection object
    * Interfaces
    * Adapted Types
    * toString() value
  * Active Contexts
  * Active ActionSet Contexts

## Selection Explorer Update Site ##

http://sandipchitaleseclipseplugins.googlecode.com/svn/trunk/SelectionExplorerUpdateSite

# Close Views #

This feature provides commands related to closing views:

  * Window > Close (last active) View  (Control+Shit+V on windows and linux, Command+Shift+V on Mac) - This closes the last active view. You can invoke this command successively to close previously active views.
  * Window > Close All Views in Tab
  * Window > Close Other Views in Tab
  * Window > Close Other Views
  * Window > Close All Views - As such this closes all the open views. If all the views are already closed it offers to reset the perspectives. If all the view are already closed the user is prompted to restore the perspective - sort of a toggle. This will restore all the views of the perspective to original positions. If you wish, you can set a keybinding for this in the Window > Preferences > Keys preferences page.

When the above commands are invoked, if the workbench page was zoomed in i.e. any of the workbench part was maximized, it is first zoomed out and the user is prompted to confirm the whether or not to proceed with the action. The idea is that the user gets a chance to eyeball which view(s) will be affected by the action.

NOTE: There is a Close Part command provided by workbench, which is somewhat like Close View command but it treats both views and editors the same way even though workbench does not otherwise treat the views and editors the same way.

## Close Views Update Site ##

http://sandipchitaleseclipseplugins.googlecode.com/svn/trunk/CloseViewsFeatureUpdateSite/site.xml

# Key Strokes #

Key Strokes is a simple Eclipse plug-in to show the typed Key Strokes in a small, always-on-top window. Useful for doing Eclipse screen casts no matter which platform you are on.

The following screenshot shows the ![http://sandipchitalesmacosxstuff.googlecode.com/files/ks_control.gif](http://sandipchitalesmacosxstuff.googlecode.com/files/ks_control.gif) O (i.e. Ctrl+O) on Windows 7 and ![http://sandipchitalesmacosxstuff.googlecode.com/files/ks_command.gif](http://sandipchitalesmacosxstuff.googlecode.com/files/ks_command.gif) O (i.e. Command+O) on Mac in the small window - which is the key binding to bring up the Quick Outline of a file.

**Windows 7**
![http://sandipchitaleseclipseplugins.googlecode.com/files/KeyStrokes.png](http://sandipchitaleseclipseplugins.googlecode.com/files/KeyStrokes.png)

**Mac**
![http://sandipchitaleseclipseplugins.googlecode.com/files/KeyStrokesMac.png](http://sandipchitaleseclipseplugins.googlecode.com/files/KeyStrokesMac.png)

### Legend ###

  * ![http://sandipchitalesmacosxstuff.googlecode.com/files/ks_control.gif](http://sandipchitalesmacosxstuff.googlecode.com/files/ks_control.gif) (Control key)
  * ![http://sandipchitalesmacosxstuff.googlecode.com/files/ks_command.gif](http://sandipchitalesmacosxstuff.googlecode.com/files/ks_command.gif) (Command key on Mac)
  * ![http://sandipchitalesmacosxstuff.googlecode.com/files/ks_shift.gif](http://sandipchitalesmacosxstuff.googlecode.com/files/ks_shift.gif) (Shift key)
  * ![http://sandipchitalesmacosxstuff.googlecode.com/files/ks_option.gif](http://sandipchitalesmacosxstuff.googlecode.com/files/ks_option.gif) (Option key on Mac, Alt key on Windows)


## Key Strokes Update Site ##

http://sandipchitaleseclipseplugins.googlecode.com/svn/trunk/KeyStrokesUpdateSite

# All Instances #

As mentioned in the Eclipse help Java Development User Guide Tips and tricks Debugging section, when debugging with JavaSE-1.6 you can see all instances of a particular class. You can invoke this functionality via the popup menu (All Instances...) of Variables view rows for reference type values or in the Java editor by positioning the cursor on or selecting a reference type expression. However it is not possible to see all instances of an arbitrary class. The All Instances plug-in adds this functionality. It can be invoked using the:

  * Run > All Instances of Java Class...
  * All Instances of Java Class... toolbar buttons in the Variables and Expressions views

Once invoked it shows the customized Open Type dialog of JDT. Once you selects the class it adds the <Java Class> Instances expression to the Expressions view. It also shows the instances of any subclasses of the selected class. For example, when java.io.OutputStream is selected it shows the instances of it's subclasses also. In addition, an expression showing java.security.CodeSource info for the class is also added if that information is available.

**NOTE:** A class with a selected fully qualified name may have been loaded by different ClassLoaders. Entries for each class are shown. This is helpful in debugging issues related to class loading and seemingly mysterious ClassCastExceptions.

## All Instances Update Site ##

http://sandipchitaleseclipseplugins.googlecode.com/svn/trunk/AllInstancesUpdateSite

# Find/Replace Bar #

![http://sandipchitaleseclipseplugins.googlecode.com/files/FindReplaceBar.png](http://sandipchitaleseclipseplugins.googlecode.com/files/FindReplaceBar.png)

**Known issue: If you have customized the perspective, the Find bar view will be shown with a tab unlike the above screenshot. Try resetting the perspective and the tab may go away. I had mixed success with that though.**

Currently the Find/Replace Bar supports the following features:

  * Find as you type i.e. Incremental Search mode
  * Find Next/Find Previous. Same key bindings as Eclipse
  * Show the total number of occurrences in the document
  * Case sensitive mode
  * Whole word only mode
  * Regular Expression mode
  * Indicate illegal regular expression
  * Show Find/Replace dialog by pressing CTRL+F on Windows and Linux and COMMAND+F on Mac
  * Optionally override the standard Find/Replace Dialog of Eclipse. Control the override through preference page.
  * Enable/Disable Find/Replace Bar using preferences
  * Show Preferences button on the Find/Replace Bar
  * Press CTRL+F on Windows and Linux and COMMAND+F on Mac to show the Find/Replace Bar
  * Press ESCAPE to hide the Find/Replace bar
  * Find/Replace Bar works with text editors inside a Multi page editor e.g. plugin.xml XML editor inside the Plug-in Manifest editor.

I am planning to implement the following enhancements:

  * Full Replace/Find,Replace and Replace All support
  * Find in selection
  * Highlight current and other occurrences of the matched text
  * Highlight groups in regular expressions in different colors
  * Show the ordinal of the current match of the total
  * Show current line number and column range of the match
  * Make it work in Console and other views where Find/Replace dialog is applicable

## Find/Replace Bar Update Site ##

http://sandipchitaleseclipseplugins.googlecode.com/svn/trunk/FindReplaceBarUpdateSite/


# Update Site for other Plugins below #

http://sandipchitaleseclipseplugins.googlecode.com/svn/trunk/SandipChitalesEclipsePluginsUpdateSite/

# MultiPage Editor Tab Traverse #

The MultiPage editors such as plug-in manifest editor do not support navigation of tabs (pages of the editor) using keyboard. This plug-in fixes that by implementing two commands:

  * **Next Tab** - `CTRL+TAB`
  * **Previous Tab** - `CTRL+SHIFT+TAB`

**Note:** Use `COMMAND` key in place of CTRL on Mac OS.

You can always change the keyboard shortcuts using Preferences > General > Keys preference page.

## Screenshot ##

Starting with Overview tab:

![http://sandipchitaleseclipseplugins.googlecode.com/files/mpetto.png](http://sandipchitaleseclipseplugins.googlecode.com/files/mpetto.png)

Type `CTRL+TAB` to go to Dependencies tab:

![http://sandipchitaleseclipseplugins.googlecode.com/files/mpettd.png](http://sandipchitaleseclipseplugins.googlecode.com/files/mpettd.png)

Type `CTRL+SHIFT+TAB` instead to go to build.properties tab:

![http://sandipchitaleseclipseplugins.googlecode.com/files/mpettb.png](http://sandipchitaleseclipseplugins.googlecode.com/files/mpettb.png)

## Note on implementation ##

This will work for any MultiPage editor that subclasses `org.eclipse.ui.part.MultiPageEditorPart` and use the default `org.eclipse.swt.custom.CTabFolder` to implement the tab folder. The implenetation uses reflection to access protected methods.

  * `org.eclipse.ui.part.MultiPageEditorPart.getContainer()`
  * `org.eclipse.ui.part.MultiPageEditorPart.setActivePage(int)`

IMHO this should be provided by the implementation of `org.eclipse.ui.part.MultiPageEditorPart` itself. I filed an enhancement request for this [Issue 276626](https://bugs.eclipse.org/bugs/show_bug.cgi?id=276626).

## Installation ##

To install the plug-in, add the update site URL at the top of the page to Eclipse using Help > Software Updates... > Available Software Tab > Add Site.

# Sampler Plug-in #

The sampler plug-in adds a Color Sampler Toolbar. Color of any pixel on the desktop can be sampled by simply dragging the cursor from the Color Sampler label and copied to the clipboard in various formats as shown in the pop-up menu.

![http://sandipchitaleseclipseplugins.googlecode.com/files/colorsamplertoolbar2.png](http://sandipchitaleseclipseplugins.googlecode.com/files/colorsamplertoolbar2.png)

# Reverse Text Selection Plug-in #

![http://sandipchitaleseclipseplugins.googlecode.com/files/reversetextselection.png](http://sandipchitaleseclipseplugins.googlecode.com/files/reversetextselection.png)

**Commands**

  * **Reverse Text Selection** `Alt+Shift+/` - this command moves the text caret to the other end of the text selection in text editor. Repeated invocation of the command bounces the caret from one end of selection to the other while keeping the selection intact. This enables you to extend/contract the selection in either direction. You can change the key binding using **Preferences > General > Keys** page.

**Note:** Eclipse has commands to Set/Clear and Swap a Mark. The Mark is a remembered position in the text editor. The Set/Clear/Swap Mark functionality is more closer to the Emac's mark and dot functionality. Reverse Text Selection Plug-in specifically deals with the text selection endpoints and works better for me.

I have filed an enhancement request for incorporating this functionality in Eclipse text editors: https://bugs.eclipse.org/bugs/show_bug.cgi?id=270392

# Google Clips Plug-in #

Haven't you always wished for web based, live clipboard that you could share between Eclipse instances running on different computers. May be even share it with your buddies. Your wait is over. All you need is the Google Clips Plug-in and a Google Docs account. Google Clips is a Eclipse Plug-in that implements a web based shared clipboard using a Google Spreadsheet. Just create a Google spreadsheet named CLIPBOARD to make the plug-in work out of the box. You can of course change the name of spreadsheet you want to use as clipboard using **Preferences > General > Google Clips** page. If you share a the spreadsheet with your buddy you can share the clipboard.

**Commands**

  * **Paste Clip** `Alt+Shift+G Alt+Shift+V` - Paste the first clip. If the same command is used again within 2 seconds the next clip is pasted.
  * **Paste Clip from a pop-up dialog** `Alt+Shift+G P` - Paste the clips from a pop-up dialog.
  * **Toggle Auto clip cut and paste mode** `Alt+Shift+G T` - When the auto clip mode is on every cut and copied text is pushed to the shared clipboard.

**Google Clips Toolbar**

The toolbar showing the shared Google Clips.

![http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClips1.png](http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClips1.png)

**Google Clips Login Dialog**

![http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClipsLogin.png](http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClipsLogin.png)

**Google Clips Pop-up**

You can preview and insert specific clip using the pop-up dialog.

![http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClipsPopup.png](http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClipsPopup.png)

**Google Clips Preferences**

You can use the preferences page to configure your Google ID and the spreadsheet to use as clipboard.

![http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClipsPreferences.png](http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleClipsPreferences.png)

**Google Spreadsheet as a web based shared clipboard**

The Google spreadsheet on the web showing the same clips.

![http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleDocs.png](http://sandipchitaleseclipseplugins.googlecode.com/files/GoogleDocs.png)

# Screenshot Plug-in #

This plug-in lets you take screen shots from within Eclipse. It supports taking screen shots of:

**Screen shot Toolbar**

![http://sandipchitaleseclipseplugins.googlecode.com/files/ScreenshotToolbar5.png](http://sandipchitaleseclipseplugins.googlecode.com/files/ScreenshotToolbar5.png)

  * Whole desktop
  * Area of desktop - Click and drag the mouse to select a rectangular area of the desktop after the cursor turns to cross-hair.
  * Workbench Window
    * Specific Perspective - The screen shot is taken after switching the workbench to the specified perspective.
    * Specific View - The view is detached, the screen shot is taken and the view is attached again.
    * Specific Editor
    * Specific Preferences Page

The screen shot is taken 5 seconds after the invocation of the action. After the screen shot is taken you can:

  * Preview the screen shot
  * Save it to a file in .png, .gif, .jpg, .bmp or .ico format
  * Save it as a file inside workspace
  * Copy to system clipboard
  * Print

**Screen shot Preview Dialog**

![http://sandipchitaleseclipseplugins.googlecode.com/files/ScreenshotPreviewDialog7.png](http://sandipchitaleseclipseplugins.googlecode.com/files/ScreenshotPreviewDialog7.png)

## Click It! - Desktop screen shot utility ##

[ClickIt!](http://code.google.com/p/sandipchitaleseclipseplugins/source/browse/trunk/ClickIt/) is Eclipse project that builds a desktop variant of the screen shot plug-in. It installs an icon in System tray. Pop-up menu on the System Tray icon has actions to print the whole desktop or area of desktop. When a action is invoked the tray icon counts down 5 seconds letting you set up your desktop.

**Click It in System tray**

![http://sandipchitaleseclipseplugins.googlecode.com/files/ClickIt.png](http://sandipchitaleseclipseplugins.googlecode.com/files/ClickIt.png)

**Click It in action**

![http://sandipchitaleseclipseplugins.googlecode.com/files/ClickItInAction.png](http://sandipchitaleseclipseplugins.googlecode.com/files/ClickItInAction.png)

**Click It Preview Dialog**

![http://sandipchitaleseclipseplugins.googlecode.com/files/ClickItPreviewDialog.png](http://sandipchitaleseclipseplugins.googlecode.com/files/ClickItPreviewDialog.png)

To build the project checkout the project into your workspace. Then follow the instructions at [Developing SWT applications using Eclipse](http://www.eclipse.org/swt/eclipse.php). You can also export the runnable jar using File > Export > Java > Runnable Jar File.

# Reorder Plug-in #

The asymmetry in the way ,  (comma)  is used to separate the items in parameter and arguments lists always causes problem when one wants to reorder that list in Java editor.  Is that why Java allows trailing commas in array initializer? ;) may be.

The Reorder plug-in adds the following actions to the Java editor tool bar.

  * Swap backward (Ctrl+,)
  * Swap forward (Ctrl+.)

Basically the actions reorder the:

  * arguments of a class instance creation invocation
  * arguments of a method invocation
  * parameters of a method declaration
  * members of array initializer

and automatically adjust the ',' separator.

For example with caret at `|` in:

` void method(int iii, String |sss, boolean bbb){} `

pressing `Ctrl+.` (i.e. Control+period) or clicking on Swap forward tool bar button yields:

` void method(int iii, boolean bbb, String |sss){} `

or pressing `CTRL+,` (i.e. Control+comma) or clicking on Swap backward tool bar button with the original source yields:

` void method(String |sss, int iii, boolean bbb){} `

# Features Plug-ins Fragments Plug-in #

PDE has several views that shows the information about plug-ins. However there is no view (that I am aware of) which allows one to look at which Features contributed which Plug-ins and Fragments. This plug-in provides an action Help > List Features Plug-ins Fragments to show that information.

![http://sandipchitaleseclipseplugins.googlecode.com/files/FeaturesPluginsFragmentsInformationDialog.png](http://sandipchitaleseclipseplugins.googlecode.com/files/FeaturesPluginsFragmentsInformationDialog.png)

**Features Plug-ins Fragments Information in About Dialog > Configuration Details**

The Features Plug-ins Fragments is also displayed in About Dialog > Configuration Details.