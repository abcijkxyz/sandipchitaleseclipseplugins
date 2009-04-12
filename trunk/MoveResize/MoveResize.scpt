(* * Copy this script to ~/Library/Scripts folder so that it will appear in your Scritps menu. * Alternatively you can create a QuickSilver trigger for this script.  * * Author: Sandip V. Chitale*)on run	tell application "System Events"		set os_version to do shell script "sw_vers -productVersion"				if (os_version starts with "10.5") then			set _frontMostApp to (first process whose frontmost is true)		else if (os_version starts with "10.4") then			-- remember path to the active application			set frontmostAppPath to (path to frontmost application)			-- scan through processes to look for the process with same path			repeat with theApplication in application processes				if (file of theApplication is equal to frontmostAppPath) then					-- found it					set _frontMostApp to theApplication				end if			end repeat		end if				-- get first window of the active application		set _windowOne to window 1 of _frontMostApp				-- get it's coordinates		set {_x, _y} to position of _windowOne		set {_width, _height} to size of _windowOne				try			-- now launch the MoveResize SWT application to get new coordinates			set newBounds to do shell script "echo \"" & _x & ":" & _y & ":" & _width & ":" & _height & "\" | nc 127.0.0.1 6789"			-- if new coordinates were returned			if (length of newBounds is greater than 0) then				-- get the new coordinates				set newBounds to my split(newBounds, ":")								set _x to item 1 of newBounds				set _y to item 2 of newBounds				set _width to item 3 of newBounds				set _height to item 4 of newBounds								-- move and resize the window				set position of _windowOne to {_x, _y}				set size of _windowOne to {_width, _height}				set frontmost of _frontMostApp to true			end if		end try	end tellend runon split(someText, delimiter)	set AppleScript's text item delimiters to delimiter	set someText to someText's text items	set AppleScript's text item delimiters to {""} --> restore delimiters to default value	return someTextend split