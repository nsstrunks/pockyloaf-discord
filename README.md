# Pockyloaf (Discord ver)

# Quickstart (tl;dr)
1. Reqs: Java 8+, Maven, Git client
2. git clone https://github.com/nsstrunks/pockyloaf-discord.git
3. Update src/main/resources/settings.props with your Discord bot's key
4. mvn clean install
5. java -jar target/pockyloaf-discord-1.0.0-SNAPSHOT.jar
 

# In-depth
1. Install Java 8+ JDK (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Install Git (https://git-scm.com/downloads)
  + Install a Git GUI (my preference is TortoiseGit - https://tortoisegit.org/download/)
3. Use the git client to clone this repository (cmd> git clone https://github.com/nsstrunks/pockyloaf-discord.git)
  + With TortoiseGit, right click in an empty folder - TortoiseGit> Clone> https://github.com/nsstrunks/pockyloaf-discord.git)
4. Download and extract Apache Maven 3.x (https://maven.apache.org/download.cgi)
5. Add the apache-maven-3.x.x/bin to the system path to make it easier to use later.
  + (On Windows) Start -> Control Panel -> System -> Advanced system settings -> Advanced -> Environment variables -> Under System variables click on Path and click "Edit" -> Add the path to where your apache-maven-3.x.x/bin folder is to the end.  Paths are separated by a semicolon (;)
6. Create a new Bot (Application) key at: https://discordapp.com/developers/applications/me
7. You'll need to add your bot to a server in which you have server admin access to or ask an admin to add your bot.
 + Replace <YOUR CLIENT ID> with your own application's id: https://discordapp.com/oauth2/authorize?client_id=<YOUR CLIENT ID HERE>&scope=bot&permissions=0
8. Update src/main/resources/settings.props with your Discord bot's key.
9. Open a command prompt and browse to where you cloned the repository in step 3.
10. Run the command: mvn clean install (if you get an error that "mvn" cannot be found, reread step 5)
11. This creates a jar file located in a "target" folder and can be run as any normal jar file
12. Run the jar file with: java -jar target/pockyloaf-discord-1.0.0-SNAPSHOT.jar
