# Java settings converter
### What does it do
This code converts *org.eclipse.jdt.core.prefs* to XML format. 

It can be useful if you wanna upload your Java formatting settings online, so VSCode has access to it on different machines - [guide](https://github.com/redhat-developer/vscode-java/wiki/Formatter-settings). 

### How to use
1. In the Eclipse IDE, right-click on any Java project, go to `Properties`>`Java Code Style`>`Formatter`. 
2. Create a new formatting profile, do something with your settings and save it. 
3. Move *org.eclipse.jdt.core.prefs* from the *.settings* folder to the folder containing *Program*. 
4. Remove extra lines - anything that doesn't start with *org.eclipse.jdt.core.formatter*, for example:
    - *eclipse.preferences.version* (probably the first line);
    - *org.eclipse.jdt.core.compiler* (might be the next lines);
    - *org.eclipse.jdt.core.javaFormatter* (probably the last line)
5. Run the *Program* using any approach which seems the most convenient to you. On Linux you can do: 
```SHELL
$ javac Program.java   
$ java Program
```
6. Add this as the first line of the *eclipse-java-style.xml* file (also add any other lines you need, like profiles):
```XML
<?xml version="1.0" encoding="UTF-8"?>
```
7. Upload your *eclipse-java-style.xml* file somewhere and use its address in VSCode settings like in [the guide](https://github.com/redhat-developer/vscode-java/wiki/Formatter-settings).

### Feedback
This tool was designed with only purpose so I can use it once and never touch it again. If you actually found yourself in a situation where you need to get done what this tool is supposed to do, feel free to contact me via yisitlily@gmail.com and ask for advice. 
