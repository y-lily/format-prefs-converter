# Java Eclipse formatting prefs converter
### What does it do
This tool converts *org.eclipse.jdt.core.prefs* to XML format. 

It can be useful if you wanna upload your Java formatting settings online, so VSCode has access to it on different machines - [guide](https://github.com/redhat-developer/vscode-java/wiki/Formatter-settings). 

### How to use
1. Get your formatting settings file from Eclipse. 
2. Run the converter (currently, you can manually compile Converter.java and Program.java with `javac` and `java` commands. 
3. (Optional): pass your desired profile name as a command line argument.
4. Edit your profile name in the *eclipse-java-style.xml* file if you haven't done so in the step 3: 
```XML
<profile kind="CodeFormatterProfile" name="profile-name">
```
5. Upload your *eclipse-java-style.xml* file somewhere (e.g., make it a Github gist) and use its address and your profile name in VSCode settings like suggested in [the guide](https://github.com/redhat-developer/vscode-java/wiki/Formatter-settings).

### Feedback
This tool was designed with only purpose so I can use it once and never touch it again. If you actually found yourself in a situation where you need to get done what this tool is supposed to do, feel free to contact me via yisitlily@gmail.com and ask for advice. 
